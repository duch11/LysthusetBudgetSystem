-- MySQL dump 10.16  Distrib 10.2.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: lysthusetbudgetsystem
-- ------------------------------------------------------
-- Server version	10.2.8-MariaDB

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
-- Table structure for table `_budgetpost_users`
--

DROP TABLE IF EXISTS `_budgetpost_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_budgetpost_users` (
  `budgetpostID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`budgetpostID`,`userID`),
  KEY `user_ID_fk` (`userID`),
  CONSTRAINT `budgetposts_ID_fk` FOREIGN KEY (`budgetpostID`) REFERENCES `budgetposts` (`ID`),
  CONSTRAINT `user_ID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_budgetpost_users`
--

LOCK TABLES `_budgetpost_users` WRITE;
/*!40000 ALTER TABLE `_budgetpost_users` DISABLE KEYS */;
INSERT INTO `_budgetpost_users` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6);
/*!40000 ALTER TABLE `_budgetpost_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budgetposts`
--

DROP TABLE IF EXISTS `budgetposts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetposts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `monthID` int(11) NOT NULL,
  `amount` decimal(8,2) NOT NULL DEFAULT 0.00,
  `labelID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `budgetposts_ID_uindex` (`ID`),
  KEY `budgetposts_months_monthID_fk` (`monthID`),
  KEY `budgetposts_label_budgetposts_ID_fk` (`labelID`),
  CONSTRAINT `budgetposts_label_budgetposts_ID_fk` FOREIGN KEY (`labelID`) REFERENCES `label_budgetposts` (`ID`),
  CONSTRAINT `budgetposts_months_monthID_fk` FOREIGN KEY (`monthID`) REFERENCES `months` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetposts`
--

LOCK TABLES `budgetposts` WRITE;
/*!40000 ALTER TABLE `budgetposts` DISABLE KEYS */;
INSERT INTO `budgetposts` VALUES (1,6,21000.00,1),(2,6,180.00,3),(3,6,300.00,2);
/*!40000 ALTER TABLE `budgetposts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label_budgetposts`
--

DROP TABLE IF EXISTS `label_budgetposts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label_budgetposts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `label_budgetposts_label_uindex` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label_budgetposts`
--

LOCK TABLES `label_budgetposts` WRITE;
/*!40000 ALTER TABLE `label_budgetposts` DISABLE KEYS */;
INSERT INTO `label_budgetposts` VALUES (2,'Basisting'),(1,'Husleje'),(3,'Kaffe');
/*!40000 ALTER TABLE `label_budgetposts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label_paymentcategory`
--

DROP TABLE IF EXISTS `label_paymentcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label_paymentcategory` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `label_budgetposts_ID` int(11) NOT NULL,
  `category` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `label_payments_label_budgetposts_ID_fk` (`label_budgetposts_ID`),
  CONSTRAINT `label_payments_label_budgetposts_ID_fk` FOREIGN KEY (`label_budgetposts_ID`) REFERENCES `label_budgetposts` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label_paymentcategory`
--

LOCK TABLES `label_paymentcategory` WRITE;
/*!40000 ALTER TABLE `label_paymentcategory` DISABLE KEYS */;
INSERT INTO `label_paymentcategory` VALUES (1,2,'Olie og Krydderier'),(2,2,'Rengøringsmidler'),(3,3,'Kaffe og Te');
/*!40000 ALTER TABLE `label_paymentcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `months`
--

DROP TABLE IF EXISTS `months`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `months` (
  `month` enum('januar','februar','marts','april','maj','juni','juli','august','september','oktober','november','december') COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` year(4) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `monthYear` (`month`,`year`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `months`
--

LOCK TABLES `months` WRITE;
/*!40000 ALTER TABLE `months` DISABLE KEYS */;
INSERT INTO `months` VALUES ('januar',2017,6),('marts',1999,5);
/*!40000 ALTER TABLE `months` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `description` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT 'mangler beskrivelse',
  `amount` decimal(10,2) NOT NULL,
  `monthID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `labelID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `monthID_fk` (`monthID`),
  KEY `userID_fk` (`userID`),
  KEY `payments_label_paymentcategory_ID_fk` (`labelID`),
  CONSTRAINT `monthID_fk` FOREIGN KEY (`monthID`) REFERENCES `months` (`ID`),
  CONSTRAINT `payments_label_paymentcategory_ID_fk` FOREIGN KEY (`labelID`) REFERENCES `label_paymentcategory` (`ID`),
  CONSTRAINT `userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES ('te',20.00,6,1,6,3),('kaffe',30.00,6,1,7,3),('Blomsterte',10.00,6,2,8,3),('Kalkfjerner',10.30,6,3,9,2),('Salt',3.43,6,4,10,1),('Krydderier',300.20,6,5,11,1),('Ajax',20.30,6,6,12,2),('Vanish',20.00,6,6,15,2);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `admin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jonas','123',1,0),(2,'tine','123',1,0),(3,'stine','123',1,0),(4,'røde','123',1,0),(5,'michael','123',1,0),(6,'marie','123',1,0);
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

-- Dump completed on 2017-10-26 16:59:14
