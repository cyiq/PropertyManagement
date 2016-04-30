/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - property
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`property` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `property`;

/*Table structure for table `applylist` */

CREATE TABLE `applylist` (
  `applyid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `sname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `deviceid` int(11) DEFAULT NULL,
  `devicename` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `deviceprice` double DEFAULT NULL,
  `applynumber` int(11) DEFAULT NULL,
  `sumprice` double DEFAULT NULL,
  PRIMARY KEY (`applyid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `applylist` */

insert  into `applylist`(`applyid`,`sid`,`sname`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`) values (20,4,'一号',1,'拖把',8.5,2,17);
insert  into `applylist`(`applyid`,`sid`,`sname`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`) values (21,5,'erhao',1,'拖把',8.5,10,85);

/*Table structure for table `chargelist` */

CREATE TABLE `chargelist` (
  `chargeid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `sname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `applyid` int(11) DEFAULT NULL,
  `deviceid` int(11) DEFAULT NULL,
  `devicename` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `deviceprice` double DEFAULT NULL,
  `applynumber` int(11) DEFAULT NULL,
  `sumprice` double DEFAULT NULL,
  `date` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`chargeid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `chargelist` */

insert  into `chargelist`(`chargeid`,`sid`,`sname`,`loginName`,`applyid`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`,`date`) values (2,5,'erhao','1330102',17,4,'笤帚',5.5,55,302.5,'2016-04-10-18:32:49');
insert  into `chargelist`(`chargeid`,`sid`,`sname`,`loginName`,`applyid`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`,`date`) values (3,6,'叁号','1330103',19,4,'笤帚',5.5,333,1831.5,'2016-04-10-18:57:32');
insert  into `chargelist`(`chargeid`,`sid`,`sname`,`loginName`,`applyid`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`,`date`) values (4,4,'一号','1330101',19,1,'拖把',8.5,5,42.5,'2016-04-10-19:59:13');
insert  into `chargelist`(`chargeid`,`sid`,`sname`,`loginName`,`applyid`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`,`date`) values (5,6,'叁号','1330103',18,1,'拖把',8.5,113,960.5,'2016-04-12-14:55:57');
insert  into `chargelist`(`chargeid`,`sid`,`sname`,`loginName`,`applyid`,`deviceid`,`devicename`,`deviceprice`,`applynumber`,`sumprice`,`date`) values (6,5,'erhao','1330102',22,6,'床板',66,10,660,'2016-04-12-16:21:08');

/*Table structure for table `employee` */

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginPassword` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ismanager` int(11) DEFAULT NULL,
  `message` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employee` */

insert  into `employee`(`id`,`username`,`loginName`,`loginPassword`,`sex`,`age`,`telephone`,`address`,`ismanager`,`message`) values (1,'管理员','admin','admin','男',25,'6666666','',1,'1330101:77777777777boboadmin:66666666');
insert  into `employee`(`id`,`username`,`loginName`,`loginPassword`,`sex`,`age`,`telephone`,`address`,`ismanager`,`message`) values (2,'6666666','33333','666666','女',33,'23232','asdfsadf',1,'');

/*Table structure for table `notice` */

CREATE TABLE `notice` (
  `noticeId` int(5) NOT NULL AUTO_INCREMENT,
  `noticeDate` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `noticeTitle` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `noticeContent` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `notice` */

insert  into `notice`(`noticeId`,`noticeDate`,`noticeTitle`,`noticeContent`) values (1,NULL,'失误招领','5公寓533宿舍66666666666666666666666666666666666666666666666666666666666666666666666666666666666');
insert  into `notice`(`noticeId`,`noticeDate`,`noticeTitle`,`noticeContent`) values (2,'2016-04-12-16:16:36','今天下午','不上课666666666666666666666');

/*Table structure for table `publicdevice` */

CREATE TABLE `publicdevice` (
  `deviceid` int(11) NOT NULL AUTO_INCREMENT,
  `devicename` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `deviceprice` double DEFAULT NULL,
  `devicenum` int(11) DEFAULT NULL,
  PRIMARY KEY (`deviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `publicdevice` */

insert  into `publicdevice`(`deviceid`,`devicename`,`deviceprice`,`devicenum`) values (1,'拖把',8.5,55);
insert  into `publicdevice`(`deviceid`,`devicename`,`deviceprice`,`devicenum`) values (4,'笤帚',5.5,66);
insert  into `publicdevice`(`deviceid`,`devicename`,`deviceprice`,`devicenum`) values (5,'门锁',15,96);
insert  into `publicdevice`(`deviceid`,`devicename`,`deviceprice`,`devicenum`) values (6,'床板',66,888);

/*Table structure for table `student` */

CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loginPassword` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `stelephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `smessage` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`loginName`,`loginPassword`,`stelephone`,`smessage`) values (4,'一号','1330101','123456','13335454545','1330101:888888888888boboadmin:水水水水');
insert  into `student`(`sid`,`sname`,`loginName`,`loginPassword`,`stelephone`,`smessage`) values (5,'erhao','1330102','123456','1111111111111',NULL);
insert  into `student`(`sid`,`sname`,`loginName`,`loginPassword`,`stelephone`,`smessage`) values (6,'叁号','1330103','123456','222222222222',NULL);
insert  into `student`(`sid`,`sname`,`loginName`,`loginPassword`,`stelephone`,`smessage`) values (7,'aaaa','5555','asdfasdf','344334','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
