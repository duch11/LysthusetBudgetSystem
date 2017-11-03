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
  `FK_budgetpost_ID` int(11) NOT NULL,
  `FK_user_ID` int(11) NOT NULL,
  PRIMARY KEY (`FK_budgetpost_ID`,`FK_user_ID`),
  KEY `user_ID_fk` (`FK_user_ID`),
  CONSTRAINT `budgetposts_ID_fk` FOREIGN KEY (`FK_budgetpost_ID`) REFERENCES `budgetposts` (`BudgetPost_ID`),
  CONSTRAINT `user_ID_fk` FOREIGN KEY (`FK_user_ID`) REFERENCES `user` (`user_ID`)
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
-- Table structure for table `bpostlabels`
--

DROP TABLE IF EXISTS `bpostlabels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bpostlabels` (
  `BPostLabel_ID` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`BPostLabel_ID`),
  UNIQUE KEY `label_budgetposts_label_uindex` (`label`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bpostlabels`
--

LOCK TABLES `bpostlabels` WRITE;
/*!40000 ALTER TABLE `bpostlabels` DISABLE KEYS */;
INSERT INTO `bpostlabels` VALUES (2,'Basisting'),(1,'Husleje'),(3,'Kaffe'),(4,'Større Indkøb');
/*!40000 ALTER TABLE `bpostlabels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budgetposts`
--

DROP TABLE IF EXISTS `budgetposts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetposts` (
  `BudgetPost_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FK_month_ID` int(11) NOT NULL,
  `amount` decimal(8,2) NOT NULL DEFAULT 0.00,
  `FK_bpostlabel_ID` int(11) NOT NULL,
  PRIMARY KEY (`BudgetPost_ID`),
  UNIQUE KEY `budgetposts_ID_uindex` (`BudgetPost_ID`),
  KEY `budgetposts_months_monthID_fk` (`FK_month_ID`),
  KEY `budgetposts_label_budgetposts_ID_fk` (`FK_bpostlabel_ID`),
  CONSTRAINT `budgetposts_label_budgetposts_ID_fk` FOREIGN KEY (`FK_bpostlabel_ID`) REFERENCES `bpostlabels` (`BPostLabel_ID`),
  CONSTRAINT `budgetposts_months_monthID_fk` FOREIGN KEY (`FK_month_ID`) REFERENCES `months` (`month_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetposts`
--

LOCK TABLES `budgetposts` WRITE;
/*!40000 ALTER TABLE `budgetposts` DISABLE KEYS */;
INSERT INTO `budgetposts` VALUES (1,6,21000.00,1),(2,6,180.00,3),(3,6,300.00,2),(5,6,0.00,4);
/*!40000 ALTER TABLE `budgetposts` ENABLE KEYS */;
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
  `month_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`month_ID`),
  UNIQUE KEY `monthYear` (`month`,`year`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `months`
--

LOCK TABLES `months` WRITE;
/*!40000 ALTER TABLE `months` DISABLE KEYS */;
INSERT INTO `months` VALUES ('marts',1999,5),('november',2017,6);
/*!40000 ALTER TABLE `months` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentlabels`
--

DROP TABLE IF EXISTS `paymentlabels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentlabels` (
  `PaymentLabel_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FK_BPostLabel_ID` int(11) NOT NULL,
  `label` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`PaymentLabel_ID`),
  KEY `label_payments_label_budgetposts_ID_fk` (`FK_BPostLabel_ID`),
  CONSTRAINT `label_payments_label_budgetposts_ID_fk` FOREIGN KEY (`FK_BPostLabel_ID`) REFERENCES `bpostlabels` (`BPostLabel_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentlabels`
--

LOCK TABLES `paymentlabels` WRITE;
/*!40000 ALTER TABLE `paymentlabels` DISABLE KEYS */;
INSERT INTO `paymentlabels` VALUES (1,2,'Olie og Krydderier'),(2,2,'Rengøringsmidler'),(3,3,'Kaffe og Te'),(4,4,'Store indkøb (vvs, møbler og lign)');
/*!40000 ALTER TABLE `paymentlabels` ENABLE KEYS */;
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
  `FK_user_ID` int(11) DEFAULT 0,
  `Payment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FK_PayLabel_ID` int(11) NOT NULL,
  `FK_month_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Payment_ID`),
  KEY `userID_fk` (`FK_user_ID`),
  KEY `payments_label_paymentcategory_ID_fk` (`FK_PayLabel_ID`),
  KEY `payments_months_month_ID_fk` (`FK_month_ID`),
  CONSTRAINT `payments_label_paymentcategory_ID_fk` FOREIGN KEY (`FK_PayLabel_ID`) REFERENCES `paymentlabels` (`PaymentLabel_ID`),
  CONSTRAINT `payments_months_month_ID_fk` FOREIGN KEY (`FK_month_ID`) REFERENCES `months` (`month_ID`),
  CONSTRAINT `userID_fk` FOREIGN KEY (`FK_user_ID`) REFERENCES `user` (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES ('te',20.00,1,6,3,6),('kaffe',30.00,1,7,3,6),('Blomsterte',10.00,2,8,3,6),('Kalkfjerner',10.30,3,9,2,6),('Salt',3.43,4,10,1,6),('Krydderier',300.20,5,11,1,6),('Ajax',20.30,6,12,2,6),('Vanish',20.00,6,15,2,6);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `admin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
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

-- Dump completed on 2017-11-03 20:24:31
