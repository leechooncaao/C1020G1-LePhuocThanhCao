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
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(45) NOT NULL,
  `service_area` int DEFAULT NULL,
  `service_cost` double NOT NULL,
  `service_max_people` int DEFAULT NULL,
  `rent_type_id` int NOT NULL,
  `service_type_id` int NOT NULL,
  `standard_room` varchar(45) DEFAULT NULL,
  `description_other_convenience` varchar(45) DEFAULT NULL,
  `pool_area` double DEFAULT NULL,
  `number_of_floors` int DEFAULT NULL,
  `service_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `service_ibfk_1` (`rent_type_id`),
  KEY `service_ibfk_2` (`service_type_id`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`),
  CONSTRAINT `service_ibfk_2` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Villa la Cassinella',200,1000,4,4,1,'Vip','excellent',30,3,'DV-0001'),(2,'Villa Poletti',300,2000,4,3,1,'Presidental','romantic',35,3,'DV-0002'),(3,'Orchard House',75,800,5,2,2,'Luxurious','peaceful',20,1,'DV-0003'),(4,'Corner House',100,1000,5,3,2,'Standard','natural',20,2,'DV-0004'),(5,'Ideation Zone',40,200,2,1,3,'Collaborative','nothing',0,1,'DV-0005'),(6,'Gathering Field',45,250,2,2,3,'Social ','nothing',0,1,'DV-0006');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 11:30:02
