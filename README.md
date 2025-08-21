# N11-Test-Case

## Quick Start

- Required tools: Java, Maven, Google Chrome, internet access
- Run:
  - Execute tests: mvn clean test
  - Allure report (static output): mvn allure:report (output target/site/allure-maven-plugin)

## Notes

- The project uses TestNG and Selenium 4. The TestNG suite is configured at src/test/resources/regression.xml; maven-surefire-plugin picks it up automatically
- With Selenium 4.35+, Selenium Manager automatically downloads and manages ChromeDriver. If you encounter driver issues, you can set the driver manually using the system property: -Dwebdriver.chrome.driver=/path/to/chromedriver
- If a JDK is not found, install one (e.g., Temurin). On macOS, brew install temurin may help, and ensure JAVA_HOME is set if necessary
