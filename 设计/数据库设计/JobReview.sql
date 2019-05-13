/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jobreview

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-13 23:20:14
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('4', '3', '123', '1');

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
  `ct_standard` int(11) NOT NULL DEFAULT '1',
  `ct_start_time` datetime NOT NULL,
  `ct_end_time` datetime NOT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `FK_Relationship_7` (`task_id`),
  KEY `FK_Relationship_8` (`class_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_task
-- ----------------------------
INSERT INTO `t_class_task` VALUES ('3', '1', '4', '1', '3', '1', '20', '1', '2019-05-13 11:38:30', '2019-05-13 11:38:31');
INSERT INTO `t_class_task` VALUES ('5', '2', '4', '1', '3', '1', '80', '2', '2019-05-13 11:42:13', '2019-05-13 11:42:14');
INSERT INTO `t_class_task` VALUES ('6', '3', '4', '1', '3', '1', '30', '3', '2019-05-13 17:44:31', '2019-05-13 17:44:33');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('3', '2', null, '第一组', '第一组');
INSERT INTO `t_group` VALUES ('4', '2', null, '第二组', '第二组');
INSERT INTO `t_group` VALUES ('5', '2', null, '第三组', '第三组');
INSERT INTO `t_group` VALUES ('6', '3', null, '第一组1', 'xxxx1组房');
INSERT INTO `t_group` VALUES ('7', '4', null, '123', '123');
INSERT INTO `t_group` VALUES ('8', '4', null, '123', '123');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `student_num` varchar(20) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_uname` varchar(20) NOT NULL,
  `student_pwd` varchar(30) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_2` (`class_id`),
  KEY `FK_Relationship_17` (`group_id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('100', '4', null, '123123', '123', '312321', '123321', '3');
INSERT INTO `t_student` VALUES ('101', '4', null, '321321', '张三', '222222', '222222 ', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('1', '1', '21313123');
INSERT INTO `t_subject` VALUES ('2', '2', '123');
INSERT INTO `t_subject` VALUES ('3', '2', '123');
INSERT INTO `t_subject` VALUES ('4', '3', '234234');
INSERT INTO `t_subject` VALUES ('5', '3', '234234');

-- ----------------------------
-- Table structure for `t_subject_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject_student`;
CREATE TABLE `t_subject_student` (
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
-- Records of t_subject_student
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '3', '任务1', '1');
INSERT INTO `t_task` VALUES ('2', '3', '修改', '1');
INSERT INTO `t_task` VALUES ('3', '3', '2342', '2');

-- ----------------------------
-- Table structure for `t_task_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_status`;
CREATE TABLE `t_task_status` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `ct_id` int(11) NOT NULL,
  `last_submit_time` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `gread` int(11) DEFAULT NULL,
  `adopt` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FK_Relationship_14` (`ct_id`),
  KEY `FK_Relationship_15` (`student_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`ct_id`) REFERENCES `t_class_task` (`ct_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_status
-- ----------------------------
INSERT INTO `t_task_status` VALUES ('1', '101', null, '3', '2019-05-13 16:52:25', '10', null, null);
INSERT INTO `t_task_status` VALUES ('2', '101', null, '5', null, null, '3', null);
INSERT INTO `t_task_status` VALUES ('3', '100', null, '5', null, null, '2', null);
INSERT INTO `t_task_status` VALUES ('4', '101', null, '6', null, null, null, '2');
INSERT INTO `t_task_status` VALUES ('5', '100', null, '6', null, null, null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('3', '教师一', '111111', '111111', '2');

-- ----------------------------
-- Table structure for `t_work`
-- ----------------------------
DROP TABLE IF EXISTS `t_work`;
CREATE TABLE `t_work` (
  `work_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `work_name` varchar(50) NOT NULL,
  `code_path` varchar(100) DEFAULT NULL,
  `pic_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`work_id`),
  KEY `FK_Relationship_12` (`subject_id`),
  KEY `FK_Relationship_13` (`student_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work
-- ----------------------------
INSERT INTO `t_work` VALUES ('1', '1', '101', null, 'Jobf533c56b3328416ea47f48d00c380a4e.txt', 'D:\\jobReview\\job\\Jobf533c56b3328416ea47f48d00c380a4e.txt', null);

-- ----------------------------
-- View structure for `v_class_task_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_class_task_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_class_task_info` AS select `c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`ct`.`ct_id` AS `ct_id`,`ct`.`ct_type` AS `ct_type`,`ct`.`ct_status` AS `ct_status`,`ct`.`ct_semester` AS `ct_semester`,`ct`.`ct_proportion` AS `ct_proportion`,`ct`.`ct_standard` AS `ct_standard`,`ct`.`ct_start_time` AS `ct_start_time`,`ct`.`ct_end_time` AS `ct_end_time`,`t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type` from ((`t_class_task` `ct` left join `t_class` `c` on((`c`.`class_id` = `ct`.`class_id`))) left join `t_task` `t` on((`ct`.`task_id` = `t`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_division`
-- ----------------------------
DROP VIEW IF EXISTS `v_division`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_division` AS select `ss`.`ss_id` AS `ss_id`,`ss`.`subject_id` AS `subject_id`,`s`.`group_id` AS `group_id`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name` from (`t_subject_student` `ss` left join `t_student` `s` on((`ss`.`student_id` = `s`.`student_id`))) ;

-- ----------------------------
-- View structure for `v_group_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_group_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_group_info` AS select `g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name`,`lead`.`student_id` AS `leader_id`,`lead`.`student_name` AS `leader_name`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name` from ((`t_group` `g` left join `t_student` `lead` on((`g`.`leader_id` = `lead`.`student_id`))) left join `t_student` `s` on((`g`.`group_id` = `s`.`group_id`))) ;

-- ----------------------------
-- View structure for `v_student_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_student_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_student_info` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`student_num` AS `student_num`,`c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`c`.`class_semester` AS `class_semester`,`g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name` from ((`t_student` `s` left join `t_class` `c` on((`s`.`class_id` = `c`.`class_id`))) left join `t_group` `g` on((`s`.`group_id` = `g`.`group_id`))) ;

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
