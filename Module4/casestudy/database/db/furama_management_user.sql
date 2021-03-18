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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(128) NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  KEY `emp_id_idx` (`employee_id`),
  CONSTRAINT `emp_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('cao5@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',12),('dangthihongthanh@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',2),('hoanhdung@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',4),('leecao2@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',10),('leechoncaao@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',8),('lephuocthanhcao@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',1),('phamhongson@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',3),('tranhuynhbaothinh@gmail.com','$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y',6);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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