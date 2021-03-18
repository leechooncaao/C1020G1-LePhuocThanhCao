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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_type_id` int DEFAULT NULL,
  `customer_name` varchar(45) NOT NULL,
  `customer_birthday` date NOT NULL,
  `customer_gender` varchar(10) NOT NULL,
  `customer_id_card` varchar(45) NOT NULL,
  `customer_phone` varchar(45) NOT NULL,
  `customer_email` varchar(45) DEFAULT NULL,
  `customer_address` varchar(45) DEFAULT NULL,
  `customer_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_type_id` (`customer_type_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,1,'Le Hoang Minh Tuan','1994-02-23','Male','321313119','0901234557','lehoangminhtuan@gmail.com','Da Nang','KH-0001'),(2,2,'Nguyen Thanh Tung','1993-05-21','Male','7987978','051331232','nguyenthanhtung@gmail.com','Da Nang','KH-0002'),(3,3,'Nguyen Long Phin','1999-01-18','Female','98799797','0121323321','nguyenlongphin@gmail.com','Quang Nam','KH-0003'),(4,3,'Nguyen Ngoc Thinh','1995-11-24','Male','98798988','03213112312','nguyenngocthinh@gmail.com','Quang Ngai','KH-0004'),(5,1,'Nguyen Viet Dung1','1994-09-11','Female','87879797','032132131','nguyenvietdung@gmail.com','Da Nang','KH-0005'),(10,1,'leechoncaao','1997-01-02','Male','23133212','0777542581','hathaykhongbanghayhat18@gmail.com','Lenin','KH-0010'),(12,1,'leecaao','2021-03-11','Male','23124','0777542581','leecao@gmail.com','Lenin','KH-0012'),(13,1,'leecaao3','2021-03-11','Male','23124','0777542581','hathaykhongbanghayhat18@gmail.com','Lenin','KH-0013'),(14,3,'Thanh Cao Lê Phước 11','2021-03-09','Male','23133212','0777542581','hathaykhongbanghayhat18@gmail.com','Lenin','KH-0014'),(15,1,'fdsa','2021-03-12','Male','sdfa','fsdfas','fsa','fsda','fsadf');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 11:30:01
