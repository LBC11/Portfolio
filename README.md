# Portfolio

A personal portfolio web page project.

## Technologies Used

The technologies and versions used in this project are as follows:

- Database: MariaDB (version 10.9.3)
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

- Apply the portfolio_backup.sql file to create a database named 'portfolio' in the MariaDB.

### 3. Check Java 11 Installation:

- If Java 11 is already installed, proceed to the next step.
- If Java 11 is not installed, download and install Java 11 from https://www.oracle.com/java/technologies/downloads/#jdk11.
### 4. Check Gradle Installation:

- If Gradle is already installed, proceed to the next step.
- If Gradle is not installed, download and install Gradle from https://gradle.org/releases/.
### 5. Configure MariaDB settings in portfolio-spring/src/main/resources/application.properties:

- spring.datasource.url=jdbc:mariadb://localhost:{port number}/portfolio
- spring.datasource.username={user name}
- spring.datasource.password={user password}
### 6. Run the Spring Boot Application:

1. Open Power shell and navigate to the directory containing the Spring Boot application.
2. Run the gradlew bootRun command to start the Spring Boot application.

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

- In the terminal, navigate to the portfolio-react folder and run through the "npm start".
- If everything is set up correctly, the portfolio web page will be accessible at http://localhost:3000 in your web browser.

![image](https://user-images.githubusercontent.com/107410759/233843051-68ddc39c-e7cd-4315-83b9-50c3a43c2b32.png)

## REST API Documentation with Swagger
This project utilizes Swagger for REST API documentation. Once the Spring server is up and running, you can access the REST API documentation at http://localhost:8080/swagger-ui/index.html.
