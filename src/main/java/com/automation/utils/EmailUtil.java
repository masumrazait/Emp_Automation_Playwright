package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * Email Utility class for sending test reports via email
 */
public class EmailUtil {
    private static final Logger logger = LogManager.getLogger(EmailUtil.class);

    /**
     * Send email with Extent Report attachment after test completion
     */
    public static void sendTestReportEmail() {
        String enabled = ConfigReader.getProperty("email.notification.enabled", "false");
        if (!Boolean.parseBoolean(enabled)) {
            logger.info("Email notification is disabled. Skipping email send.");
            return;
        }

        String host = ConfigReader.getProperty("email.smtp.host", "smtp.gmail.com");
        String port = ConfigReader.getProperty("email.smtp.port", "587");
        final String username = ConfigReader.getProperty("email.username", "");
        final String password = ConfigReader.getProperty("email.password", "");
        String recipients = ConfigReader.getProperty("email.recipients", "");
        String from = ConfigReader.getProperty("email.from", username);

        if (username.isEmpty() || password.isEmpty() || recipients.isEmpty()) {
            logger.warn("Email credentials not configured. Please set email.username, email.password, and email.recipients in config.properties");
            return;
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            message.setSubject("Employee Automation - Test Execution Report");

            // Build email body
            String body = buildEmailBody();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            // Attach Extent Report
            String reportPath = ExtentReportManager.getReportFilePath();
            File reportFile = new File(reportPath);
            if (reportFile.exists()) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(reportFile);
                multipart.addBodyPart(attachmentPart);
                logger.info("Extent Report attached to email: " + reportPath);
            } else {
                logger.warn("Extent Report file not found at: " + reportPath);
            }

            // Attach Cucumber HTML report if exists
            File cucumberReport = new File("target/cucumber-reports/cucumber-pretty.html");
            if (cucumberReport.exists()) {
                MimeBodyPart cucumberAttachment = new MimeBodyPart();
                cucumberAttachment.attachFile(cucumberReport);
                multipart.addBodyPart(cucumberAttachment);
                logger.info("Cucumber Report attached to email");
            }

            message.setContent(multipart);
            Transport.send(message);
            logger.info("Test report email sent successfully to: " + recipients);

        } catch (Exception e) {
            logger.error("Failed to send test report email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Build HTML email body with test summary
     */
    private static String buildEmailBody() {
        String appUrl = ConfigReader.getProperty("app.url", "N/A");
        String env = ConfigReader.getProperty("env", "N/A");
        String browser = ConfigReader.getProperty("browser.type", "N/A");

        return "<html><body style='font-family: Arial, sans-serif; color: #333;'>"
                + "<div style='max-width: 600px; margin: 0 auto; padding: 20px;'>"
                + "<h2 style='color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px;'>"
                + "Employee Management System - Test Execution Report</h2>"
                + "<table style='width: 100%; border-collapse: collapse; margin: 20px 0;'>"
                + "<tr style='background-color: #f2f2f2;'><td style='padding: 10px; border: 1px solid #ddd;'><strong>Environment</strong></td>"
                + "<td style='padding: 10px; border: 1px solid #ddd;'>" + env + "</td></tr>"
                + "<tr><td style='padding: 10px; border: 1px solid #ddd;'><strong>Application URL</strong></td>"
                + "<td style='padding: 10px; border: 1px solid #ddd;'><a href='" + appUrl + "'>" + appUrl + "</a></td></tr>"
                + "<tr style='background-color: #f2f2f2;'><td style='padding: 10px; border: 1px solid #ddd;'><strong>Browser</strong></td>"
                + "<td style='padding: 10px; border: 1px solid #ddd;'>" + browser + "</td></tr>"
                + "<tr><td style='padding: 10px; border: 1px solid #ddd;'><strong>Execution Time</strong></td>"
                + "<td style='padding: 10px; border: 1px solid #ddd;'>" + new java.util.Date() + "</td></tr>"
                + "</table>"
                + "<p style='color: #7f8c8d; font-size: 14px;'>Please find the detailed Extent Report attached with this email.</p>"
                + "<p style='color: #7f8c8d; font-size: 12px; margin-top: 30px; border-top: 1px solid #ddd; padding-top: 10px;'>"
                + "This is an automated email from Employee Management System Automation Framework.</p>"
                + "</div></body></html>";
    }
}
