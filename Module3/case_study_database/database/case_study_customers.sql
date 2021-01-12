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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `type_customer_id` int DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `identity_card` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `type_customer_id_idx` (`type_customer_id`),
  CONSTRAINT `type_customer_id` FOREIGN KEY (`type_customer_id`) REFERENCES `customer_types` (`type_customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,1,'Lê Phước Thanh Cao','1996-12-13','231325312','03121545','thanhcao@gmail.com','Huế'),(2,1,'Đặng Thị Hồng Thanh','1994-07-18','32321321','0445444554','hongthanh@gmail.com','Quảng Nam'),(3,4,'Trần Hữu Kiên','1991-10-22','3212311123','0494789797','huukien@gmail.com','Nghệ An'),(4,4,'Nguyễn Việt Dũng','1994-05-10','13213113','049788444','vietdung@gmail.com','Đà Nẵng'),(5,5,'Lê Hoàng Minh Tuấn','1994-08-08','1231313232','0545538987','minhtuan@gmail.com','Đà Nẵng'),(6,2,'Phạm Hồng Sơn','1997-09-09','32132131121','089879979','hongson@gmail.com','Đà Nẵng'),(7,2,'Trần Thị Thanh','2000-05-18','321322232321','098989790','thithanh@gmail.com','Quảng Trị'),(8,2,'Phạm Trường Phúc','1991-02-05','132131213','0213123211','truongphuc@gmail.com','Đà Nẵng'),(9,3,'Đặng Thị Hồng Thanh','2001-11-18','3212332123','0213323233','thanhabc@gmail.com','Quảng Ngãi');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 16:54:47
