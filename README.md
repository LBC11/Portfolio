# Portfolio

A personal portfolio web page project.

## Technologies Used

The technologies and versions used in this project are as follows:

- Database: MariaDB (version 10.10.3)
- Backend: Spring Boot (version 2.7.11)
  - Build Tool: Gradle (Groovy)
  - Packaging: JAR
  - Language: Java (version 11)
- Frontend: React
  - npm (version 9.6.4)
  - Node.js (version 18.12.1)
  - Yarn (version 1.22.19)
## Folder Structure

The folder structure for running the project is as follows:

- portfolio-react: folder containing React code
- portfolio-spring: folder containing Spring code
- sql_backup: folder containing portfolio_backup.sql file
## Getting Started

### 1. Install MariaDB:

- If MariaDB is already installed, proceed to the next step.
- If MariaDB is not installed, download and install MariaDB from https://mariadb.org/download/.

### 2. Create Database:

  1. Connect to MySQL client.
  2. Execute the command "CREATE DATABASE portfolio;".
  3. Run "SOURCE {location of portfolio_backup.sql file};" command.

### 3. Check Java 11 Installation:

- If Java 11 is already installed, proceed to the next step.
- If Java 11 is not installed, download and install Java 11 from https://www.oracle.com/java/technologies/downloads/#jdk11.
### 4. Check Gradle Installation:

- If Gradle is already installed, proceed to the next step.
1. Download Gradle: Visit the Gradle releases page at https://gradle.org/releases/ and download the latest version of Gradle. You can choose between the Binary-only and Complete versions. The Binary-only version is sufficient for basic use, while the Complete version includes additional examples and documentation.
2. Extract the archive: Extract the downloaded file to an appropriate location, such as C:\Gradle. Remember this folder, as it will be your Gradle home directory.
3. Set environment variables: You need to add Gradle to your system path and set the GRADLE_HOME environment variable. To do this, follow these steps:
    - Open 'System' from the Control Panel, then click on 'Advanced system settings'.
    - Click the 'Environment Variables' button.
    - In the 'System variables' section, click 'New' to create a new system variable. Set the variable name as GRADLE_HOME and the variable value to the path of the Gradle folder you extracted earlier (e.g., C:\Gradle\gradle-7.3.3).
  d. Locate and select the 'Path' system variable, then click 'Edit'. Add a new entry with %GRADLE_HOME%\bin.
4. Verify the installation: To verify the installation, open a command prompt and type gradle -v or gradle --version. If installed correctly, you should see the Gradle version information displayed.

### 5. Configure MariaDB connect settings in portfolio-spring/src/main/resources/application.properties:

- spring.datasource.url=jdbc:mariadb://localhost:{port number}/portfolio
- spring.datasource.username={user name}
- spring.datasource.password={user password}
### 6. Run the Spring Boot Application:

  1. In the terminal, navigate to the root directory of the project(spring).
  2. Execute "gradlew clean build".
  3. Run the JAR file generated in the build/libs (Gradle) directory using the following command: "java -jar {file_name}.jar".

### 7. Check Node.js Installation:

If Node.js is already installed, proceed to the next step.
If Node.js is not installed, download and install the LTS version from https://nodejs.org/en/download.
### 8. Install Necessary Packages:

Install the necessary packages.

- react: 18.2.0
- react-dom: 18.2.0
- react-chartjs-2: 5.2.0
- chart.js: 4.2.1
- chartjs-adapter-date-fns: 3.0.0
- axios: 1.3.6

If any of these packages are not installed, use the following command to install them:

```bash
npm install react react-dom react-chartjs-2 chart.js chartjs-adapter-date-fns axios

```

### 9. Run React

- In the terminal, navigate to the portfolio-react folder and run the project(React) through the "npm start".
- If everything is set up correctly, the portfolio web page will be accessible at http://localhost:3000 in your web browser.

![image](https://github.com/LBC11/Portfolio/assets/107410759/23f72b15-9ed1-4470-8277-7cb77e25bc02)

## REST API Documentation with Swagger
This project utilizes Swagger for REST API documentation. Once the Spring server is up and running, you can access the REST API documentation at http://localhost:8080/swagger-ui/index.html.
