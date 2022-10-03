-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: market
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Type` int DEFAULT NULL,
  `Status` int DEFAULT NULL,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Gmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `CMND` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'shipper1','12345',2,1,'Anh Tuấn','','',NULL,'2345657',''),(2,'guest1','$2a$10$MMolSFBoZBtkPgusCn6H8OcNMpJq1jviy6NnmM0t/uaZudKGPhwmy',1,0,'guest','113-Nơ Trang Long','guest1@gmail.com',NULL,'3456477','09657424556');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Content` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `CODE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `MoneyReduce` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Milk',12000,10,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662015124/xnpvgdmfratnqqjqgw1r.jpg'),(2,'Nấm kim châm 150g',10000,100,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033084/b8f6pyig3jrtu9lmcpfh.jpg'),(3,'Chuối vàng',12000,500,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033143/zvsottqcds73atedepqb.jpg'),(4,'Dưa chuột',12000,500,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033194/i3gx5k7ppieiifoev0fi.jpg'),(5,'Trứng gà',30000,200,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033377/vtl866wmjdza7tl8cwue.jpg'),(6,'Trứng gà ta',47000,150,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033414/n3anzkrmknd8v0ktz9my.jpg'),(7,'Trứng cút',28000,100,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033462/djvo6kdvtajsoshkqdgi.jpg'),(8,'Bào ngư đông lạnh khay 500g',245000,100,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033546/as9ozvzcl7d63bnjijoc.jpg'),(9,'Giò lụa Vissan cây 500g',115000,190,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033718/dhmvhcobmdtsgajndjto.jpg'),(10,'Nem giòn CP gói 180g',32000,50,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033783/sihfldwexp3gkdm5xsro.jpg'),(11,'Sữa bắp Thái Sơn 330ml',15000,300,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033877/k17duzwcbv8zms7qlpwx.jpg'),(12,'Sữa gạo lứt Thái Sơn 280ml',15000,250,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033954/wlfaaz11htzyzb8a5qfp.jpg'),(13,'Sữa dâu 300ml',20000,150,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662033997/finnwwmb2o9cnsluujzx.jpg'),(14,'Bánh quế vị kem dâu Cosy gói 132g',14000,150,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662034040/mjfxpmzxdrernsgzylex.jpg'),(15,'Bánh gạo vị bò nướng One-One gói 150g',30000,150,'https://res.cloudinary.com/dzexh0fxv/image/upload/v1662034065/vmfthbyvjrvvtqsrkj79.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Amount` double DEFAULT NULL,
  `DateTime` datetime DEFAULT NULL,
  `Guest_ID` int DEFAULT NULL,
  `Shipper_ID` int DEFAULT NULL,
  `Status` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_guest_id_idx` (`Guest_ID`),
  KEY `fk_shipper_id_idx` (`Shipper_ID`),
  CONSTRAINT `fk_guest_id` FOREIGN KEY (`Guest_ID`) REFERENCES `account` (`ID`),
  CONSTRAINT `fk_shipper_id` FOREIGN KEY (`Shipper_ID`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_product`
--

DROP TABLE IF EXISTS `receipt_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Product_ID` int DEFAULT NULL,
  `Receipt_ID` int DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_product_id_idx` (`Product_ID`),
  KEY `fk_receipt_id_idx` (`Receipt_ID`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`ID`),
  CONSTRAINT `fk_receipt_id` FOREIGN KEY (`Receipt_ID`) REFERENCES `receipt` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_product`
--

LOCK TABLES `receipt_product` WRITE;
/*!40000 ALTER TABLE `receipt_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-03 22:57:32
