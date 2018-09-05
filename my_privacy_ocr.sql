/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - myprivacy_ocr
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `myprivacy_ocr`;

USE `myprivacy_ocr`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `adminlogin` */

DROP TABLE IF EXISTS `adminlogin`;

CREATE TABLE `adminlogin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `adminid` varchar(20) NOT NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`,`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `adminlogin` */

insert into `adminlogin` (`id`,`name`,`password`,`adminid`,`phone`,`email`) values (1,'admin','admin','admin','9887878787','adminn123@gmail.com');

/*Table structure for table `friend_recommand` */

DROP TABLE IF EXISTS `friend_recommand`;

CREATE TABLE `friend_recommand` (
  `s_no` int(10) NOT NULL auto_increment,
  `user_id` int(20) default NULL,
  `ont_pattern` varchar(50) default NULL,
  `browse_pattern` varchar(60) default NULL,
  `hobby_pattern` varchar(70) default NULL,
  `place_pattern` varchar(20) default NULL,
  `total_weightage` varchar(20) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `friend_recommand` */

/*Table structure for table `imagecount` */

DROP TABLE IF EXISTS `imagecount`;

CREATE TABLE `imagecount` (
  `s_no` int(3) NOT NULL auto_increment,
  `Count1` int(4) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `imagecount` */

insert into `imagecount` (`s_no`,`Count1`) values (1,3);

/*Table structure for table `m_group` */

DROP TABLE IF EXISTS `m_group`;

CREATE TABLE `m_group` (
  `id` int(5) NOT NULL auto_increment,
  `grp_uid` varchar(50) default NULL,
  `grp_in` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_group` */

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `i_code` int(11) NOT NULL auto_increment,
  `u_code` int(11) NOT NULL,
  `i_file_name` varchar(100) NOT NULL,
  `img_tag_date` datetime default NULL,
  PRIMARY KEY  (`i_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

/*Table structure for table `m_pattern` */

DROP TABLE IF EXISTS `m_pattern`;

CREATE TABLE `m_pattern` (
  `pat_no` int(20) NOT NULL auto_increment,
  `seq_id` int(20) default NULL,
  `pattern` varchar(50) default NULL,
  PRIMARY KEY  (`pat_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_pattern` */

/*Table structure for table `m_request` */

DROP TABLE IF EXISTS `m_request`;

CREATE TABLE `m_request` (
  `id` int(5) NOT NULL auto_increment,
  `req_from` varchar(50) default NULL,
  `req_to` varchar(50) default NULL,
  `req_status` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_request` */

insert into `m_request` (`id`,`req_from`,`req_to`,`req_status`) values (1,'RAJAN','BHARATH','pending');
insert into `m_request` (`id`,`req_from`,`req_to`,`req_status`) values (2,'BHARATH','RAJAN','pending');

/*Table structure for table `m_site` */

DROP TABLE IF EXISTS `m_site`;

CREATE TABLE `m_site` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_url` varchar(255) default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_site` */

insert into `m_site` (`m_id`,`m_url`) values (1,'www.google.co.in');
insert into `m_site` (`m_id`,`m_url`) values (2,'www.facebook.com');
insert into `m_site` (`m_id`,`m_url`) values (3,'www.google.com');

/*Table structure for table `m_status` */

DROP TABLE IF EXISTS `m_status`;

CREATE TABLE `m_status` (
  `s_no` int(20) NOT NULL auto_increment,
  `u_name` varchar(50) default NULL,
  `tot_req` int(20) default '0',
  `acc_req` int(20) default '0',
  `rej_req` int(20) default '0',
  `pending` int(20) default '0',
  `rej_ratio` varchar(20) default '0',
  `pen_ratio` varchar(20) default '0',
  `total_ratio` varchar(20) default '0',
  `u_status` varchar(20) default 'general',
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_status` */

insert into `m_status` (`s_no`,`u_name`,`tot_req`,`acc_req`,`rej_req`,`pending`,`rej_ratio`,`pen_ratio`,`total_ratio`,`u_status`) values (1,'RAJAN',1,0,0,1,'0','0','0','general');
insert into `m_status` (`s_no`,`u_name`,`tot_req`,`acc_req`,`rej_req`,`pending`,`rej_ratio`,`pen_ratio`,`total_ratio`,`u_status`) values (2,'bharath',1,0,0,1,'0','0','0','general');
insert into `m_status` (`s_no`,`u_name`,`tot_req`,`acc_req`,`rej_req`,`pending`,`rej_ratio`,`pen_ratio`,`total_ratio`,`u_status`) values (3,'RAJ',0,0,0,0,'0','0','0','general');
insert into `m_status` (`s_no`,`u_name`,`tot_req`,`acc_req`,`rej_req`,`pending`,`rej_ratio`,`pen_ratio`,`total_ratio`,`u_status`) values (4,'BHARATH',1,0,0,1,'0','0','0','general');
insert into `m_status` (`s_no`,`u_name`,`tot_req`,`acc_req`,`rej_req`,`pending`,`rej_ratio`,`pen_ratio`,`total_ratio`,`u_status`) values (5,'VANI',0,0,0,0,'0','0','0','general');

/*Table structure for table `m_tag` */

DROP TABLE IF EXISTS `m_tag`;

CREATE TABLE `m_tag` (
  `tag_no` int(20) NOT NULL auto_increment,
  `i_code` int(15) default NULL,
  `u_code` int(15) default NULL,
  `tag` varchar(500) default NULL,
  `time` varchar(50) default NULL,
  PRIMARY KEY  (`tag_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_tag` */

/*Table structure for table `m_unfriends` */

DROP TABLE IF EXISTS `m_unfriends`;

CREATE TABLE `m_unfriends` (
  `u_no` int(20) NOT NULL auto_increment,
  `u_from` varchar(50) default NULL,
  `u_to` varchar(50) default NULL,
  PRIMARY KEY  (`u_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_unfriends` */

/*Table structure for table `m_update` */

DROP TABLE IF EXISTS `m_update`;

CREATE TABLE `m_update` (
  `id` int(5) NOT NULL auto_increment,
  `up_from` varchar(50) default NULL,
  `up_to` varchar(50) default NULL,
  `up_msg` varchar(300) default NULL,
  `flag` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_update` */

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_code` int(11) NOT NULL auto_increment,
  `u_login_id` char(50) default NULL,
  `u_uid_img` varchar(30) default NULL,
  `u_pwd` char(20) default NULL,
  `u_name` varchar(50) default NULL,
  `u_gender` char(10) default NULL,
  `d_o_b` varchar(20) default NULL,
  `u_cell_no` varchar(25) default NULL,
  `u_profile_pic` varchar(150) default NULL,
  `hobbies` varchar(50) default NULL,
  `place` varchar(50) default NULL,
  `tell_about` varchar(1000) default NULL,
  `ontology_pattern` varchar(100) default NULL,
  `feature` text,
  `matches_points` int(200) default NULL,
  `policy` varchar(50) default NULL,
  `ocr_id` varchar(50) default NULL,
  PRIMARY KEY  (`u_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_code`,`u_login_id`,`u_uid_img`,`u_pwd`,`u_name`,`u_gender`,`d_o_b`,`u_cell_no`,`u_profile_pic`,`hobbies`,`place`,`tell_about`,`ontology_pattern`,`feature`,`matches_points`,`policy`,`ocr_id`) values (1,'kumarbharath21011991@gmail.com','RAJAN.jpg','RAJAN','RAJAN','MALE','13/03/1960','7795204296','RAJAN.jpg','dance','kunigal',NULL,NULL,'9.0E-4-13.8397-0.2-9.0725-2.0E-4-7.0E-4-29.5669-0.1089-9.6301-1.0E-4-5.0E-4-44.4269-0.0723-9.8268-1.0E-4-4.0E-4-54.6548-0.0562-9.8792-1.0E-4',NULL,NULL,'RAJAN\n\n');
insert into `m_user` (`u_code`,`u_login_id`,`u_uid_img`,`u_pwd`,`u_name`,`u_gender`,`d_o_b`,`u_cell_no`,`u_profile_pic`,`hobbies`,`place`,`tell_about`,`ontology_pattern`,`feature`,`matches_points`,`policy`,`ocr_id`) values (4,'kumarbharath21011991@gmail.com','BHARATH.jpg','BHARATH','BHARATH','MALE','19/01/1967','7795204296','BHARATH.jpg','dance','kunigal',NULL,NULL,'0.0016-4.8052-0.3503-7.9537-5.0E-4-0.001-10.2314-0.2224-8.7099-2.0E-4-8.0E-4-16.825-0.1623-9.1455-2.0E-4-7.0E-4-23.9749-0.1226-9.4051-1.0E-4',NULL,NULL,'BHARATH');
insert into `m_user` (`u_code`,`u_login_id`,`u_uid_img`,`u_pwd`,`u_name`,`u_gender`,`d_o_b`,`u_cell_no`,`u_profile_pic`,`hobbies`,`place`,`tell_about`,`ontology_pattern`,`feature`,`matches_points`,`policy`,`ocr_id`) values (5,'VANI@gmail.com','VANI.jpg','vani','VANI','FEMALE','19/01/1968','7795204296','VANI.jpg','dance',NULL,NULL,NULL,'0.0016-4.8052-0.3503-7.9537-5.0E-4-0.001-10.2314-0.2224-8.7099-2.0E-4-8.0E-4-16.825-0.1623-9.1455-2.0E-4-7.0E-4-23.9749-0.1226-9.4051-1.0E-4',NULL,'Get Aproval','VANI\n\n');

/*Table structure for table `m_user1` */

DROP TABLE IF EXISTS `m_user1`;

CREATE TABLE `m_user1` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_user` varchar(50) default NULL,
  `m_pass` varchar(50) default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user1` */

insert into `m_user1` (`m_id`,`m_user`,`m_pass`) values (1,'RAJAN','RAJAN');
insert into `m_user1` (`m_id`,`m_user`,`m_pass`) values (2,'bharath','bharath');
insert into `m_user1` (`m_id`,`m_user`,`m_pass`) values (3,'RAJ','RAJ');
insert into `m_user1` (`m_id`,`m_user`,`m_pass`) values (4,'BHARATH','BHARATH');
insert into `m_user1` (`m_id`,`m_user`,`m_pass`) values (5,'VANI','vani');

/*Table structure for table `m_votes` */

DROP TABLE IF EXISTS `m_votes`;

CREATE TABLE `m_votes` (
  `Post_no` int(10) NOT NULL auto_increment,
  `post_code_id` int(10) default NULL,
  `total_faces` int(20) default NULL,
  `no_of_nonfriends` int(20) default NULL,
  `no_of_friends` int(20) default NULL,
  `no_unknown` int(20) default NULL,
  `pos_vote` int(20) default NULL,
  `neg_vot` int(20) default NULL,
  `status` varchar(50) default NULL,
  PRIMARY KEY  (`Post_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_votes` */

/*Table structure for table `post_req` */

DROP TABLE IF EXISTS `post_req`;

CREATE TABLE `post_req` (
  `id` int(10) NOT NULL auto_increment,
  `post_req_from` varchar(15) default NULL,
  `post_req_to` varchar(15) default NULL,
  `status` varchar(50) default 'pending',
  `p_id` int(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `post_req` */

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id_key` int(50) NOT NULL auto_increment,
  `id` int(50) default '0',
  `dist` int(100) default '0',
  PRIMARY KEY  (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test` */

/*Table structure for table `view1` */

DROP TABLE IF EXISTS `view1`;

DROP VIEW IF EXISTS `view1`;

CREATE TABLE `view1` (
  `u_name` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*View structure for view `view1` */

drop view if exists `view1`;

drop table if exists `view1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view1` AS select `m_status`.`u_name` AS `u_name` from `m_status` where (`m_status`.`acc_req` > 1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
