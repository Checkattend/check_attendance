/*
Navicat MySQL Data Transfer

Source Server         : co
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : attendance_sys

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2014-08-16 16:22:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `leave` int(1) NOT NULL DEFAULT '0',
  `truancy` int(1) NOT NULL DEFAULT '0',
  `late` int(1) NOT NULL DEFAULT '0',
  `leaveEarly` int(1) NOT NULL DEFAULT '0',
  `student_id` int(4) NOT NULL,
  `class_id` int(4) DEFAULT NULL,
  `subject_id` int(4) DEFAULT NULL,
  `teacher_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤表';

-- ----------------------------
-- Records of attendance
-- ----------------------------

-- ----------------------------
-- Table structure for `clas`
-- ----------------------------
DROP TABLE IF EXISTS `clas`;
CREATE TABLE `clas` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `classname` varchar(50) NOT NULL,
  `grade_id` int(4) NOT NULL,
  `major_id` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_class_major` (`major_id`),
  KEY `FK_class_grade` (`grade_id`),
  CONSTRAINT `FK_class_grade` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  CONSTRAINT `FK_class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级年级表';

-- ----------------------------
-- Records of clas
-- ----------------------------

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `gradename` int(4) NOT NULL,
  `des` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级';

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for `juris`
-- ----------------------------
DROP TABLE IF EXISTS `juris`;
CREATE TABLE `juris` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `jurisname` varchar(20) NOT NULL,
  `des` varchar(100) DEFAULT 'NULL',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`jurisname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of juris
-- ----------------------------

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `majorname` varchar(50) NOT NULL,
  `des` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业';

-- ----------------------------
-- Records of major
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) NOT NULL,
  `des` varchar(100) DEFAULT 'NULL',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_jur`
-- ----------------------------
DROP TABLE IF EXISTS `role_jur`;
CREATE TABLE `role_jur` (
  `role_id` int(4) NOT NULL,
  `jur_id` int(4) NOT NULL,
  KEY `FK_role_jur_role` (`role_id`),
  KEY `FK_role_jur_juris` (`jur_id`),
  CONSTRAINT `FK_role_jur_juris` FOREIGN KEY (`jur_id`) REFERENCES `juris` (`id`),
  CONSTRAINT `FK_role_jur_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of role_jur
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL DEFAULT '000000',
  `role_id` int(4) NOT NULL,
  `class_id` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK_student_role` (`role_id`),
  KEY `FK_student_class` (`class_id`),
  CONSTRAINT `FK_student_class` FOREIGN KEY (`class_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `FK_student_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `subjectname` varchar(50) NOT NULL,
  `des` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目表';

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for `sub_class`
-- ----------------------------
DROP TABLE IF EXISTS `sub_class`;
CREATE TABLE `sub_class` (
  `subject_id` int(4) NOT NULL,
  `class_id` int(4) NOT NULL,
  KEY `FK_sub_class_subject` (`subject_id`),
  KEY `FK_sub_class_class` (`class_id`),
  CONSTRAINT `FK_sub_class_class` FOREIGN KEY (`class_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `FK_sub_class_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目与班级中间表';

-- ----------------------------
-- Records of sub_class
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL DEFAULT '000000',
  `role_id` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK_teacher_role` (`role_id`),
  CONSTRAINT `FK_teacher_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教工表';

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher_sub`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_sub`;
CREATE TABLE `teacher_sub` (
  `teacher_id` int(4) NOT NULL,
  `subject_id` int(4) NOT NULL,
  KEY `FK__teacher` (`teacher_id`),
  KEY `FK__subject` (`subject_id`),
  CONSTRAINT `FK__subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK__teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教工和科目中间表';

-- ----------------------------
-- Records of teacher_sub
-- ----------------------------
