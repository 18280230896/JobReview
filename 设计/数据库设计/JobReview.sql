/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jobreview

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-16 10:06:44
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
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '1', '616322', '1');

-- ----------------------------
-- Table structure for `t_class_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_class_task`;
CREATE TABLE `t_class_task` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `ct_type` int(11) NOT NULL,
  `ct_status` int(11) NOT NULL,
  `ct_semester` int(11) NOT NULL,
  `ct_proportion` int(11) NOT NULL,
  `ct_start_time` datetime NOT NULL,
  `ct_end_time` datetime NOT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `FK_Relationship_7` (`task_id`),
  KEY `FK_Relationship_8` (`class_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_task
-- ----------------------------
INSERT INTO `t_class_task` VALUES ('1', '1', '1', '1', '1', '1', '5', '2019-04-18 15:53:36', '2019-05-04 15:54:26');

-- ----------------------------
-- Table structure for `t_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `leader_id` int(11) DEFAULT NULL,
  `group_num` varchar(30) NOT NULL,
  `group_name` varchar(30) NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FK_Relationship_16` (`leader_id`),
  KEY `FK_Relationship_3` (`class_id`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`leader_id`) REFERENCES `t_student` (`student_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('1', '1', '4', '第一组帆帆发', '第一组啊啊');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_uname` varchar(20) NOT NULL,
  `student_pwd` varchar(30) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_2` (`class_id`),
  KEY `FK_Relationship_17` (`group_id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '1', null, '1231', '312312312', '3123123', '3');
INSERT INTO `t_student` VALUES ('3', '1', null, '学生1', 'username1', 'password1', '3');
INSERT INTO `t_student` VALUES ('4', '1', '1', '学生3', 'username3', 'password3', '3');
INSERT INTO `t_student` VALUES ('5', '1', '1', '学生5', 'username5', 'password5', '3');
INSERT INTO `t_student` VALUES ('6', '1', '1', '学生7', 'username7', 'password7', '3');
INSERT INTO `t_student` VALUES ('7', '1', '1', '学生9', 'username9', 'password9', '3');
INSERT INTO `t_student` VALUES ('8', '1', '1', '学生10', 'username10', 'password10', '3');
INSERT INTO `t_student` VALUES ('9', '1', null, '学生12', 'username12', 'password12', '3');
INSERT INTO `t_student` VALUES ('11', '1', null, '学生15q\'we', 'username15', 'pasqwe', '3');
INSERT INTO `t_student` VALUES ('12', '1', null, '学生16', 'username16', 'password16', '3');

-- ----------------------------
-- Table structure for `t_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `FK_Relationship_9` (`task_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('6', '3', '这是第一个题目去');
INSERT INTO `t_subject` VALUES ('7', '4', '这是第一个题目去');
INSERT INTO `t_subject` VALUES ('8', '4', '这是第一个题目去');
INSERT INTO `t_subject` VALUES ('9', '4', '这是第一个题目去');
INSERT INTO `t_subject` VALUES ('14', '1', '额外热切');
INSERT INTO `t_subject` VALUES ('15', '1', '这是第一个题目');

-- ----------------------------
-- Table structure for `t_subject_studnet`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject_studnet`;
CREATE TABLE `t_subject_studnet` (
  `ss_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`ss_id`),
  KEY `FK_Relationship_10` (`subject_id`),
  KEY `FK_Relationship_11` (`student_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `teacher_id` int(11) NOT NULL,
  `task_name` varchar(30) NOT NULL,
  `task_type` int(11) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_Relationship_6` (`teacher_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '1', '任务单', '2');
INSERT INTO `t_task` VALUES ('3', '1', '其为人温柔', '1');
INSERT INTO `t_task` VALUES ('4', '1', '啊123', '1');

-- ----------------------------
-- Table structure for `t_task_file`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_file`;
CREATE TABLE `t_task_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `file_name` varchar(30) NOT NULL,
  `file_path` varchar(30) NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_Relationship_12` (`subject_id`),
  KEY `FK_Relationship_13` (`student_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `student_id` int(11) NOT NULL,
  `ct_id` int(11) NOT NULL,
  `score_num` int(11) NOT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FK_Relationship_14` (`ct_id`),
  KEY `FK_Relationship_15` (`student_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`ct_id`) REFERENCES `t_class_task` (`ct_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '测试教师', '111111', '111111', '2');

-- ----------------------------
-- View structure for `v_class_task_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_class_task_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_class_task_info` AS select `c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`ct`.`ct_id` AS `ct_id`,`ct`.`ct_type` AS `ct_type`,`ct`.`ct_status` AS `ct_status`,`ct`.`ct_semester` AS `ct_semester`,`ct`.`ct_proportion` AS `ct_proportion`,`ct`.`ct_start_time` AS `ct_start_time`,`ct`.`ct_end_time` AS `ct_end_time`,`t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type` from ((`t_class_task` `ct` left join `t_class` `c` on((`c`.`class_id` = `ct`.`class_id`))) left join `t_task` `t` on((`ct`.`task_id` = `t`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_group_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_group_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_group_info` AS select `g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name`,`lead`.`student_id` AS `leader_id`,`lead`.`student_name` AS `leader_name`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name` from ((`t_group` `g` left join `t_student` `lead` on((`g`.`leader_id` = `lead`.`student_id`))) left join `t_student` `s` on((`g`.`group_id` = `s`.`group_id`))) ;

-- ----------------------------
-- View structure for `v_task_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_task_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_task_info` AS select `t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type`,`s`.`subject_id` AS `subject_id`,`s`.`subject_name` AS `subject_name` from (`t_task` `t` left join `t_subject` `s` on((`t`.`task_id` = `s`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user` AS select `t_admin`.`admin_id` AS `id`,`t_admin`.`admin_name` AS `name`,`t_admin`.`admin_uname` AS `username`,`t_admin`.`admin_pwd` AS `password`,`t_admin`.`role` AS `role` from `t_admin` union all select `t_teacher`.`teacher_id` AS `id`,`t_teacher`.`teacher_name` AS `name`,`t_teacher`.`teacher_uname` AS `username`,`t_teacher`.`teacher_pwd` AS `password`,`t_teacher`.`role` AS `role` from `t_teacher` union all select `t_student`.`student_id` AS `id`,`t_student`.`student_name` AS `name`,`t_student`.`student_uname` AS `username`,`t_student`.`student_pwd` AS `password`,`t_student`.`role` AS `role` from `t_student` ;

-- ----------------------------
-- Procedure structure for `p_timing`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_timing`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_timing`()
begin
	update t_class_task set ct_status=1 where now()<ct_start_time;
	update t_class_task set ct_status=2 where now()>ct_start_time and now()<ct_end_time;
	update t_class_task set ct_status=3 where now()>ct_end_time;
end
;;
DELIMITER ;

-- ----------------------------
-- Event structure for `e_timer`
-- ----------------------------
DROP EVENT IF EXISTS `e_timer`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `e_timer` ON SCHEDULE EVERY 5 SECOND STARTS '2018-01-01 00:00:00' ON COMPLETION PRESERVE ENABLE DO call p_timing()
;;
DELIMITER ;
