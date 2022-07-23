CREATE DATABASE  IF NOT EXISTS `hethonggiaohang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hethonggiaohang`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: hethonggiaohang
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `auctions`
--

DROP TABLE IF EXISTS `auctions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auctions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` decimal(10,0) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `shipper_id` int DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auctions_order_idx` (`order_id`),
  KEY `fk_auctions_shipper_idx` (`shipper_id`),
  KEY `fk_auctions_login_idx` (`login_id`),
  CONSTRAINT `fk_auctions_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`),
  CONSTRAINT `fk_auctions_order` FOREIGN KEY (`order_id`) REFERENCES `orderdetail` (`id`),
  CONSTRAINT `fk_auctions_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auctions`
--

LOCK TABLES `auctions` WRITE;
/*!40000 ALTER TABLE `auctions` DISABLE KEYS */;
INSERT INTO `auctions` VALUES (1,50000,'2022-02-04 12:02:30','Dịch vụ giao hàng tiết kiệm',2,1,4),(2,100000,'2022-05-02 17:42:43','Dịch vụ giao hàng nhanh',1,1,4),(3,50000,'2022-05-02 20:28:46','Dịch vụ giao hàng giá rẻ',3,3,3),(5,100000,'2022-05-04 14:33:50','Dịch vụ giao hàng giá rẻ',2,4,7),(6,5000,'2022-05-04 14:37:33','Dịch vụ giao hàng giá rẻ',2,4,7),(7,1000000,'2022-05-05 16:24:20','Dịch vụ giao hàng tiết kiệm\n',1,3,3),(8,100000,'2022-05-05 20:03:15','Giao hàng nhanh',4,3,3),(9,5000,'2022-05-07 12:50:58','',3,4,7),(10,20000,'2022-05-07 18:41:23',NULL,4,2,5),(11,30000,'2022-05-07 18:45:23',NULL,3,2,5),(12,25000,'2022-05-07 18:48:13',NULL,1,5,8),(13,60000,'2022-05-06 15:25:36',NULL,4,1,4),(14,35000,'2022-05-07 20:02:29','',3,1,4);
/*!40000 ALTER TABLE `auctions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'user1','user1','$2a$10$p1lrUBkQ0mFYGtlYBAZvSe5bCQ4AUUHGi9JeaKkCo55GsNmpR6Jla','648/53 CMT8 Phường 11 Quận 3 Thành Phố Hồ Chí Minh','user1@email.com','0125864686','https://res.cloudinary.com/dzexh0fxv/image/upload/v1650812522/bf3c4b9fjd5vuptcapi7.jpg','ROLE_USER'),(3,'admin','admin','$2a$10$SDlPbNEDIUG3VE9UQvh5oOrN.0cZb38HmO1KQS.0woDQBtcYaaL3y','648/53 CMT8 Phường 11 Quận 3 Thành Phố Hồ Chí Minh','admin@gmail.com','0125864686','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651326023/pbpremlqetkgj03mohqo.jpg','ROLE_ADMIN'),(4,'shipper1','shipper1','$2a$10$2fhEkSVGvleUK7wJmMuAk.2dtZz7MyaGdqe4Gg7Lvh1t7/Yb7GyAG','150 Lê Văn Sĩ, Phường 10, Quận Phú Nhận, Tp.HCM','shipper1@gmail.com','0265832654','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651475824/x1opuxkg89uaoyjuhbk5.jpg','ROLE_SHIPPER'),(5,'shipper2','shipper2','$2a$10$EPMiegaMhIMSLQbeondfuOTQWFyeOYQMrIUnyP91QanWkLZykRKiK','125 Tân Thành, Phường 15, Quận 5, Tp.HCM','shipper2@gmail.com','0215489635','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651475972/ptpyjn18aadixktssptj.png','ROLE_SHIPPER'),(6,'user2','user2','$2a$10$zfMQKNYEfawRWR3TP6t.B.XoSPWUPQHYX4xkv9QOL410sGK92Piry','26 Ngô Gia Tự, Phường 2, Quận 10, Tp.HCM','user2@gmail.com','0265832651','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651552418/klulclaxkwup2quqdb4x.png','ROLE_USER'),(7,'admin2','admin2','$2a$10$4aYdGXi2tA.HZUnlbsPst.bOligd8RN9Vs7k56W9H/VANmkPd4OnS','26 Ngô Gia Tự, Phường 2, Quận 10, Tp.HCM','admin2@gmail.com','0236598746','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651647803/nryec6tmquevgxbnhhtn.jpg','ROLE_ADMIN'),(8,'shipper3','shipper3','$2a$10$F.XQldPKqtUIZxGcIE6Pt.9tLKBRWkdM1EDGaxSgD5F/2JRfdPeh.','25 Trường Sơn, Phường 15, Quận 10, Tp.HCM','shipper3@gmail','0236598745','https://res.cloudinary.com/dzexh0fxv/image/upload/v1651647873/rzuschvxim9wdir1cyov.png','ROLE_SHIPPER');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'Đơn hàng chưa có shipper'),(2,'Đơn hàng đã có shipper');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_product` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sender_address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sender_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sender_phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `recipient_address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `recipient_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `recipient_phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  `orderstatus_id` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_login_idx` (`login_id`),
  KEY `fk_order_orderstatus_idx` (`orderstatus_id`),
  CONSTRAINT `fk_order_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`),
  CONSTRAINT `fk_order_orderstatus` FOREIGN KEY (`orderstatus_id`) REFERENCES `order_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,'Sữa','100 Phan Huy Ích, Phường 15, Quận Tân Bình, Tp.HCM','Lan','0256896352','50 Cô Giang, Phường Cô Giang, Quận 1, Tp.HCM','Ngọc','0365256985',7,2,'2022-04-26 14:21:30'),(2,'Trái cây','26 Bắc Hải, Phường 14, Quận 10, Tp.HCM','Nam','0156956987','609 Tân Kỳ Tân Quý, Phường Sơn Kỳ, Quận Tân Phú, Tp.HCM','Thuý','0658936547',6,2,'2022-04-27 10:15:20'),(3,'Quần áo','658 Cách Mạng Tháng 8, Phường 11, Quận 3, Tp.HCM','Duy','0589756324','100 Phạm Văn Hai, Phường 2, Quận Tân Bình, Tp.HCM','Bình','0986354863',7,2,'2022-04-27 15:22:18'),(4,'Nước giải khát','15 Lý Thường Kiệt, Phường 7, Quận Tân Bình, Tp.HCM','Hà','0596326985','523 Lạc Long Quân, Phường 10, Quận 11, Tp.HCM','Nhi','0236565894',7,2,'2022-04-30 15:33:45'),(5,'Mỹ phẩm','125 Cống Quỳnh, Phường Nguyễn Cư Trinh, Quận 1, Tp.HCM','Quỳnh','0125698563','350 Trường Trinh, Phường 13, Quận Tân Bình, Tp.HCM','Trúc','0236598632',7,1,'2022-05-01 18:51:28'),(6,'Mỹ phẩm','125 Cống Quỳnh, Phường Nguyễn Cư Trinh, Quận 1, Tp.HCM','Quỳnh','0265889634','378 Trường Trinh, Phường 13, Quận Tân Bình, Tp.HCM','Lam','0236565894',6,1,'2022-05-01 21:36:34'),(7,'Laptop','95 Cống Quỳnh, Phường Nguyễn Cư Trinh, Quận 1, Tp.HCM','Hà','0265889634','234 Lạc Long Quân, Phường 10, Quận 11, Tp.HCM','Trọng','0236565894',7,1,'2022-05-04 09:43:12'),(8,'Nước giải khát','150 Lý Thường Kiệt, Phường 7, Quận Tân Bình, Tp.HCM','Duy','0265889634','475 Lạc Long Quân, Phường 10, Quận 11, Tp.HCM','Luân','0236565894',7,1,'2022-05-05 07:59:56'),(9,'Mỹ phẩm','125 Lý Thường Kiệt, Phường 7, Quận Tân Bình, Tp.HCM','Quỳnh','0265889634','106 Phạm Văn Hai, Phường 11, Quận Tân Bình, Tp.HCM','Phong','0156987326',3,1,'2022-05-06 20:39:02'),(11,'Quần áo','150 Lý Thường Kiệt, Phường 7, Quận Tân Bình, Tp.HCM','Duy','0589756324','256 Lạc Long Quân, Phường 10, Quận 11, Tp.HCM','Quân','0986354863',3,1,'2022-05-06 14:44:05'),(12,'Nón bảo hiểm','15 Lý Thường Kiệt, Phường 7, Quận Tân Bình, Tp.HCM','Duy','0589756324','234 Lạc Long Quân, Phường 10, Quận 11, Tp.HCM','Quân','0236565894',7,1,'2022-05-07 20:30:25');
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` int DEFAULT NULL,
  `comment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  `shipper_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rate_shipper_idx` (`shipper_id`),
  KEY `fk_rate_login_idx` (`login_id`),
  CONSTRAINT `fk_rate_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`),
  CONSTRAINT `fk_rate_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (1,5,'Shipper nhiệt tình','2022-02-05 08:22:00',1,1),(2,4,'Shipper giao hàng nhanh','2022-05-05 14:30:25',6,2),(3,4,'Shipper giao hàng nhanh','2022-05-03 11:30:25',6,1),(4,5,'Shipper nhiệt tình','2022-05-07 19:20:15',1,5);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_card_number` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` int DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_card_number_UNIQUE` (`id_card_number`),
  KEY `fk_shipper_login_idx` (`login_id`),
  CONSTRAINT `fk_shipper_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
INSERT INTO `shipper` VALUES (1,'025950747',1,4),(2,'025634568',1,5),(3,'036589456',1,3),(4,'035689478',1,7),(5,'035648965',1,8),(7,'0265448555',NULL,6);
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper_auctions`
--

DROP TABLE IF EXISTS `shipper_auctions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper_auctions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `shipper_id` int DEFAULT NULL,
  `auctions_id` int DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shipper_id_idx` (`shipper_id`),
  KEY `auctions_id_idx` (`auctions_id`),
  KEY `login_id_idx` (`login_id`),
  CONSTRAINT `auctions_id` FOREIGN KEY (`auctions_id`) REFERENCES `auctions` (`id`),
  CONSTRAINT `login_id` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`),
  CONSTRAINT `shipper_id` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper_auctions`
--

LOCK TABLES `shipper_auctions` WRITE;
/*!40000 ALTER TABLE `shipper_auctions` DISABLE KEYS */;
INSERT INTO `shipper_auctions` VALUES (4,'2022-05-07 18:41:23',1,1,4),(5,'2022-05-07 20:45:23',2,11,5),(6,'2022-05-07 18:50:15',5,12,8),(7,'2022-05-07 19:12:05',1,13,4);
/*!40000 ALTER TABLE `shipper_auctions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_login_idx` (`login_id`),
  CONSTRAINT `fk_user_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2022-05-07 21:03:21
