@echo off
REM Wrapper to ensure 'mvn' resolves in CI when Maven isn't on the agent PATH
SET MAVEN_HOME=%~dp0apache-maven-3.9.4
"%MAVEN_HOME%\bin\mvn.cmd" %*

