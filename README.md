# WebTerminal with MySQL Integration
#### Command line terminal via web browsers, for SSH/Telnet/TN3270 accesses (xterm.js with Java backend)

This modified version of the WebTerminal project integrates MySQL to allow authentication via stored user credentials, expanding the original features with enhanced user management capabilities.

## Project Origin and Original Author
This project is based on the original **WebTerminal** project developed by [zpgu](https://github.com/zpgu/WebTerminal). The original project provides foundational functionality for terminal access through web browsers with a Java backend and xterm.js integration. This modified version builds upon that foundation by adding MySQL integration to support authentication and user management through a database.

## Why another tool for terminal access?
While there are plenty of tools available for terminal access (in Node.js, Python, etc.), this project offers:
* A unique Java backend with added support for MySQL authentication.
* Additional features like session sharing, suspend/resume functionality, and screen size propagation.

This application provides **terminal** access to any reachable device directly in your browser (using xterm.js). Key features include:
- **Session sharing** and **suspend/resume** options.
- **Multiple access modes** (SSH, Telnet, TN3270) for compatibility with various device types.
- Compatibility with older terminal/console servers through pty access.
- MySQL-based **login authentication**, leveraging stored user data to control access and manage roles.

## MySQL Integration for User Authentication
With MySQL support, this application now authenticates users based on credentials stored in a MySQL database. This enhancement replaces the previous CSV-based proof of concept, providing a more secure and scalable method for user authentication and role assignment.

### Requirements
- Java 11 or above (due to dependencies)
- Maven (compatible with your Java version)
- Linux/Unix-based server for full functionality
- MySQL database configured with user credential storage

### How to Build and Run

```bash
# Clone the repository
git clone https://github.com/heechanCho/WebTerminal_DB
cd WebTerminal

# Build the project
mvn clean install

# Run the application
java -jar target/WebTerminal-0.9-SNAPSHOT.jar --spring.config.location=classpath:/application.yml
