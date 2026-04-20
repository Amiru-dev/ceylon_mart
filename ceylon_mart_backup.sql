CREATE DATABASE  IF NOT EXISTS `ceylon_mart` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ceylon_mart`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ceylon_mart
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Munchee'),(2,'Maliban'),(3,'Kist'),(4,'Fortune'),(5,'Marina'),(6,'Kothmale'),(7,'Rathna'),(8,'Sera'),(9,'Maggie'),(10,'Lifebuoy'),(11,'Nikado'),(12,'Detol'),(13,'Nipuna'),(14,'Clogard'),(15,'Sudantha'),(16,'Signal'),(17,'Atlas'),(18,'Jedel'),(19,'Havit'),(20,'Pesuru'),(21,'Chamara'),(22,'Hawai');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Ambalangoda'),(2,'Galle'),(3,'Balapitiya'),(4,'Ahungalla'),(5,'Hikkaduwa'),(6,'Colombo');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `hotline` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'CBL Munchee','0912265132'),(2,'Maliban','0912298457'),(3,'Kist','0912254783'),(4,'Kothmale','0912254798'),(5,'Sera','0912245397');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `mobile` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `points` double NOT NULL,
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('0714523947','nipun','madusanka','nipun@gmail.com',0),('0715874236','gihan','dissanayake','leela@gmail.com',0),('0763284127','venuja','kalhara','venuja@gmail.com',0),('0763347112','kanthi','ruwanpura','kanthi@gmail.com',12),('0784169257','chamila','darshani','chami@gmail.com',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discount_type` varchar(30) NOT NULL,
  `discount_value` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'Gross Amount Discount',10),(2,'Loyalty Discount',10);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `date_registered` date NOT NULL,
  `employee_type_id` int NOT NULL,
  `gender_id` int NOT NULL,
  `employee_status_id` int NOT NULL,
  PRIMARY KEY (`email`),
  KEY `fk_employee_employee_type1_idx` (`employee_type_id`),
  KEY `fk_employee_gender1_idx` (`gender_id`),
  KEY `fk_employee_employee_status1_idx` (`employee_status_id`),
  CONSTRAINT `fk_employee_employee_status1` FOREIGN KEY (`employee_status_id`) REFERENCES `employee_status` (`id`),
  CONSTRAINT `fk_employee_employee_type1` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `fk_employee_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('amiru@gmail.com','Amiru2004','Amiru','Upek','200403110370','0784766700','2024-08-29',1,1,1),('rashi@gmail.com','jerom123','rashi','jerom','200402210101','0784736521','2024-12-15',2,1,1),('surath@gmail.com','surath2003','Surath','Chamara','200102553174','0763347112','2024-09-01',2,1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_address`
--

DROP TABLE IF EXISTS `employee_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `city_id` int NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_address_city1_idx` (`city_id`),
  KEY `fk_employee_address_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_employee_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_employee_address_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_address`
--

