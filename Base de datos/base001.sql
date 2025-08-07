/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.21 : Database - soporte
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`soporte` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `soporte`;

/*Table structure for table `tabla de simulacion` */

DROP TABLE IF EXISTS `tabla de simulacion`;

CREATE TABLE `tabla de simulacion` (
  `cedula` varchar(10) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` decimal(8,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tabla de simulacion` */

insert  into `tabla de simulacion`(`cedula`,`nombre`,`direccion`,`telefono`) values ('504250044','Emilio Guevara','25 sur del cemeterio',61903397);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
