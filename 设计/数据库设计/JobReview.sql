/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : report

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-09 14:39:23
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
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `class_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_1` (`teacher_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_class_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_class_task`;
CREATE TABLE `t_class_task` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `ct_type` int(11) DEFAULT NULL,
  `ct_start_time` datetime DEFAULT NULL,
  `ct_end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `FK_Relationship_7` (`task_id`),
  KEY `FK_Relationship_8` (`class_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`leader_id`) REFERENCES `t_student` (`student_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `class_id` int(11) DEFAULT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `studnet_uname` varchar(20) DEFAULT NULL,
  `student_pwd` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_2` (`class_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------

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
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `teacher_id` int(11) DEFAULT NULL,
  `task_name` varchar(30) DEFAULT NULL,
  `task_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_Relationship_6` (`teacher_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `student_id` int(11) DEFAULT NULL,
  `ct_id` int(11) DEFAULT NULL,
  `score_num` int(11) DEFAULT NULL,
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
  `teacher_name` varchar(20) DEFAULT NULL,
  `teacher_uname` varchar(20) DEFAULT NULL,
  `teacher_pwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------

-- ----------------------------
-- View structure for `v_bug_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_bug_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_bug_info` AS select `b`.`bug_id` AS `bug_id`,`b`.`module_id` AS `module_id`,`b`.`bug_number` AS `bug_number`,`b`.`bug_summary` AS `bug_summary`,`b`.`bug_describe` AS `bug_describe`,`b`.`bug_serious` AS `bug_serious`,`b`.`bug_screenshot` AS `bug_screenshot`,`b`.`bug_case_number` AS `bug_case_number`,`b`.`bug_comment` AS `bug_comment`,`b`.`bug_is_right` AS `bug_is_right`,`b`.`bug_gui_star` AS `bug_gui_star`,`b`.`bug_fun_star` AS `bug_fun_star`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`group_id` AS `group_id`,`m`.`task_id` AS `task_id` from ((`t_bug` `b` left join `t_student` `s` on((`b`.`student_id` = `s`.`student_id`))) left join `t_module` `m` on((`b`.`module_id` = `m`.`module_id`))) ;

-- ----------------------------
-- View structure for `v_case_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_case_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_case_info` AS select `c`.`case_id` AS `case_id`,`c`.`module_id` AS `module_id`,`c`.`case_num` AS `case_num`,`c`.`case_name` AS `case_name`,`c`.`case_pc` AS `case_pc`,`c`.`case_level` AS `case_level`,`c`.`case_input` AS `case_input`,`c`.`case_step` AS `case_step`,`c`.`case_output` AS `case_output`,`c`.`case_is_right` AS `case_is_right`,`c`.`case_comment` AS `case_comment`,`s`.`student_id` AS `student_id`,`s`.`group_id` AS `group_id`,`s`.`student_name` AS `student_name`,`m`.`task_id` AS `task_id` from ((`t_case` `c` left join `t_student` `s` on((`c`.`student_id` = `s`.`student_id`))) left join `t_module` `m` on((`c`.`module_id` = `m`.`module_id`))) ;

-- ----------------------------
-- View structure for `v_class_task`
-- ----------------------------
DROP VIEW IF EXISTS `v_class_task`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_class_task` AS select `c`.`class_id` AS `class_id`,`c`.`teacher_id` AS `teacher_id`,`c`.`class_name` AS `class_name`,`ct`.`ct_id` AS `ct_id`,`ct`.`ct_start_time` AS `ct_start_time`,`ct`.`ct_end_time` AS `ct_end_time`,`ct`.`ct_status` AS `ct_status`,`t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type`,`t`.`task_describe` AS `task_describe`,`t`.`task_link` AS `task_link` from ((`t_class_task` `ct` left join `t_class` `c` on((`c`.`class_id` = `ct`.`class_id`))) left join `t_task` `t` on((`ct`.`task_id` = `t`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_class_task_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_class_task_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_class_task_info` AS select `ct`.`ct_id` AS `ct_id`,`ct`.`class_id` AS `class_id`,`ct`.`ct_start_time` AS `ct_start_time`,`ct`.`ct_end_time` AS `ct_end_time`,`ct`.`ct_status` AS `ct_status`,`t`.`task_id` AS `task_id`,`t`.`teacher_id` AS `teacher_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type`,`t`.`task_describe` AS `task_describe`,`t`.`task_link` AS `task_link`,`tf`.`task_file_id` AS `task_file_id`,`tf`.`task_file_name` AS `task_file_name`,`tf`.`task_file_path` AS `task_file_path`,`m`.`module_id` AS `module_id`,`m`.`module_name` AS `module_name` from (((`t_class_task` `ct` left join `t_task` `t` on((`ct`.`task_id` = `t`.`task_id`))) left join `t_task_file` `tf` on((`t`.`task_id` = `tf`.`task_id`))) left join `t_module` `m` on((`t`.`task_id` = `m`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_division`
-- ----------------------------
DROP VIEW IF EXISTS `v_division`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_division` AS select `m`.`task_id` AS `task_id`,`m`.`module_id` AS `module_id`,`m`.`module_name` AS `module_name`,`gt`.`gt_id` AS `gt_id`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`g`.`group_id` AS `group_id` from (((`t_group_task` `gt` left join `t_module` `m` on((`m`.`module_id` = `gt`.`module_id`))) left join `t_student` `s` on((`gt`.`student_id` = `s`.`student_id`))) left join `t_group` `g` on((`g`.`group_id` = `s`.`group_id`))) ;

-- ----------------------------
-- View structure for `v_group_file_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_group_file_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_group_file_info` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`group_id` AS `group_id`,`gf`.`group_file_id` AS `group_file_id`,`gf`.`group_file_name` AS `group_file_name`,`gf`.`group_file_path` AS `group_file_path`,`t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name` from ((`t_group_file` `gf` left join `t_student` `s` on((`s`.`student_id` = `gf`.`student_id`))) left join `t_task` `t` on((`gf`.`task_id` = `t`.`task_id`))) ;

-- ----------------------------
-- View structure for `v_group_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_group_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_group_info` AS select `g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name`,`g`.`group_slogan` AS `group_slogan`,`g`.`group_note` AS `group_note`,`g`.`group_leader_id` AS `group_leader_id`,`led`.`student_name` AS `group_leader_name`,`c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name` from (((`t_group` `g` left join `t_student` `led` on((`g`.`group_leader_id` = `led`.`student_id`))) left join `t_class` `c` on((`g`.`class_id` = `c`.`class_id`))) left join `t_student` `s` on((`g`.`group_id` = `s`.`group_id`))) ;

-- ----------------------------
-- View structure for `v_student_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_student_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_student_info` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name`,`g`.`group_slogan` AS `group_slogan`,`g`.`group_note` AS `group_note`,`c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name` from ((`t_student` `s` left join `t_group` `g` on((`s`.`group_id` = `g`.`group_id`))) left join `t_class` `c` on((`s`.`class_id` = `c`.`class_id`))) ;

-- ----------------------------
-- View structure for `v_student_join_module`
-- ----------------------------
DROP VIEW IF EXISTS `v_student_join_module`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_student_join_module` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`group_id` AS `group_id`,`gt`.`gt_id` AS `gt_id`,`m`.`module_id` AS `module_id`,`m`.`module_name` AS `module_name` from ((`t_group_task` `gt` left join `t_student` `s` on((`s`.`student_id` = `gt`.`student_id`))) left join `t_module` `m` on((`gt`.`module_id` = `m`.`module_id`))) ;

-- ----------------------------
-- View structure for `v_taskinfo`
-- ----------------------------
DROP VIEW IF EXISTS `v_taskinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_taskinfo` AS select `t`.`task_id` AS `task_id`,`t`.`teacher_id` AS `teacher_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type`,`t`.`task_describe` AS `task_describe`,`t`.`task_link` AS `task_link`,`m`.`module_id` AS `module_id`,`m`.`module_name` AS `module_name`,`f`.`task_file_id` AS `task_file_id`,`f`.`task_file_name` AS `task_file_name`,`f`.`task_file_path` AS `task_file_path` from ((`t_task` `t` left join `t_module` `m` on((`t`.`task_id` = `m`.`task_id`))) left join `t_task_file` `f` on((`t`.`task_id` = `f`.`task_id`))) ;

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
-- Event structure for `e_timing`
-- ----------------------------
DROP EVENT IF EXISTS `e_timing`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `e_timing` ON SCHEDULE EVERY 5 SECOND STARTS '2018-01-01 00:00:00' ON COMPLETION PRESERVE ENABLE DO BEGIN
call p_timing();
END
;;
DELIMITER ;
