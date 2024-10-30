# WebTerminal with MySQL Integration
#### Command line terminal via web browsers, for SSH/Telnet/TN3270 accesses (xterm.js with Java backend)

This modified version of the WebTerminal project integrates MySQL to allow authentication via stored user credentials, expanding the original features with enhanced user management capabilities.

## Project Origin and Original Author
This project is based on the original **WebTerminal** project developed by [zpgu](https://github.com/zpgu/WebTerminal). The original project provides foundational functionality for terminal access through web browsers with a Java backend and xterm.js integration. This modified version builds upon that foundation by adding MySQL integration to support authentication and user management through a database.

## 웹터미널과 DB
기본의 zpgu님의 프로젝트를 DB와 연동했습니다. 
DB는 MYSQL을 사용하였고

저장된 유저정보를 통하여 Spring Security를 통하여 인증하고 접근하는 기능을 추가했습니다.
배우고 있는 학생이라 미숙한 부분은 가르침을 부탁드립니다. 감사합니다.
