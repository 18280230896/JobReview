/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jobreview

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-25 16:32:03
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_task
-- ----------------------------
INSERT INTO `t_class_task` VALUES ('9', '10', '1', '1', '2', '1', '4', '2019-04-16 22:56:06', '2019-05-11 10:26:01');
INSERT INTO `t_class_task` VALUES ('10', '11', '1', '2', '2', '1', '5', '2019-04-17 13:37:42', '2019-05-11 10:10:34');
INSERT INTO `t_class_task` VALUES ('11', '12', '1', '2', '2', '1', '9', '2019-04-21 13:53:27', '2019-04-27 00:00:00');
INSERT INTO `t_class_task` VALUES ('12', '13', '1', '1', '2', '1', '4', '2019-04-21 16:41:22', '2019-04-27 00:00:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('1', '1', '13', '第一组', '第一组');
INSERT INTO `t_group` VALUES ('2', '1', null, '第二组', '第二组');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '1', null, '123', '312312312', '123', '3');
INSERT INTO `t_student` VALUES ('4', '1', null, '学生3', 'username3', 'password3', '3');
INSERT INTO `t_student` VALUES ('5', '1', '1', '学生5', 'username5', 'password5', '3');
INSERT INTO `t_student` VALUES ('7', '1', '1', '学生9', 'username9', 'password9', '3');
INSERT INTO `t_student` VALUES ('8', '1', '1', '学生10', 'username10', 'password10', '3');
INSERT INTO `t_student` VALUES ('9', '1', null, '学生12', 'username12', 'password12', '3');
INSERT INTO `t_student` VALUES ('11', '1', null, '学生15q\'we', 'username15', 'pasqwe', '3');
INSERT INTO `t_student` VALUES ('12', '1', null, '学生16', 'username16', 'password16', '3');
INSERT INTO `t_student` VALUES ('13', '1', '1', '学生1', '222222', '222222', '3');
INSERT INTO `t_student` VALUES ('14', '1', '1', '学生2', '333333', '333333', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('33', '10', '企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；');
INSERT INTO `t_subject` VALUES ('34', '10', '一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ \r\n1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。');
INSERT INTO `t_subject` VALUES ('35', '10', '输入某年某月某日，判断这一天是这一年的第几天？ \r\n1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。');
INSERT INTO `t_subject` VALUES ('36', '10', '输入三个整数x,y,z，请把这三个数由小到大输出。');
INSERT INTO `t_subject` VALUES ('37', '10', '有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ ');
INSERT INTO `t_subject` VALUES ('38', '11', '企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；');
INSERT INTO `t_subject` VALUES ('39', '11', '一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ 1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。');
INSERT INTO `t_subject` VALUES ('40', '11', '输入某年某月某日，判断这一天是这一年的第几天？ 1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。');
INSERT INTO `t_subject` VALUES ('41', '11', '输入三个整数x,y,z，请把这三个数由小到大输出。');
INSERT INTO `t_subject` VALUES ('42', '11', '有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？');
INSERT INTO `t_subject` VALUES ('43', '12', '这是题目一');
INSERT INTO `t_subject` VALUES ('44', '12', '这是题目二');
INSERT INTO `t_subject` VALUES ('45', '12', '这是题目三');
INSERT INTO `t_subject` VALUES ('46', '12', '这是题目四\r\n');
INSERT INTO `t_subject` VALUES ('47', '13', 'qefadfsadfdsfdsadfsdf');
INSERT INTO `t_subject` VALUES ('48', '13', 'sadfsdf');
INSERT INTO `t_subject` VALUES ('49', '13', 'sadfsdf');
INSERT INTO `t_subject` VALUES ('50', '13', 'safdsadf');
INSERT INTO `t_subject` VALUES ('51', '13', 'asdfsdaf');
INSERT INTO `t_subject` VALUES ('52', '13', 'efsdfsdafassdf');
INSERT INTO `t_subject` VALUES ('54', '13', 'asdfsdfsdfsdfsdfdsaf');

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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject_student
-- ----------------------------
INSERT INTO `t_subject_student` VALUES ('12', '42', '5');
INSERT INTO `t_subject_student` VALUES ('20', '41', '5');
INSERT INTO `t_subject_student` VALUES ('21', '41', '7');
INSERT INTO `t_subject_student` VALUES ('27', '39', '13');
INSERT INTO `t_subject_student` VALUES ('28', '39', '14');
INSERT INTO `t_subject_student` VALUES ('29', '40', '13');
INSERT INTO `t_subject_student` VALUES ('30', '39', '8');
INSERT INTO `t_subject_student` VALUES ('41', '38', '5');
INSERT INTO `t_subject_student` VALUES ('42', '38', '7');
INSERT INTO `t_subject_student` VALUES ('55', '43', '13');
INSERT INTO `t_subject_student` VALUES ('56', '44', '13');
INSERT INTO `t_subject_student` VALUES ('57', '45', '13');
INSERT INTO `t_subject_student` VALUES ('58', '46', '13');
INSERT INTO `t_subject_student` VALUES ('59', '44', '7');
INSERT INTO `t_subject_student` VALUES ('60', '44', '8');
INSERT INTO `t_subject_student` VALUES ('61', '42', '13');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('10', '1', '测试任务', '1');
INSERT INTO `t_task` VALUES ('11', '1', '测试任务2', '1');
INSERT INTO `t_task` VALUES ('12', '1', '测试oracle任务', '2');
INSERT INTO `t_task` VALUES ('13', '1', '测试oracle2', '2');

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
  `score_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FK_Relationship_14` (`ct_id`),
  KEY `FK_Relationship_15` (`student_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`ct_id`) REFERENCES `t_class_task` (`ct_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_status
-- ----------------------------
INSERT INTO `t_task_status` VALUES ('6', null, '1', '10', '2019-04-24 13:16:24', '11');
INSERT INTO `t_task_status` VALUES ('7', '13', null, '9', '2019-04-24 13:05:25', null);
INSERT INTO `t_task_status` VALUES ('8', '13', null, '12', '2019-04-24 16:07:49', null);
INSERT INTO `t_task_status` VALUES ('9', null, '1', '11', '2019-04-24 13:15:53', null);
INSERT INTO `t_task_status` VALUES ('10', '14', null, '9', '2019-04-24 13:16:09', '1');
INSERT INTO `t_task_status` VALUES ('11', '14', null, '12', '2019-04-24 13:18:09', null);
INSERT INTO `t_task_status` VALUES ('12', '4', null, '9', '2019-04-25 15:03:42', '100');
INSERT INTO `t_task_status` VALUES ('13', '5', null, '9', null, '11');
INSERT INTO `t_task_status` VALUES ('14', '2', null, '9', null, '100');
INSERT INTO `t_task_status` VALUES ('15', '8', null, '9', null, '12');
INSERT INTO `t_task_status` VALUES ('16', '9', null, '9', null, '100');
INSERT INTO `t_task_status` VALUES ('17', null, '2', '10', null, '10');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '测试教师', '111111', '111111', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work
-- ----------------------------
INSERT INTO `t_work` VALUES ('29', '39', null, '1', 'Joba1bfb958a0b94364bc514e6060f4dc0e.txt', 'D:\\jobReview\\job\\Joba1bfb958a0b94364bc514e6060f4dc0e.txt', null);
INSERT INTO `t_work` VALUES ('30', '40', null, '1', 'Jobb96be878bb5f4bfa83d2cb81db6beb51.txt', 'D:\\jobReview\\job\\Jobb96be878bb5f4bfa83d2cb81db6beb51.txt', null);
INSERT INTO `t_work` VALUES ('31', '33', '13', null, 'Jobdad872046ec141beba01d9a91b52155f.txt', 'D:\\jobReview\\job\\Jobdad872046ec141beba01d9a91b52155f.txt', null);
INSERT INTO `t_work` VALUES ('32', '34', '13', null, 'Job2b515e13e6f043998b8b1e7ef98e34fc.txt', 'D:\\jobReview\\job\\Job2b515e13e6f043998b8b1e7ef98e34fc.txt', null);
INSERT INTO `t_work` VALUES ('33', '47', '13', null, '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job9401a5e26d034223a6f3aa9c18080f42.png');
INSERT INTO `t_work` VALUES ('34', '48', '13', null, '04cbfda4a3824a4281e68f373ab61c67.png.png', null, '/file/job/Jobdee572d50d5b4f14b61d1221a6cc3fc2.png');
INSERT INTO `t_work` VALUES ('35', '49', '13', null, '07ad7aebd1a1445d99b5d40acebce074.jpg.jpg', null, '/file/job/Job428499cecb8b44c2bf3fdf5f70fecb9b.jpg');
INSERT INTO `t_work` VALUES ('36', '43', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job12a78e4a3a7f4660ad8960d71970df3a.png');
INSERT INTO `t_work` VALUES ('37', '44', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job8f3c844ce9b94647bb7116941809e439.png');
INSERT INTO `t_work` VALUES ('38', '45', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Jobdd32fe3d36b9480584ad3e9240f757f1.png');
INSERT INTO `t_work` VALUES ('39', '33', '14', null, 'Job552d1cf62756484a93dd1c43e0180735.txt', 'D:\\jobReview\\job\\Job552d1cf62756484a93dd1c43e0180735.txt', null);
INSERT INTO `t_work` VALUES ('40', '48', '14', null, '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job8f03b2645ad9449d82f4b766752fbb82.png');
INSERT INTO `t_work` VALUES ('41', '51', '13', null, '04cbfda4a3824a4281e68f373ab61c67.png.png', null, '/file/job/Job14c7435b97ec4107ae49494af96a6e3d.png');
INSERT INTO `t_work` VALUES ('42', '33', '4', null, 'Jobeae4b9bf602f4063a6a2aa6cae9aa268.txt', 'D:\\jobReview\\job\\Jobeae4b9bf602f4063a6a2aa6cae9aa268.txt', null);
INSERT INTO `t_work` VALUES ('43', '34', '4', null, 'Job87a97f0e833e43bcadaf08309dd77957.txt', 'D:\\jobReview\\job\\Job87a97f0e833e43bcadaf08309dd77957.txt', null);
INSERT INTO `t_work` VALUES ('44', '35', '4', null, 'Jobcecf7dc338dd4994a8cc4eab9b414ea2.txt', 'D:\\jobReview\\job\\Jobcecf7dc338dd4994a8cc4eab9b414ea2.txt', null);
INSERT INTO `t_work` VALUES ('45', '36', '4', null, 'Job0edd94219b5a4b37bc85de9ee746b815.txt', 'D:\\jobReview\\job\\Job0edd94219b5a4b37bc85de9ee746b815.txt', null);
INSERT INTO `t_work` VALUES ('46', '37', '4', null, 'Job94219e3e997949acbe5930807a8a3a0e.txt', 'D:\\jobReview\\job\\Job94219e3e997949acbe5930807a8a3a0e.txt', null);

-- ----------------------------
-- View structure for `v_class_task_info`
-- ----------------------------
DROP VIEW IF EXISTS `v_class_task_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_class_task_info` AS select `c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`ct`.`ct_id` AS `ct_id`,`ct`.`ct_type` AS `ct_type`,`ct`.`ct_status` AS `ct_status`,`ct`.`ct_semester` AS `ct_semester`,`ct`.`ct_proportion` AS `ct_proportion`,`ct`.`ct_start_time` AS `ct_start_time`,`ct`.`ct_end_time` AS `ct_end_time`,`t`.`task_id` AS `task_id`,`t`.`task_name` AS `task_name`,`t`.`task_type` AS `task_type` from ((`t_class_task` `ct` left join `t_class` `c` on((`c`.`class_id` = `ct`.`class_id`))) left join `t_task` `t` on((`ct`.`task_id` = `t`.`task_id`))) ;

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
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_student_info` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`c`.`class_id` AS `class_id`,`c`.`class_name` AS `class_name`,`c`.`class_semester` AS `class_semester`,`g`.`group_id` AS `group_id`,`g`.`group_num` AS `group_num`,`g`.`group_name` AS `group_name` from ((`t_student` `s` left join `t_class` `c` on((`s`.`class_id` = `c`.`class_id`))) left join `t_group` `g` on((`s`.`group_id` = `g`.`group_id`))) ;

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