LOCK TABLES `employee_address` WRITE;
/*!40000 ALTER TABLE `employee_address` DISABLE KEYS */;
INSERT INTO `employee_address` VALUES (1,'no.23','rajapaksha mawatha',4,'amiru@gmail.com');
/*!40000 ALTER TABLE `employee_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_attendance`
--

DROP TABLE IF EXISTS `employee_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `checkin` time NOT NULL,
  `checkout` time DEFAULT NULL,
  `employee_email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_attendance_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_employee_attendance_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_attendance`
--

LOCK TABLES `employee_attendance` WRITE;
/*!40000 ALTER TABLE `employee_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_status`
--

DROP TABLE IF EXISTS `employee_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_status`
--

LOCK TABLES `employee_status` WRITE;
/*!40000 ALTER TABLE `employee_status` DISABLE KEYS */;
INSERT INTO `employee_status` VALUES (1,'Active'),(2,'Deactive');
/*!40000 ALTER TABLE `employee_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_type`
--

DROP TABLE IF EXISTS `employee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_type`
--

LOCK TABLES `employee_type` WRITE;
/*!40000 ALTER TABLE `employee_type` DISABLE KEYS */;
INSERT INTO `employee_type` VALUES (1,'Admin'),(2,'Employee');
/*!40000 ALTER TABLE `employee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Male'),(2,'Female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn`
--

DROP TABLE IF EXISTS `grn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn` (
  `id` bigint NOT NULL,
  `supplier_mobile` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `paid_amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_mobile`),
  KEY `fk_grn_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_grn_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_mobile`) REFERENCES `supplier` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn`
--

LOCK TABLES `grn` WRITE;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
INSERT INTO `grn` VALUES (1726751909105,'0769824587','2024-09-19','surath@gmail.com',8000),(1726752028210,'0712587415','2024-09-19','surath@gmail.com',5000),(1726839680848,'0774583278','2024-09-20','surath@gmail.com',1000),(1726839868836,'0774583278','2024-09-20','surath@gmail.com',5000),(1726840216322,'0715398714','2024-09-20','surath@gmail.com',1000),(1726840325313,'0769824587','2024-09-20','surath@gmail.com',1000),(1726840618673,'0712587415','2024-09-20','surath@gmail.com',2000),(1726841041271,'0712587415','2024-09-20','surath@gmail.com',1000),(1726844603807,'0712364218','2024-09-20','surath@gmail.com',2000),(1726844670060,'0773214789','2024-09-20','surath@gmail.com',1500),(1727288105389,'0712587415','2024-09-25','surath@gmail.com',0),(1727288216532,'0773214789','2024-09-25','surath@gmail.com',0),(1727366981179,'0774583278','2024-09-26','surath@gmail.com',2000),(1728033873369,'0712364218','2024-10-04','surath@gmail.com',5800),(1734671830764,'0712587415','2024-12-20','surath@gmail.com',40);
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn_item`
--

DROP TABLE IF EXISTS `grn_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `stock_id` int NOT NULL,
  `grn_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn_item`
--

LOCK TABLES `grn_item` WRITE;
/*!40000 ALTER TABLE `grn_item` DISABLE KEYS */;
INSERT INTO `grn_item` VALUES (1,'20.0',400,1,1726751909105),(2,'20.0',300,2,1726752028210),(3,'10.0',300,3,1726839680848),(4,'15.0',350,4,1726839868836),(5,'10.0',250,5,1726840216322),(6,'5.0',300,6,1726840325313),(7,'10.0',200,7,1726840618673),(8,'10.0',250,8,1726841041271),(9,'10.0',300,9,1726844603807),(10,'10.0',150,10,1726844670060),(11,'5.0',300,11,1727288105389),(12,'5.0',100,12,1727288216532),(13,'10.0',350,13,1727366981179),(14,'10.0',480,14,1728033873369),(15,'2.0',20,15,1734671830764);
/*!40000 ALTER TABLE `grn_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` bigint NOT NULL,
  `customer_mobile` varchar(10) DEFAULT NULL,
  `employee_email` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `paid_amount` double NOT NULL,
  `payment_method_id` int NOT NULL,
  `discount_value` double NOT NULL,
  `discount_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_customer1_idx` (`customer_mobile`),
  KEY `fk_invoice_employee1_idx` (`employee_email`),
  KEY `fk_invoice_payment_method1_idx` (`payment_method_id`),
  KEY `fk_invoice_discount1_idx` (`discount_id`),
  CONSTRAINT `fk_invoice_customer1` FOREIGN KEY (`customer_mobile`) REFERENCES `customer` (`mobile`),
  CONSTRAINT `fk_invoice_discount1` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`),
  CONSTRAINT `fk_invoice_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`),
  CONSTRAINT `fk_invoice_payment_method1` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1726842156425,'0784169257','surath@gmail.com','2024-09-20 19:54:11',4000,1,390,2),(1726842554218,'0784169257','surath@gmail.com','2024-09-20 19:59:53',4000,1,390,2),(1727302438632,'0763347112','surath@gmail.com','2024-09-26 03:44:46',3000,1,320,2),(1727317555446,'0714523947','surath@gmail.com','2024-09-26 07:56:48',3200,1,354,2),(1727365943809,NULL,'surath@gmail.com','2024-09-26 21:23:02',1300,1,0,NULL),(1727367306206,'0715874236','surath@gmail.com','2024-09-26 21:45:33',4000,1,0,2),(1727531862593,NULL,'surath@gmail.com','2024-09-28 19:28:20',600,1,0,NULL),(1727532287564,NULL,'surath@gmail.com','2024-09-28 19:35:20',360,1,0,NULL),(1727532657526,NULL,'surath@gmail.com','2024-09-28 19:41:07',360,1,0,NULL),(1727533018543,NULL,'surath@gmail.com','2024-09-28 19:47:12',400,1,0,NULL),(1727533407592,NULL,'surath@gmail.com','2024-09-28 19:53:38',400,1,0,NULL),(1727579613601,NULL,'surath@gmail.com','2024-09-29 08:43:48',360,1,0,NULL),(1728009952535,NULL,'surath@gmail.com','2024-10-04 08:16:16',1000,1,0,NULL),(1728010986417,'0715874236','surath@gmail.com','2024-10-04 08:34:19',800,1,88,2),(1728033991448,'0714523947','surath@gmail.com','2024-10-04 14:58:31',1300,1,146,2),(1734757661958,'0763347112','surath@gmail.com','2024-12-21 10:40:19',400,1,48,2),(1734766822028,'0763347112','surath@gmail.com','2024-12-21 13:12:01',400,1,36,2),(1734766969121,'0763347112','surath@gmail.com','2024-12-21 13:13:27',400,1,48,2),(1734768211119,'0763347112','surath@gmail.com','2024-12-21 13:34:31',450,1,48,2),(1734770793742,'0763347112','surath@gmail.com','2024-12-21 14:17:12',360,1,40,2),(1734778318896,'0763347112','surath@gmail.com','2024-12-21 16:22:59',500,1,56,2),(1734785607628,'0763347112','surath@gmail.com','2024-12-21 18:23:47',360,1,40,2),(1734785703482,'0763347112','surath@gmail.com','2024-12-21 18:25:19',360,1,40,2),(1734786058179,'0763347112','surath@gmail.com','2024-12-21 18:31:57',350,1,40,2),(1734788045755,'0763347112','surath@gmail.com','2024-12-21 19:04:34',360,1,40,2),(1734788839624,'0763347112','surath@gmail.com','2024-12-21 19:17:50',360,1,40,2),(1734789730882,'0763347112','surath@gmail.com','2024-12-21 19:32:26',360,1,40,2);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_item`
--

DROP TABLE IF EXISTS `invoice_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_id` int NOT NULL,
  `qty` double NOT NULL,
  `invoice_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_item_stock1_idx` (`stock_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_id`),
  CONSTRAINT `fk_invoice_item_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_item`
--

LOCK TABLES `invoice_item` WRITE;
/*!40000 ALTER TABLE `invoice_item` DISABLE KEYS */;
INSERT INTO `invoice_item` VALUES (1,6,5,1726842156425),(2,7,5,1726842156425),(3,8,3,1726842156425),(4,3,5,1726842554218),(5,7,5,1726842554218),(6,8,3,1726842554218),(7,1,5,1727302438632),(8,4,2,1727302438632),(9,1,3,1727317555446),(10,2,5,1727317555446),(11,8,1,1727317555446),(12,1,1,1727365943809),(13,2,1,1727365943809),(14,9,1,1727365943809),(15,2,1,1727531862593),(16,10,1,1727531862593),(17,2,1,1727532287564),(18,2,1,1727532657526),(19,4,1,1727533018543),(20,4,1,1727533407592),(21,2,1,1727579613601),(22,1,1,1728009952535),(23,2,1,1728009952535),(24,1,1,1728010986417),(25,4,1,1728010986417),(26,2,1,1728033991448),(27,14,2,1728033991448),(28,1,1,1734757661958),(29,2,1,1734766822028),(30,1,1,1734766969121),(31,1,1,1734768211119),(32,4,1,1734770793742),(33,5,2,1734778318896),(34,4,1,1734785607628),(35,4,1,1734785703482),(36,4,1,1734786058179),(37,4,1,1734788045755),(38,9,1,1734788839624),(39,13,1,1734789730882);
/*!40000 ALTER TABLE `invoice_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'Cash'),(2,'Card');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` varchar(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `brand_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_brand1_idx` (`brand_id`),
  CONSTRAINT `fk_product_brand1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1726745321975','chocolate marie 400g',1),('1726745665339','gold marie 400g',2),('1726750343035','fresh milk 450ml',6),('1726750381545','chocolate milk 450ml',6),('1726750410320','coconut oil 400ml',4),('1726839801756','chocolate cream biscuits 200g',2),('1726839998677','chocolate cream biscuits 200g',3),('1726840633508','cream cracker 300g',1),('1726841054860','tikiri marie 300g',1),('1726844683154','soup mixture 100g',8);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` varchar(20) NOT NULL,
  `qty` double NOT NULL,
  `price` double NOT NULL,
  `mfd` date NOT NULL,
  `exp` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_product1_idx` (`product_id`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'1726745665339',6,480,'2024-09-03','2024-12-03'),(2,'1726745321975',7,360,'2024-09-04','2025-02-04'),(3,'1726745665339',5,350,'2024-09-17','2024-12-24'),(4,'1726839801756',5,400,'2024-09-16','2025-03-11'),(5,'1726839998677',8,280,'2024-09-08','2025-02-02'),(6,'1726745665339',0,350,'2024-09-10','2025-04-07'),(7,'1726840633508',0,250,'2024-09-01','2025-03-02'),(8,'1726841054860',3,300,'2024-09-02','2025-01-28'),(9,'1726750343035',8,400,'2024-09-17','2024-10-22'),(10,'1726844683154',9,200,'2024-09-19','2024-12-24'),(11,'1726750381545',5,400,'2024-09-16','2024-12-25'),(12,'1726844683154',5,130,'2024-09-17','2025-02-11'),(13,'1726745665339',9,400,'2024-09-16','2025-02-03'),(14,'1726750410320',8,550,'2024-10-03','2025-02-05'),(15,'1726745665339',2,25,'2024-12-18','2024-12-26');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `mobile` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`mobile`),
  KEY `fk_supplier_company_idx` (`company_id`),
  CONSTRAINT `fk_supplier_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('0712364218','rasika','naveen','rasika@gmail.com',5),('0712587415','ranjith','hewage','ranjith@gmail.com',3),('0769824587','hansa','sadamith','hansa@gmail.com',2),('0773214789','kumara','herath','kumara@gmail.com',1),('0774583278','kamal','godahewa','kamal@gmail.com',4);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-04 21:52:40
