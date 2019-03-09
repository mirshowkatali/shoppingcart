-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shoppingcart
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `authoritiesId` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authoritiesId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_ADMIN','admin'),(5,'ROLE_USER','abcd');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billingaddress`
--

DROP TABLE IF EXISTS `billingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billingaddress` (
  `billingAddressId` int(11) NOT NULL AUTO_INCREMENT,
  `apartmentNumber` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `streetName` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `customer_customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`billingAddressId`),
  KEY `FKF0492D19BDA5054B` (`customer_customerId`),
  CONSTRAINT `FKF0492D19BDA5054B` FOREIGN KEY (`customer_customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billingaddress`
--

LOCK TABLES `billingaddress` WRITE;
/*!40000 ALTER TABLE `billingaddress` DISABLE KEYS */;
INSERT INTO `billingaddress` VALUES (6,'123','Srinagar','india','jk','Srinagar India','190015',6);
/*!40000 ALTER TABLE `billingaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `grandTotal` double NOT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `FK1FEF40270264A` (`customerId`),
  CONSTRAINT `FK1FEF40270264A` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (4,200,6);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartitem` (
  `cartItemId` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `totalPrice` double NOT NULL,
  `cartId` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartItemId`),
  KEY `FK4393E732EF8C5CE` (`cartId`),
  KEY `FK4393E73E73FD6B7` (`pid`),
  CONSTRAINT `FK4393E732EF8C5CE` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `FK4393E73E73FD6B7` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerEmail` varchar(255) NOT NULL,
  `customerName` varchar(255) NOT NULL,
  `customerPhone` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `cartId` int(11) DEFAULT NULL,
  `billingAddressId` int(11) DEFAULT NULL,
  `shippingAddressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `FK27FBE3FE2EF8C5CE` (`cartId`),
  KEY `FK27FBE3FE140D5834` (`shippingAddressId`),
  KEY `FK27FBE3FEB2042BA0` (`billingAddressId`),
  CONSTRAINT `FK27FBE3FE140D5834` FOREIGN KEY (`shippingAddressId`) REFERENCES `shippingaddress` (`shippingAddressId`),
  CONSTRAINT `FK27FBE3FE2EF8C5CE` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `FK27FBE3FEB2042BA0` FOREIGN KEY (`billingAddressId`) REFERENCES `billingaddress` (`billingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (6,'mirshowkat09@gmail.com','abc','1231234143',0,'abc123','abcd',4,6,6);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerorder`
--

DROP TABLE IF EXISTS `customerorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerorder` (
  `customerOrderId` int(11) NOT NULL AUTO_INCREMENT,
  `billingAddressId` int(11) DEFAULT NULL,
  `cartId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `shippingAddressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerOrderId`),
  KEY `FKAEF781F02EF8C5CE` (`cartId`),
  KEY `FKAEF781F0270264A` (`customerId`),
  KEY `FKAEF781F0140D5834` (`shippingAddressId`),
  KEY `FKAEF781F0B2042BA0` (`billingAddressId`),
  CONSTRAINT `FKAEF781F0140D5834` FOREIGN KEY (`shippingAddressId`) REFERENCES `shippingaddress` (`shippingAddressId`),
  CONSTRAINT `FKAEF781F0270264A` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `FKAEF781F02EF8C5CE` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `FKAEF781F0B2042BA0` FOREIGN KEY (`billingAddressId`) REFERENCES `billingaddress` (`billingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerorder`
--

LOCK TABLES `customerorder` WRITE;
/*!40000 ALTER TABLE `customerorder` DISABLE KEYS */;
INSERT INTO `customerorder` VALUES (17,6,4,6,6),(18,6,4,6,6),(19,6,4,6,6),(20,6,4,6,6),(21,6,4,6,6),(22,6,4,6,6),(23,6,4,6,6),(24,6,4,6,6),(25,6,4,6,6),(26,6,4,6,6),(27,6,4,6,6),(28,6,4,6,6),(29,6,4,6,6),(30,6,4,6,6),(31,6,4,6,6),(32,6,4,6,6),(33,6,4,6,6),(34,6,4,6,6),(35,6,4,6,6),(36,6,4,6,6),(37,6,4,6,6),(38,6,4,6,6),(39,6,4,6,6),(40,6,4,6,6),(41,6,4,6,6),(42,6,4,6,6),(43,6,4,6,6),(44,6,4,6,6),(45,6,4,6,6),(46,6,4,6,6),(47,6,4,6,6),(48,6,4,6,6),(49,6,4,6,6),(50,6,4,6,6),(51,6,4,6,6),(52,6,4,6,6),(53,6,4,6,6),(54,6,4,6,6),(55,6,4,6,6),(56,6,4,6,6),(57,6,4,6,6),(58,6,4,6,6),(59,6,4,6,6),(60,6,4,6,6),(61,6,4,6,6),(62,6,4,6,6),(63,6,4,6,6),(64,6,4,6,6),(65,6,4,6,6),(66,6,4,6,6),(67,6,4,6,6),(68,6,4,6,6),(69,6,4,6,6),(70,6,4,6,6),(71,6,4,6,6),(72,6,4,6,6),(73,6,4,6,6),(74,6,4,6,6),(75,6,4,6,6),(76,6,4,6,6),(77,6,4,6,6),(78,6,4,6,6),(79,6,4,6,6),(80,6,4,6,6),(81,6,4,6,6),(82,6,4,6,6),(83,6,4,6,6),(84,6,4,6,6),(85,6,4,6,6),(86,6,4,6,6),(87,6,4,6,6),(88,6,4,6,6),(89,6,4,6,6),(90,6,4,6,6),(91,6,4,6,6),(92,6,4,6,6),(93,6,4,6,6),(94,6,4,6,6),(95,6,4,6,6),(96,6,4,6,6),(97,6,4,6,6),(98,6,4,6,6),(99,6,4,6,6),(100,6,4,6,6),(101,6,4,6,6),(102,6,4,6,6),(103,6,4,6,6),(104,6,4,6,6),(105,6,4,6,6),(106,6,4,6,6),(107,6,4,6,6);
/*!40000 ALTER TABLE `customerorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pcondition` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `imageUrl` longtext,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (32,'T-shirt','Regional','sdfsfsafd',200,'new','active',100,'sfsdfdf',NULL),(33,'T-shirt','Nature','afdadf',500,NULL,'active',100,'ffdff',NULL),(34,'T-Shirt','Seasonal','lihklj;',400,NULL,'active',100,'iougiouhi',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shippingaddress` (
  `shippingAddressId` int(11) NOT NULL AUTO_INCREMENT,
  `apartmentNumber` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `streetName` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `customer_customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`shippingAddressId`),
  KEY `FKBB1EE46BDA5054B` (`customer_customerId`),
  CONSTRAINT `FKBB1EE46BDA5054B` FOREIGN KEY (`customer_customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;
/*!40000 ALTER TABLE `shippingaddress` DISABLE KEYS */;
INSERT INTO `shippingaddress` VALUES (6,'Srinagar India','Srinagar','india','jk','Srinagar India','190015',6);
/*!40000 ALTER TABLE `shippingaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,0,1,'admin','admin'),(5,6,1,'abc123','abcd');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-08 10:17:54
