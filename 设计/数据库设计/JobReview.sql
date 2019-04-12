/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jobreview

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-12 18:39:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) NOT NULL,
  `admin_uname` varchar(20) NOT NULL,
  `admin_pwd` varchar(30) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '管理员', 'admin', '111111', '1');

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `class_semester` int(11) NOT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_1` (`teacher_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('2', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('3', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('4', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('5', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('6', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('7', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('8', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('9', '2', '7773', '0');
INSERT INTO `t_class` VALUES ('11', '2', '7dsfsd', '0');

-- ----------------------------
-- Table structure for `t_class_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_class_task`;
CREATE TABLE `t_class_task` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `ct_type` int(11) DEFAULT NULL,
  `ct_status` int(11) DEFAULT NULL,
  `ct_semester` int(11) DEFAULT NULL,
  `ct_start_time` datetime DEFAULT NULL,
  `ct_end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `FK_Relationship_7` (`task_id`),
  KEY `FK_Relationship_8` (`class_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_task
-- ----------------------------

-- ----------------------------
-- Table structure for `t_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `leader_id` int(11) DEFAULT NULL,
  `group_num` varchar(30) DEFAULT NULL,
  `group_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FK_Relationship_16` (`leader_id`),
  KEY `FK_Relationship_3` (`class_id`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`leader_id`) REFERENCES `t_student` (`student_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------

-- ----------------------------
-- Table structure for `t_group_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_group_student`;
CREATE TABLE `t_group_student` (
  `gs_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`gs_id`),
  KEY `FK_Relationship_4` (`group_id`),
  KEY `FK_Relationship_5` (`student_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group_student
-- ----------------------------

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_uname` varchar(20) NOT NULL,
  `student_pwd` varchar(30) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_2` (`class_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '2', '222222', '222222', '222222', '3');

-- ----------------------------
-- Table structure for `t_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `FK_Relationship_9` (`task_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------

-- ----------------------------
-- Table structure for `t_subject_studnet`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject_studnet`;
CREATE TABLE `t_subject_studnet` (
  `ss_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ss_id`),
  KEY `FK_Relationship_10` (`subject_id`),
  KEY `FK_Relationship_11` (`student_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`subject_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject_studnet
-- ----------------------------

-- ----------------------------
-- Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `task_name` varchar(30) DEFAULT NULL,
  `task_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_Relationship_6` (`teacher_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------

-- ----------------------------
-- Table structure for `t_task_file`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_file`;
CREATE TABLE `t_task_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `file_name` varchar(30) DEFAULT NULL,
  `file_path` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_Relationship_12` (`subject_id`),
  KEY `FK_Relationship_13` (`student_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`subject_id`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_file
-- ----------------------------

-- ----------------------------
-- Table structure for `t_task_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_score`;
CREATE TABLE `t_task_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `ct_id` int(11) DEFAULT NULL,
  `score_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FK_Relationship_14` (`ct_id`),
  KEY `FK_Relationship_15` (`student_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`ct_id`) REFERENCES `t_class_task` (`ct_id`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_score
-- ----------------------------

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) NOT NULL,
  `teacher_uname` varchar(20) NOT NULL,
  `teacher_pwd` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('2', '测试教师', '111111', '111111', '2');
INSERT INTO `t_teacher` VALUES ('3', '222222', '222222', '222222', '2');
INSERT INTO `t_teacher` VALUES ('4', '123123', '123123', '1232133', '2');
INSERT INTO `t_teacher` VALUES ('5', '3122', '213123', '12312312', '2');
INSERT INTO `t_teacher` VALUES ('6', '123123', '1231323', '213123', '2');
INSERT INTO `t_teacher` VALUES ('7', '123123', '1231313', '1231233', '2');
INSERT INTO `t_teacher` VALUES ('8', 'qqqqqqq32', 'qqqqqq', 'qqqqqq', '2');
INSERT INTO `t_teacher` VALUES ('10', '13', '3441334', '413241324', '2');

-- ----------------------------
-- View structure for `v_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user` AS select `t_admin`.`admin_id` AS `id`,`t_admin`.`admin_name` AS `name`,`t_admin`.`admin_uname` AS `username`,`t_admin`.`admin_pwd` AS `password`,`t_admin`.`role` AS `role` from `t_admin` union all select `t_teacher`.`teacher_id` AS `id`,`t_teacher`.`teacher_name` AS `name`,`t_teacher`.`teacher_uname` AS `username`,`t_teacher`.`teacher_pwd` AS `password`,`t_teacher`.`role` AS `role` from `t_teacher` union all select `t_student`.`student_id` AS `id`,`t_student`.`student_name` AS `name`,`t_student`.`student_uname` AS `username`,`t_student`.`student_pwd` AS `password`,`t_student`.`role` AS `role` from `t_student` ;
