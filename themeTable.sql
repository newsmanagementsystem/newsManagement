/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.24-log : Database - newsdatabase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`newsdatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `newsdatabase`;

/*Table structure for table `themetable` */

DROP TABLE IF EXISTS `themetable`;

CREATE TABLE `themetable` (
  `themeID` int(11) NOT NULL AUTO_INCREMENT,
  `themeName` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`themeID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `themetable` */

insert  into `themetable`(`themeID`,`themeName`) values (1,'国内'),(2,'国际'),(3,'军事'),(4,'体育'),(5,'娱乐'),(6,'社会'),(7,'财经'),(8,'科技'),(9,'健康'),(10,'汽车'),(11,'教育'),(12,'房产'),(13,'家居'),(14,'旅游'),(15,'文化'),(16,'其它'),(28,'探索'),(29,'另类'),(33,'Chinese'),(34,'语文'),(35,'数学');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
