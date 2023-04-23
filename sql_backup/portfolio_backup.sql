-- MariaDB dump 10.19  Distrib 10.10.3-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: portfolio
-- ------------------------------------------------------
-- Server version	10.10.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `affiliation_descriptions`
--

DROP TABLE IF EXISTS `affiliation_descriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affiliation_descriptions` (
  `affiliation_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `FK1ukk8ukua982ocbs33mwgn6gv` (`affiliation_id`),
  CONSTRAINT `FK1ukk8ukua982ocbs33mwgn6gv` FOREIGN KEY (`affiliation_id`) REFERENCES `professional_affiliations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affiliation_descriptions`
--

LOCK TABLES `affiliation_descriptions` WRITE;
/*!40000 ALTER TABLE `affiliation_descriptions` DISABLE KEYS */;
INSERT INTO `affiliation_descriptions` VALUES
(1,'Participated in an intensive algorithm training program provided by Samsung DX, focusing on strengthening problem-solving skills and enhancing understanding of various algorithmic concepts.'),
(1,'Engaged in hands-on learning through practical exercises and real-world examples, improving overall programming and algorithmic proficiency.'),
(1,'Successfully solved 45 out of 56 problems and attended all 28 lectures, meeting the completion criteria for the program.'),
(1,'Expected to receive a completion certificate by the end of April.');
/*!40000 ALTER TABLE `affiliation_descriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `awards_achievements`
--

DROP TABLE IF EXISTS `awards_achievements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `awards_achievements` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_received` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKekk93vjgmq7johh7ax26vsy7r` (`personal_information_id`),
  CONSTRAINT `FKekk93vjgmq7johh7ax26vsy7r` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `awards_achievements`
--

LOCK TABLES `awards_achievements` WRITE;
/*!40000 ALTER TABLE `awards_achievements` DISABLE KEYS */;
INSERT INTO `awards_achievements` VALUES
(1,'2022-12-01 09:00:00.000000','Fintech Intellectual Property Online Quiz Competition','Silver Prize in Finance',1),
(2,'2022-11-01 09:00:00.000000','University Coding Competition','Encouragement Award',1),
(3,'2021-10-01 09:00:00.000000','Global Challenger Competition','Silver Prize in Domestic Category',1);
/*!40000 ALTER TABLE `awards_achievements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certifications`
--

DROP TABLE IF EXISTS `certifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certifications` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_received` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfw1vlkf9kn5nqok3whwelu34e` (`personal_information_id`),
  CONSTRAINT `FKfw1vlkf9kn5nqok3whwelu34e` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certifications`
--

LOCK TABLES `certifications` WRITE;
/*!40000 ALTER TABLE `certifications` DISABLE KEYS */;
INSERT INTO `certifications` VALUES
(1,'2019-01-01 09:00:00.000000','5.5','IELTS',1);
/*!40000 ALTER TABLE `certifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `degree` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlbi4gileo5l4lprc8lpbt899n` (`personal_information_id`),
  CONSTRAINT `FKlbi4gileo5l4lprc8lpbt899n` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES
(1,'Bachelor of Information Technology and Management',NULL,'Seoul National University of Science and Technology','Information Technology Management','2018-03-01 09:00:00.000000',1),
(2,'Information Technology Management for Business BSc(Hons)',NULL,'Northumbria University','Information Technology Management','2018-03-01 09:00:00.000000',1);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_descriptions`
--

DROP TABLE IF EXISTS `education_descriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_descriptions` (
  `education_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `FKmu86j88jqc2ghuxev16wkto8d` (`education_id`),
  CONSTRAINT `FKmu86j88jqc2ghuxev16wkto8d` FOREIGN KEY (`education_id`) REFERENCES `education` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_descriptions`
--

LOCK TABLES `education_descriptions` WRITE;
/*!40000 ALTER TABLE `education_descriptions` DISABLE KEYS */;
INSERT INTO `education_descriptions` VALUES
(1,'Actively engaged in academic coursework, focusing on Information Technology Management within the Department of Industrial Engineering.'),
(1,'Developed a strong foundation in various IT and management concepts through rigorous coursework and hands-on projects.'),
(1,'Gained practical experience in areas such as Mobile Programming, Programming Language, algorithms, Software Engineering.'),
(1,'Registered courses this semester: Information Security / Algorithm / Consultancy Project / IT Project Management'),
(2,'Dual Degree');
/*!40000 ALTER TABLE `education_descriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_information`
--

DROP TABLE IF EXISTS `personal_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth` datetime(6) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information`
--

LOCK TABLES `personal_information` WRITE;
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` VALUES
(1,'1998-04-02 09:00:00.000000','Bachelor of Information Technology and Management','wpdltm4@gmail.com','https://github.com/LBC11','First language Korean, proficient in reading and writing in English','Seoul, South Korea','Byungchan Lee (Bob)','Korean','010-4758-8763','Seoul National University of Science and Technology');
/*!40000 ALTER TABLE `personal_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professional_affiliations`
--

DROP TABLE IF EXISTS `professional_affiliations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professional_affiliations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK405y70rujpebnridmhghseiri` (`personal_information_id`),
  CONSTRAINT `FK405y70rujpebnridmhghseiri` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professional_affiliations`
--

LOCK TABLES `professional_affiliations` WRITE;
/*!40000 ALTER TABLE `professional_affiliations` DISABLE KEYS */;
INSERT INTO `professional_affiliations` VALUES
(1,'2023-03-31 09:00:00.000000','Samsung DX Algorithm Intensive Lecture','Samsung DX division','2023-01-01 09:00:00.000000',1);
/*!40000 ALTER TABLE `professional_affiliations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_descriptions`
--

DROP TABLE IF EXISTS `project_descriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_descriptions` (
  `project_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `FKmm9l4ng756x4mem4fsexhy0pa` (`project_id`),
  CONSTRAINT `FKmm9l4ng756x4mem4fsexhy0pa` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_descriptions`
--

LOCK TABLES `project_descriptions` WRITE;
/*!40000 ALTER TABLE `project_descriptions` DISABLE KEYS */;
INSERT INTO `project_descriptions` VALUES
(1,'Developed a user-location based to-do list application for Android device'),
(1,'Implemented back-end functionality using Kotlin, Spring Boot, and JPA'),
(1,'Set up server infrastructure with Spring Boot'),
(1,'Integrated Firebase Authentication for secure user sign-in and management'),
(1,'Utilized Retrofit and Coroutine to establish communication between the Spring server and Android client'),
(1,'Incorporated Google Maps API to enable map-based features and location services within the application'),
(2,'Developed a blog-style resource sharing platform to help ITM students easily understand complex concepts and difficult content, leveraging seniors\' study materials and experiences.'),
(2,'Aimed to create a community for sharing resources and exchanging knowledge in the ITM field.'),
(2,'Focused on the planning and analysis stages of service development rather than code implementation.'),
(2,'Conducted functional requirements analysis and non-functional requirements analysis.'),
(2,'Created use case diagrams, class diagrams, and sequence diagrams to effectively visualize and plan the service structure.'),
(3,'Developed a web service to assess negativity bias using data obtained from Twitter'),
(3,'Conducted web crawling with AWS Lambda to collect relevant Twitter data'),
(3,'Performed sentiment analysis on collected data to evaluate negativity bias in user-generated content');
/*!40000 ALTER TABLE `project_descriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `technologies` varchar(255) DEFAULT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo42102dao8xafy95e3cqcutcy` (`personal_information_id`),
  CONSTRAINT `FKo42102dao8xafy95e3cqcutcy` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES
(1,'2022-12-01 09:00:00.000000','User-Location based To-do list Android Application','2022-10-01 09:00:00.000000','Kotlin (Android), Firebase Authentication, Firebase Realtime DB, Mongo DB, Java, Spring Boot, JPA, MySQL',1),
(2,'2022-12-01 09:00:00.000000','ITM Study Resource Sharing Platform(itmWiki)','2022-10-01 09:00:00.000000','Functional & Non-Functional Requirements Gathering, User Story Writing, Use Case Modelling, Sequence Diagramming, UML Design',1),
(3,'2022-06-01 09:00:00.000000','Twitter Data-based Negativity Bias Verification Web Service','2022-04-01 09:00:00.000000','Python, AWS Lambda, Apache Spark, AWS S3, Crontab',1);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_grades`
--

DROP TABLE IF EXISTS `semester_grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester_grades` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gpa` double NOT NULL,
  `semester` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm3tsjhk7npr1k55kniim3qie5` (`personal_information_id`),
  CONSTRAINT `FKm3tsjhk7npr1k55kniim3qie5` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_grades`
--

LOCK TABLES `semester_grades` WRITE;
/*!40000 ALTER TABLE `semester_grades` DISABLE KEYS */;
INSERT INTO `semester_grades` VALUES
(1,3.42,1,1,1),
(2,3.47,2,1,1),
(3,4,1,2,1),
(4,3.67,2,2,1),
(5,3.92,1,3,1),
(6,4.25,2,3,1);
/*!40000 ALTER TABLE `semester_grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_categories`
--

DROP TABLE IF EXISTS `skill_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `skills_and_techniques_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqgtat4tvkq0n9rp4g1amii8f9` (`skills_and_techniques_id`),
  CONSTRAINT `FKqgtat4tvkq0n9rp4g1amii8f9` FOREIGN KEY (`skills_and_techniques_id`) REFERENCES `skills_and_techniques` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_categories`
--

LOCK TABLES `skill_categories` WRITE;
/*!40000 ALTER TABLE `skill_categories` DISABLE KEYS */;
INSERT INTO `skill_categories` VALUES
(1,'Business Analysis/Solution Design Skills',1),
(2,'Programming Languages/Frameworks',1),
(3,'Tools',1);
/*!40000 ALTER TABLE `skill_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `skill_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbxu95fg0qot0t3wenbv212edf` (`skill_category_id`),
  CONSTRAINT `FKbxu95fg0qot0t3wenbv212edf` FOREIGN KEY (`skill_category_id`) REFERENCES `skill_categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES
(1,'Functional & Non-Functional Requirements Gathering',1),
(2,'User Story Writing',1),
(3,'SWOT Analysis',1),
(4,'Use Case Modelling',1),
(5,'Sequence Diagramming',1),
(6,'UML Design',1),
(7,'Entity Relationship Design',1),
(8,'Java',2),
(9,'Kotlin',2),
(10,'Web (Spring Boot)',2),
(11,'Mobile (Android)',2),
(12,'SQL',2),
(13,'Object-Oriented Programming (OOP)',2),
(14,'Python',2),
(15,'AWS Lambda',2),
(16,'Apache Spark',2),
(17,'AWS S3',2),
(18,'MariaDB',3),
(19,'JPA',3),
(20,'GitHub',3),
(21,'Draw.io',3),
(22,'IntelliJ',3),
(23,'MS Excel',3),
(24,'MS Word',3),
(25,'Google Drive',3),
(26,'Crontab',3);
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills_and_techniques`
--

DROP TABLE IF EXISTS `skills_and_techniques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills_and_techniques` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personal_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqy317s0ht7f9yvrn5xbpj674e` (`personal_information_id`),
  CONSTRAINT `FKqy317s0ht7f9yvrn5xbpj674e` FOREIGN KEY (`personal_information_id`) REFERENCES `personal_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills_and_techniques`
--

LOCK TABLES `skills_and_techniques` WRITE;
/*!40000 ALTER TABLE `skills_and_techniques` DISABLE KEYS */;
INSERT INTO `skills_and_techniques` VALUES
(1,1);
/*!40000 ALTER TABLE `skills_and_techniques` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-24  4:23:20
