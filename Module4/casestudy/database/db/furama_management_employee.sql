-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: furama_management
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(45) NOT NULL,
  `employee_birthday` date NOT NULL,
  `employee_id_card` varchar(45) NOT NULL,
  `employee_salary` double NOT NULL,
  `employee_phone` varchar(45) NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `employee_address` varchar(45) DEFAULT NULL,
  `position_id` int NOT NULL,
  `education_degree_id` int NOT NULL,
  `division_id` int NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `employee_email_UNIQUE` (`employee_email`),
  UNIQUE KEY `UKrdnn82v8q5bku2gdhf86u6p97` (`employee_email`),
  KEY `employee_ibfk_1` (`position_id`),
  KEY `employee_ibfk_2` (`education_degree_id`),
  KEY `employee_ibfk_3` (`division_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`education_degree_id`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Le Phuoc Thanh Cao','1996-12-13','2132323',1000,'01233112','lephuocthanhcao@gmail.com','Hue',6,4,2),(2,'Dang Thi Hong Thannh','1994-07-05','2133222',800,'02313211','dangthihongthanh@gmail.com','Quang Nam',2,1,4),(3,'Pham Hong Son','1997-11-22','4531223',400,'032122323','phamhongson@gmail.com','Tay Ninh',1,3,3),(4,'Ho Anh Dung','1996-08-28','7989789',400,'031213232','hoanhdung@gmail.com','Nghe An',2,1,1),(6,'Tran Huynh Bao Thinh','2000-10-03','11333121',200,'01233112','tranhuynhbaothinh@gmail.com','Hoi An',2,3,4),(8,'Thanh Cao','2021-03-10','23124',1500,'0777542581','leechoncaao@gmail.com','41b Mai Lão Bạng',1,2,1),(10,'cao3','2021-03-12','23133212',10000,'0777542581','leecao25@gmail.com','Lenin',1,1,1),(12,'cao5','2021-03-18','23133212',10000,'0777542581','cao56@gmail.com','Lenin',1,1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 11:30:03
