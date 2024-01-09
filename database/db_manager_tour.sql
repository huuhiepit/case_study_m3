CREATE DATABASE  IF NOT EXISTS `db_manager_tour` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_manager_tour`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: db_manager_tour
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `urlImage` varchar(45) DEFAULT NULL,
  `createAt` date DEFAULT NULL,
  `role` enum('ADMIN','EMPLOYEE','CUSTOMER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'hiep','123',NULL,NULL,'ADMIN'),(2,'ngan','123',NULL,NULL,'EMPLOYEE'),(3,'quocanh','123',NULL,NULL,'CUSTOMER'),(4,'vinh','123',NULL,NULL,'CUSTOMER'),(5,'jysoz','Pa$$w0rd!',NULL,NULL,'CUSTOMER'),(6,'vinh','123',NULL,NULL,'CUSTOMER');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat` int DEFAULT '1',
  `totalPrice` int DEFAULT NULL,
  `dateBooking` date DEFAULT NULL,
  `status` enum('PROCESSING','PROCESSED','CANCEL') DEFAULT NULL,
  `payment` enum('ONLINE','OFFLINE') DEFAULT NULL,
  `customers_id` int NOT NULL,
  `description_tours_id` int NOT NULL,
  `employees_id` int DEFAULT NULL,
  PRIMARY KEY (`id`,`customers_id`,`description_tours_id`),
  KEY `fk_Booking_customers1_idx` (`customers_id`),
  KEY `fk_Booking_employees1_idx` (`employees_id`),
  KEY `fk_Booking_description_tours1_idx` (`description_tours_id`),
  CONSTRAINT `fk_Booking_customers1` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `fk_Booking_description_tours1` FOREIGN KEY (`description_tours_id`) REFERENCES `description_tours` (`id`),
  CONSTRAINT `fk_Booking_employees1` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,4,500000,'2024-01-07','PROCESSED','ONLINE',1,23,1),(2,5,500000,'2024-01-07','CANCEL','ONLINE',1,23,1),(3,2,20000,'2024-01-07','PROCESSING','ONLINE',1,24,1),(4,6,74394000,'2024-01-07','PROCESSED','OFFLINE',1,23,1),(5,8,99192000,'2024-01-07','PROCESSING','ONLINE',1,24,1),(6,12,153588000,'2024-01-07','CANCEL','OFFLINE',1,26,1),(7,2,123990000,'2024-01-08','PROCESSED','OFFLINE',1,25,NULL),(9,1,99192000,'2024-01-08','CANCEL','ONLINE',2,25,1),(10,1,12399000,'2024-01-08','CANCEL','OFFLINE',2,25,1),(11,1,12399000,'2024-01-08','CANCEL','OFFLINE',2,25,1),(12,4,51996000,'2024-01-09','PROCESSED','OFFLINE',2,30,NULL),(13,2,25998000,'2024-01-09','PROCESSED','ONLINE',2,30,NULL),(14,6,77994000,'2024-01-09','CANCEL','ONLINE',2,30,1);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `accounts_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customers_accounts1_idx` (`accounts_id`),
  CONSTRAINT `fk_customers_accounts1` FOREIGN KEY (`accounts_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'quocanh','123','hue','quocanh@gmail.com',3),(2,'Vinh Tran','0245353225','Huế','vinhngoctran35@gmail.com',4),(3,'Paul Owen','+1 (528) 357-5658','Natus ratione et des','wyzyg@mailinator.com',5),(4,'huuhiepkool','0366526480','PhÃº Má»¹, PhÃº Vang','nhhiepit@gmail.com',6);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `description_tours`
--

DROP TABLE IF EXISTS `description_tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `description_tours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `seat` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `status` enum('START','PROCESSING','END') DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `tours_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tour_desciption_tour_idx` (`tours_id`),
  CONSTRAINT `fk_tour_desciption_tour` FOREIGN KEY (`tours_id`) REFERENCES `tours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description_tours`
--

LOCK TABLES `description_tours` WRITE;
/*!40000 ALTER TABLE `description_tours` DISABLE KEYS */;
INSERT INTO `description_tours` VALUES (23,'2024-02-12','2024-02-15',10,12399000,'PROCESSING','Bay Vietjet Air - Mùng 2 Tết',14),(24,'2024-02-12','2024-02-16',10,12399000,'PROCESSING','Bay Vietjet Air - Mùng 3 Tết',14),(25,'2024-02-13','2024-02-17',10,12399000,'PROCESSING','Bay Vietjet Air - Mùng 4 Tết',14),(26,'2024-01-14','2024-01-16',12,12799000,'PROCESSING','Bay Vietjet Air - Mùng 2 Tết',15),(27,'2024-01-12','2024-01-16',10,12799000,'PROCESSING','Bay Vietjet Air - Mùng 3 Tết',15),(28,'2024-02-13','2024-02-16',10,12799000,'PROCESSING','Bay Vietjet Air - Mùng 4 Tết',15),(30,'2024-01-08','2024-01-11',12,12999000,'START','Đi chơi mùa sắp tết',28);
/*!40000 ALTER TABLE `description_tours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `accounts_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employees_accounts1_idx` (`accounts_id`),
  CONSTRAINT `fk_employees_accounts1` FOREIGN KEY (`accounts_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'ngan98','091242151512','hue',2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `urlImage` varchar(350) DEFAULT NULL,
  `type` enum('DOMESTIC','FOREIGN') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (14,'Du lịch Đông Bắc Tết Nguyên Đán - Hà Nội - Hà Giang - Quản Bạ - Sông Nho Quế từ Cần Thơ 2024','tua-tet-am-lich-song-nho-que-du-lich-viet.jpg','DOMESTIC'),(15,'Du lịch Tết Âm lịch - Vịnh Hạ Long - Yên Tử - Sapa từ Cần Thơ 2024','tour-vinh-ha-long-tet-nguyen-dan-du-lich-viet.jpg','DOMESTIC'),(16,'Du lịch Tết Nguyên Đán 2024 - Hà Nội - Mai Châu - Mộc Châu - Ninh Bình từ Cần Thơ','tour-du-lich-moc-chau-tet-am-lich-du-lich-viet.jpg','DOMESTIC'),(17,'Du lịch Tây Bắc Tết Âm lịch - Hà Nội - Mộc Châu - Sơn La - Điện Biên 6N5Đ từ Sài Gòn 2024','tour-moc-chau-tet-giap-thin-du-lich-viet.jpg','DOMESTIC'),(18,'Du lịch Miền Bắc Tết Âm lịch - Hà Nội - Yên Tử - Hạ Long - Sapa 6N5Đ từ Sài Gòn 2024','tua-ha-noi-tet-nguyen-dan-du-lich-viet.jpg','DOMESTIC'),(19,'Du lịch Đông Bắc Tết Âm lịch - Hà Giang - Quản Bạ - Cao Bằng 6N5Đ từ Sài Gòn 2024','thac-ban-gioc-tour-tet-giap-thin-du-lich-viet.jpg','DOMESTIC'),(20,'Du lịch Tây Bắc Tết Âm lịch - Hà Nội - Mộc Châu - Điện Biên - Sapa từ Sài Gòn 2024','du-lich-moc-chau-tet-am-lich-du-lich-viet.jpg','DOMESTIC'),(21,'Du lịch Mỹ Tết Âm lịch - Liên Tuyến Đông Tây Hoa Kỳ từ Sài Gòn 2024','tour-las-vegas.jpg','FOREIGN'),(22,'Tour Thái Lan Tết Nguyên Đán 2024 - Thiên Đường Biển Phuket - Đảo Phi Phi','tour-thai-lan.jpg','FOREIGN'),(23,'Du lịch Mỹ Tết Âm lịch - New York - Philadelphia - Washington D.C từ Sài Gòn 2024','tour-las-vegas.jpg','FOREIGN'),(26,'Du lịch Tết Nguyên Đán Tour Nhật Bản Osaka - Kyoto - Fuji - Tokyo từ Hà Nội 2024','du-lich-nhat-ban-tet-du-lich-viet.jpg','FOREIGN'),(28,'Du lịch Tết Nguyên Đán 2024 - Tour Du lịch Đức - Hà Lan - Bỉ - Pháp - Thụy Sĩ','du-lich-phap-tet-du-lich-phap.jpg','FOREIGN'),(29,'12','3344343','DOMESTIC'),(30,'Chuyến đi mùa đông 12','tour-las-vegas.jpg','FOREIGN'),(31,'Tour Han Quoc','lang-van-hoa-thap-phan-gia-tot-du-lich-viet.jpg','FOREIGN'),(32,'Tour Du Lich','lang-van-hoa-thap-phan-gia-tot-du-lich-viet.jpg','FOREIGN');
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_booking_seat`
--

DROP TABLE IF EXISTS `view_booking_seat`;
/*!50001 DROP VIEW IF EXISTS `view_booking_seat`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_booking_seat` AS SELECT 
 1 AS `id`,
 1 AS `dateStart`,
 1 AS `dateEnd`,
 1 AS `seat`,
 1 AS `price`,
 1 AS `status`,
 1 AS `description`,
 1 AS `tours_id`,
 1 AS `seatResidual`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_bookings`
--

DROP TABLE IF EXISTS `view_bookings`;
/*!50001 DROP VIEW IF EXISTS `view_bookings`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_bookings` AS SELECT 
 1 AS `id`,
 1 AS `seat`,
 1 AS `totalPrice`,
 1 AS `dateBooking`,
 1 AS `status`,
 1 AS `payment`,
 1 AS `customers_id`,
 1 AS `description_tours_id`,
 1 AS `employees_id`,
 1 AS `customerName`,
 1 AS `customerPhone`,
 1 AS `employeeName`,
 1 AS `employeePhone`,
 1 AS `tourName`,
 1 AS `dateStart`,
 1 AS `dateEnd`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_customer`
--

DROP TABLE IF EXISTS `view_customer`;
/*!50001 DROP VIEW IF EXISTS `view_customer`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_customer` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `phone`,
 1 AS `address`,
 1 AS `email`,
 1 AS `userName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_description_tour`
--

DROP TABLE IF EXISTS `view_description_tour`;
/*!50001 DROP VIEW IF EXISTS `view_description_tour`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_description_tour` AS SELECT 
 1 AS `id`,
 1 AS `dateStart`,
 1 AS `dateEnd`,
 1 AS `seat`,
 1 AS `price`,
 1 AS `status`,
 1 AS `description`,
 1 AS `tours_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_employee`
--

DROP TABLE IF EXISTS `view_employee`;
/*!50001 DROP VIEW IF EXISTS `view_employee`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_employee` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `phone`,
 1 AS `address`,
 1 AS `userName`,
 1 AS `urlImage`,
 1 AS `role`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_tour`
--

DROP TABLE IF EXISTS `view_tour`;
/*!50001 DROP VIEW IF EXISTS `view_tour`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_tour` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `urlImage`,
 1 AS `type`,
 1 AS `totalTrips`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_booking_seat`
--

/*!50001 DROP VIEW IF EXISTS `view_booking_seat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_booking_seat` AS select `dt`.`id` AS `id`,`dt`.`dateStart` AS `dateStart`,`dt`.`dateEnd` AS `dateEnd`,`dt`.`seat` AS `seat`,`dt`.`price` AS `price`,`dt`.`status` AS `status`,`dt`.`description` AS `description`,`dt`.`tours_id` AS `tours_id`,(`dt`.`seat` - ifnull(sum(`b`.`seat`),0)) AS `seatResidual` from (`description_tours` `dt` left join `bookings` `b` on(((`b`.`description_tours_id` = `dt`.`id`) and ((`b`.`status` = 'PROCESSING') or (`b`.`status` = 'PROCESSED'))))) group by `dt`.`id` having (`seatResidual` > 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_bookings`
--

/*!50001 DROP VIEW IF EXISTS `view_bookings`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_bookings` AS select `b`.`id` AS `id`,`b`.`seat` AS `seat`,`b`.`totalPrice` AS `totalPrice`,`b`.`dateBooking` AS `dateBooking`,`b`.`status` AS `status`,`b`.`payment` AS `payment`,`b`.`customers_id` AS `customers_id`,`b`.`description_tours_id` AS `description_tours_id`,`b`.`employees_id` AS `employees_id`,`c`.`name` AS `customerName`,`c`.`phone` AS `customerPhone`,`e`.`name` AS `employeeName`,`e`.`phone` AS `employeePhone`,`t`.`name` AS `tourName`,`dt`.`dateStart` AS `dateStart`,`dt`.`dateEnd` AS `dateEnd` from ((((`bookings` `b` join `customers` `c` on((`c`.`id` = `b`.`customers_id`))) left join `employees` `e` on((`e`.`id` = `b`.`employees_id`))) join `description_tours` `dt` on((`dt`.`id` = `b`.`description_tours_id`))) join `tours` `t` on((`dt`.`tours_id` = `t`.`id`))) order by field(`b`.`status`,'processed','processing','cancel'),`b`.`id` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_customer`
--

/*!50001 DROP VIEW IF EXISTS `view_customer`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_customer` AS select `c`.`id` AS `id`,`c`.`name` AS `name`,`c`.`phone` AS `phone`,`c`.`address` AS `address`,`c`.`email` AS `email`,`a`.`userName` AS `userName` from (`customers` `c` join `accounts` `a` on((`c`.`accounts_id` = `a`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_description_tour`
--

/*!50001 DROP VIEW IF EXISTS `view_description_tour`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_description_tour` AS select `dt`.`id` AS `id`,`dt`.`dateStart` AS `dateStart`,`dt`.`dateEnd` AS `dateEnd`,`dt`.`seat` AS `seat`,`dt`.`price` AS `price`,`dt`.`status` AS `status`,`dt`.`description` AS `description`,`dt`.`tours_id` AS `tours_id` from (`description_tours` `dt` join `tours` `t` on((`dt`.`tours_id` = `t`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_employee`
--

/*!50001 DROP VIEW IF EXISTS `view_employee`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_employee` AS select `e`.`id` AS `id`,`e`.`name` AS `name`,`e`.`phone` AS `phone`,`e`.`address` AS `address`,`a`.`userName` AS `userName`,`a`.`urlImage` AS `urlImage`,`a`.`role` AS `role` from (`employees` `e` join `accounts` `a` on((`e`.`accounts_id` = `a`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_tour`
--

/*!50001 DROP VIEW IF EXISTS `view_tour`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_tour` AS select `t`.`id` AS `id`,`t`.`name` AS `name`,`t`.`urlImage` AS `urlImage`,`t`.`type` AS `type`,ifnull(count(`dt`.`id`),0) AS `totalTrips` from (`tours` `t` left join `description_tours` `dt` on((`t`.`id` = `dt`.`tours_id`))) group by `t`.`id` order by `t`.`id` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-09 15:31:15
