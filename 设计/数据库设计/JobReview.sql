/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jobreview

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-26 21:04:52
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '1', '616322', '1');
INSERT INTO `t_class` VALUES ('2', '1', '测试班级', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_task
-- ----------------------------
INSERT INTO `t_class_task` VALUES ('13', '10', '1', '1', '2', '1', '10', '2019-04-25 21:43:14', '2019-05-11 00:00:00');
INSERT INTO `t_class_task` VALUES ('14', '11', '1', '2', '2', '1', '30', '2019-04-25 21:43:29', '2019-04-27 00:00:00');
INSERT INTO `t_class_task` VALUES ('15', '12', '1', '1', '2', '1', '10', '2019-04-25 21:43:42', '2019-05-04 00:00:00');
INSERT INTO `t_class_task` VALUES ('16', '13', '1', '2', '2', '1', '50', '2019-04-25 21:43:55', '2019-05-04 00:00:00');
INSERT INTO `t_class_task` VALUES ('17', '10', '2', '1', '2', '3', '15', '2019-04-26 20:02:11', '2019-04-26 20:02:12');
INSERT INTO `t_class_task` VALUES ('18', '11', '2', '1', '2', '3', '12', '2019-04-26 20:02:40', '2019-04-26 20:02:42');
INSERT INTO `t_class_task` VALUES ('20', '13', '2', '1', '2', '3', '15', '2019-04-26 20:03:02', '2019-04-26 20:03:03');
INSERT INTO `t_class_task` VALUES ('21', '14', '2', '1', '2', '3', '25', '2019-04-26 20:03:16', '2019-04-26 20:03:17');
INSERT INTO `t_class_task` VALUES ('22', '15', '2', '1', '2', '3', '25', '2019-04-26 20:03:33', '2019-04-26 20:03:35');
INSERT INTO `t_class_task` VALUES ('23', '16', '2', '1', '2', '3', '20', '2019-04-26 20:03:40', '2019-04-26 20:03:41');
INSERT INTO `t_class_task` VALUES ('24', '17', '2', '1', '2', '3', '20', '2019-04-26 20:03:54', '2019-04-26 20:03:55');
INSERT INTO `t_class_task` VALUES ('25', '12', '2', '2', '2', '3', '1', '2019-04-26 20:11:05', '2019-04-26 20:11:06');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('1', '1', null, '第一组', '第一组');
INSERT INTO `t_group` VALUES ('2', '1', null, '第二组', '第二组');
INSERT INTO `t_group` VALUES ('3', '2', '35', '第一组', '第一组');
INSERT INTO `t_group` VALUES ('4', '2', '45', '第二组', '第二组');
INSERT INTO `t_group` VALUES ('5', '2', '52', '第三组', '第三组');

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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('17', '1', '1', '100001', '学生2', '111112', '111112', '3');
INSERT INTO `t_student` VALUES ('18', '1', '1', '100002', '学生3', '111113', '111113', '3');
INSERT INTO `t_student` VALUES ('19', '1', '1', '100003', '学生4', '111114', '111114', '3');
INSERT INTO `t_student` VALUES ('20', '1', '1', '100004', '学生5', '111115', '111115', '3');
INSERT INTO `t_student` VALUES ('21', '1', '2', '100005', '学生6', '111116', '111116', '3');
INSERT INTO `t_student` VALUES ('22', '1', '2', '100006', '学生7', '111117', '111117', '3');
INSERT INTO `t_student` VALUES ('23', '1', '2', '100007', '学生8', '111118', '111118', '3');
INSERT INTO `t_student` VALUES ('24', '1', '2', '100008', '学生9', '111119', '111119', '3');
INSERT INTO `t_student` VALUES ('25', '1', '2', '100009', '学生10', '111120', '111120', '3');
INSERT INTO `t_student` VALUES ('26', '1', '2', '100010', '学生11', '111121', '111121', '3');
INSERT INTO `t_student` VALUES ('27', '1', '2', '100011', '学生12', '111122', '111122', '3');
INSERT INTO `t_student` VALUES ('28', '1', '2', '100013', '学生13', '111123', '111123', '3');
INSERT INTO `t_student` VALUES ('29', '1', '2', '100015', '学生16', '111126', '111126', '3');
INSERT INTO `t_student` VALUES ('30', '1', '2', '100016', '学生17', '111127', '111127', '3');
INSERT INTO `t_student` VALUES ('31', '1', '2', '100017', '学生18', '111128', '111128', '3');
INSERT INTO `t_student` VALUES ('32', '1', null, '100018', '张三', '111129', '111111', '3');
INSERT INTO `t_student` VALUES ('33', '1', null, '999999', '999999', '999999', '9999992', '3');
INSERT INTO `t_student` VALUES ('34', '1', null, '123321', '李四', '222222', '222222', '3');
INSERT INTO `t_student` VALUES ('35', '2', '3', '333333', '学生1', '333333', '333333', '3');
INSERT INTO `t_student` VALUES ('36', '2', '3', '333334', '学生2', '333334', '333334', '3');
INSERT INTO `t_student` VALUES ('37', '2', '3', '333335', '学生3', '333335', '333335', '3');
INSERT INTO `t_student` VALUES ('38', '2', '3', '333336', '学生4', '333336', '333336', '3');
INSERT INTO `t_student` VALUES ('39', '2', '3', '333337', '学生5', '333337', '333337', '3');
INSERT INTO `t_student` VALUES ('40', '2', '3', '333338', '学生6', '333338', '333338', '3');
INSERT INTO `t_student` VALUES ('41', '2', '3', '333339', '学生7', '333339', '333339', '3');
INSERT INTO `t_student` VALUES ('42', '2', '3', '333340', '学生8', '333340', '333340', '3');
INSERT INTO `t_student` VALUES ('43', '2', '3', '333341', '学生9', '333341', '333341', '3');
INSERT INTO `t_student` VALUES ('44', '2', '3', '333342', '学生10', '333342', '333342', '3');
INSERT INTO `t_student` VALUES ('45', '2', '4', '333343', '学生11', '333343', '333343', '3');
INSERT INTO `t_student` VALUES ('46', '2', '4', '333344', '学生12', '333344', '333344', '3');
INSERT INTO `t_student` VALUES ('47', '2', '4', '333345', '学生13', '333345', '333345', '3');
INSERT INTO `t_student` VALUES ('48', '2', '4', '333346', '学生14', '333346', '333346', '3');
INSERT INTO `t_student` VALUES ('49', '2', '4', '333347', '学生15', '333347', '333347', '3');
INSERT INTO `t_student` VALUES ('50', '2', '4', '333348', '学生16', '333348', '333348', '3');
INSERT INTO `t_student` VALUES ('51', '2', '4', '333349', '学生17', '333349', '333349', '3');
INSERT INTO `t_student` VALUES ('52', '2', '5', '333350', '学生18', '333350', '333350', '3');
INSERT INTO `t_student` VALUES ('53', '2', '5', '333351', '学生19', '333351', '333351', '3');
INSERT INTO `t_student` VALUES ('54', '2', '5', '333352', '学生20', '333352', '333352', '3');
INSERT INTO `t_student` VALUES ('55', '2', '5', '333353', '学生21', '333353', '333353', '3');
INSERT INTO `t_student` VALUES ('56', '2', '4', '333354', '学生22', '333354', '333354', '3');
INSERT INTO `t_student` VALUES ('57', '2', '4', '333355', '学生23', '333355', '333355', '3');
INSERT INTO `t_student` VALUES ('58', '2', '4', '333356', '学生24', '333356', '333356', '3');
INSERT INTO `t_student` VALUES ('59', '2', '4', '333357', '学生25', '333357', '333357', '3');
INSERT INTO `t_student` VALUES ('60', '2', '4', '333358', '学生26', '333358', '333358', '3');
INSERT INTO `t_student` VALUES ('61', '2', '4', '333359', '学生27', '333359', '333359', '3');
INSERT INTO `t_student` VALUES ('62', '2', '4', '333360', '学生28', '333360', '333360', '3');
INSERT INTO `t_student` VALUES ('63', '2', '4', '333361', '学生29', '333361', '333361', '3');
INSERT INTO `t_student` VALUES ('64', '2', '4', '333362', '学生30', '333362', '333362', '3');
INSERT INTO `t_student` VALUES ('65', '2', '4', '333363', '学生31', '333363', '333363', '3');
INSERT INTO `t_student` VALUES ('66', '2', '4', '333364', '学生32', '333364', '333364', '3');
INSERT INTO `t_student` VALUES ('67', '2', '5', '333365', '学生33', '333365', '333365', '3');
INSERT INTO `t_student` VALUES ('68', '2', '5', '333366', '学生34', '333366', '333366', '3');
INSERT INTO `t_student` VALUES ('69', '2', '5', '333367', '学生35', '333367', '333367', '3');
INSERT INTO `t_student` VALUES ('70', '2', '5', '333368', '学生36', '333368', '333368', '3');
INSERT INTO `t_student` VALUES ('71', '2', '5', '333369', '学生37', '333369', '333369', '3');
INSERT INTO `t_student` VALUES ('72', '2', '5', '333370', '学生38', '333370', '333370', '3');
INSERT INTO `t_student` VALUES ('73', '2', '5', '333371', '学生39', '333371', '333371', '3');
INSERT INTO `t_student` VALUES ('74', '2', '5', '333372', '学生40', '333372', '333372', '3');
INSERT INTO `t_student` VALUES ('75', '2', '5', '333373', '学生41', '333373', '333373', '3');
INSERT INTO `t_student` VALUES ('76', '2', '5', '333374', '学生42', '333374', '333374', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_subject` VALUES ('55', '14', '任务1');
INSERT INTO `t_subject` VALUES ('56', '15', '任务2');
INSERT INTO `t_subject` VALUES ('57', '16', '任务3');
INSERT INTO `t_subject` VALUES ('58', '17', '23112313');

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
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('10', '1', '测试任务', '1');
INSERT INTO `t_task` VALUES ('11', '1', '测试任务2', '1');
INSERT INTO `t_task` VALUES ('12', '1', '测试oracle任务', '2');
INSERT INTO `t_task` VALUES ('13', '1', '测试oracle2', '2');
INSERT INTO `t_task` VALUES ('14', '1', '任务1', '1');
INSERT INTO `t_task` VALUES ('15', '1', '任务2', '1');
INSERT INTO `t_task` VALUES ('16', '1', '任务3', '1');
INSERT INTO `t_task` VALUES ('17', '1', '12313', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_status
-- ----------------------------
INSERT INTO `t_task_status` VALUES ('19', null, '1', '16', null, '80');
INSERT INTO `t_task_status` VALUES ('20', null, '2', '16', null, '90');
INSERT INTO `t_task_status` VALUES ('21', null, '1', '14', null, '60');
INSERT INTO `t_task_status` VALUES ('22', null, '2', '14', null, '85');
INSERT INTO `t_task_status` VALUES ('23', '34', null, '15', null, '100');
INSERT INTO `t_task_status` VALUES ('24', '29', null, '13', null, '100');
INSERT INTO `t_task_status` VALUES ('25', '23', null, '13', null, '99');
INSERT INTO `t_task_status` VALUES ('26', '31', null, '13', null, '88');
INSERT INTO `t_task_status` VALUES ('27', '76', null, '24', null, '100');
INSERT INTO `t_task_status` VALUES ('28', '75', null, '24', null, '100');

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
INSERT INTO `t_work` VALUES ('36', '43', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job12a78e4a3a7f4660ad8960d71970df3a.png');
INSERT INTO `t_work` VALUES ('37', '44', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Job8f3c844ce9b94647bb7116941809e439.png');
INSERT INTO `t_work` VALUES ('38', '45', null, '1', '4d15bc3ee21e432f98c857a36d4b9d5d.png.png', null, '/file/job/Jobdd32fe3d36b9480584ad3e9240f757f1.png');

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
