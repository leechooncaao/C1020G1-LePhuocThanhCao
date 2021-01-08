-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: case_study
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `level_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `identity_card` varchar(45) DEFAULT NULL,
  `salary` decimal(9,2) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `position_id_idx` (`position_id`),
  KEY `level_id_idx` (`level_id`),
  KEY `department_id_idx` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`),
  CONSTRAINT `level_id` FOREIGN KEY (`level_id`) REFERENCES `levels` (`level_id`),
  CONSTRAINT `position_id` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Lê Văn A',1,1,2,'1990-12-05','312132232',300.00,'097878997','vana@gmail.com','Huế'),(2,'Nguyễn Thị B',6,2,3,'1986-11-08','321231310',700.00,'098789987','thib@gmail.com','Đà Nẵng'),(3,'Nguyễn Thị C',2,3,4,'1999-08-18','97879878',500.00,'09797979','thic@gmail.com','Đà Nẵng'),(4,'Trương Văn D',3,1,1,'1988-11-29','454445455',450.00,'078787887','vand@gmail.com','Quảng Trị'),(5,'Phan Văn E',2,3,4,'2000-02-22','787978778',600.00,'0321121231','vane@gmail.com','Quảng Nam'),(6,'Nguyễn F',1,2,4,'1995-05-04','549849878',300.00,'079977897','nguyenf@gmail.com','Huế');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-08 11:18:40
