-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.87-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4770
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 attendance_sys 的数据库结构
CREATE DATABASE IF NOT EXISTS `attendance_sys` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `attendance_sys`;


-- 导出  表 attendance_sys.attendance 结构
CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(4) NOT NULL auto_increment,
  `leave` int(1) NOT NULL default '0',
  `truancy` int(1) NOT NULL default '0',
  `late` int(1) NOT NULL default '0',
  `leaveEarly` int(1) NOT NULL default '0',
  `student_id` int(4) NOT NULL,
  `class_id` int(4) default NULL,
  `subject_id` int(4) default NULL,
  `teacher_id` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤表';

-- 正在导出表  attendance_sys.attendance 的数据：~0 rows (大约)
DELETE FROM `attendance`;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


-- 导出  表 attendance_sys.class 结构
CREATE TABLE IF NOT EXISTS `class` (
  `id` int(4) NOT NULL auto_increment,
  `classname` varchar(50) NOT NULL,
  `grade_id` int(4) NOT NULL,
  `major_id` int(4) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_class_major` (`major_id`),
  KEY `FK_class_grade` (`grade_id`),
  CONSTRAINT `FK_class_grade` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  CONSTRAINT `FK_class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级年级表';

-- 正在导出表  attendance_sys.class 的数据：~0 rows (大约)
DELETE FROM `class`;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;


-- 导出  表 attendance_sys.grade 结构
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(4) NOT NULL auto_increment,
  `name` int(4) NOT NULL,
  `des` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级';

-- 正在导出表  attendance_sys.grade 的数据：~0 rows (大约)
DELETE FROM `grade`;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;


-- 导出  表 attendance_sys.juris 结构
CREATE TABLE IF NOT EXISTS `juris` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `des` varchar(100) default 'NULL',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 正在导出表  attendance_sys.juris 的数据：~0 rows (大约)
DELETE FROM `juris`;
/*!40000 ALTER TABLE `juris` DISABLE KEYS */;
/*!40000 ALTER TABLE `juris` ENABLE KEYS */;


-- 导出  表 attendance_sys.major 结构
CREATE TABLE IF NOT EXISTS `major` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `des` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业';

-- 正在导出表  attendance_sys.major 的数据：~0 rows (大约)
DELETE FROM `major`;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
/*!40000 ALTER TABLE `major` ENABLE KEYS */;


-- 导出  表 attendance_sys.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(16) NOT NULL,
  `des` varchar(100) default 'NULL',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  attendance_sys.role 的数据：~0 rows (大约)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- 导出  表 attendance_sys.role_jur 结构
CREATE TABLE IF NOT EXISTS `role_jur` (
  `role_id` int(4) NOT NULL,
  `jur_id` int(4) NOT NULL,
  KEY `FK_role_jur_role` (`role_id`),
  KEY `FK_role_jur_juris` (`jur_id`),
  CONSTRAINT `FK_role_jur_juris` FOREIGN KEY (`jur_id`) REFERENCES `juris` (`id`),
  CONSTRAINT `FK_role_jur_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- 正在导出表  attendance_sys.role_jur 的数据：~0 rows (大约)
DELETE FROM `role_jur`;
/*!40000 ALTER TABLE `role_jur` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_jur` ENABLE KEYS */;


-- 导出  表 attendance_sys.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(4) NOT NULL auto_increment,
  `username` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL default '000000',
  `role_id` int(4) NOT NULL,
  `class_id` int(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK_student_role` (`role_id`),
  CONSTRAINT `FK_student_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- 正在导出表  attendance_sys.student 的数据：~0 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- 导出  表 attendance_sys.subject 结构
CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `des` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目表';

-- 正在导出表  attendance_sys.subject 的数据：~0 rows (大约)
DELETE FROM `subject`;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;


-- 导出  表 attendance_sys.sub_class 结构
CREATE TABLE IF NOT EXISTS `sub_class` (
  `subject_id` int(4) NOT NULL,
  `class_id` int(4) NOT NULL,
  KEY `FK_sub_class_subject` (`subject_id`),
  KEY `FK_sub_class_class` (`class_id`),
  CONSTRAINT `FK_sub_class_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`),
  CONSTRAINT `FK_sub_class_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目与班级中间表';

-- 正在导出表  attendance_sys.sub_class 的数据：~0 rows (大约)
DELETE FROM `sub_class`;
/*!40000 ALTER TABLE `sub_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_class` ENABLE KEYS */;


-- 导出  表 attendance_sys.teacher 结构
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(4) NOT NULL auto_increment,
  `username` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL default '000000',
  `role_id` int(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `FK_teacher_role` (`role_id`),
  CONSTRAINT `FK_teacher_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教工表';

-- 正在导出表  attendance_sys.teacher 的数据：~0 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;


-- 导出  表 attendance_sys.teacher_sub 结构
CREATE TABLE IF NOT EXISTS `teacher_sub` (
  `teacher_id` int(4) NOT NULL,
  `subject_id` int(4) NOT NULL,
  KEY `FK__teacher` (`teacher_id`),
  KEY `FK__subject` (`subject_id`),
  CONSTRAINT `FK__subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK__teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教工和科目中间表';

-- 正在导出表  attendance_sys.teacher_sub 的数据：~0 rows (大约)
DELETE FROM `teacher_sub`;
/*!40000 ALTER TABLE `teacher_sub` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_sub` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
