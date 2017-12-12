/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : gds

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-12-12 17:52:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gds_club
-- ----------------------------
DROP TABLE IF EXISTS `gds_club`;
CREATE TABLE `gds_club` (
  `club_id` int(10) NOT NULL AUTO_INCREMENT,
  `club_name` varchar(255) DEFAULT NULL COMMENT '社团名称',
  `club_type` varchar(255) DEFAULT NULL COMMENT '社团类型',
  `club_faculty` varchar(255) DEFAULT NULL COMMENT '所属学院',
  `club_createtime` varchar(255) DEFAULT NULL COMMENT '成立时间',
  `club_status` int(1) DEFAULT '0',
  `club_introduce` varchar(9999) DEFAULT NULL COMMENT '社团简介',
  `club_standby001` varchar(255) DEFAULT NULL COMMENT '预留字段001',
  `club_standby002` varchar(255) DEFAULT NULL COMMENT '预留字段002',
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gds_club
-- ----------------------------
INSERT INTO `gds_club` VALUES ('1', 'IT社团', null, '计算机学院', null, '0', null, null, null);
INSERT INTO `gds_club` VALUES ('2', '爱心公益社团', null, '外国语学院', null, '0', null, null, null);

-- ----------------------------
-- Table structure for gds_dict
-- ----------------------------
DROP TABLE IF EXISTS `gds_dict`;
CREATE TABLE `gds_dict` (
  `dict_id` int(4) NOT NULL AUTO_INCREMENT,
  `key_id` varchar(10) DEFAULT NULL,
  `key` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gds_dict
-- ----------------------------
INSERT INTO `gds_dict` VALUES ('1', '001', '社团类型', '艺术');
INSERT INTO `gds_dict` VALUES ('2', '001', '社团类型', '公益');
INSERT INTO `gds_dict` VALUES ('3', '001', '社团类型', '体育');
INSERT INTO `gds_dict` VALUES ('4', '002', '学院名称', '计算机学院');
INSERT INTO `gds_dict` VALUES ('5', '002', '学院名称', '艺术学院');
INSERT INTO `gds_dict` VALUES ('6', '002', '学院名称', '数学与经济学院');
INSERT INTO `gds_dict` VALUES ('7', '002', '学院名称', '体育学院');

-- ----------------------------
-- Table structure for gds_student
-- ----------------------------
DROP TABLE IF EXISTS `gds_student`;
CREATE TABLE `gds_student` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(32) DEFAULT NULL COMMENT '学号',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `register_time` varchar(50) DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '注册IP',
  `last_login_time` varchar(50) DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '最后登录IP',
  `wx_number` varchar(32) DEFAULT NULL COMMENT '微信',
  `mobile` varchar(32) DEFAULT NULL,
  `standby001` varchar(50) DEFAULT NULL COMMENT '学院',
  `standby002` varchar(50) DEFAULT NULL COMMENT '备用字段002',
  `login_count` int(11) DEFAULT '0' COMMENT '登录次数',
  `rank` int(1) DEFAULT '0' COMMENT '管理员级别',
  `is_admin` int(1) DEFAULT '0' COMMENT '是否管理员',
  `is_disabled` int(1) DEFAULT '0' COMMENT '是否禁用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='学生表\r\n';

-- ----------------------------
-- Records of gds_student
-- ----------------------------
INSERT INTO `gds_student` VALUES ('1', '666666666', '超级大BOSS', '123456', 'admin', '513598006@qq.com', '2017-11-30 11:39:10', '127.0.0.1', null, '127.0.0.1', 'zxc', '123456', '计算机学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('2', '123213698', '张三', '31241', 'zxc', '1234@qq.com', '2017-12-01 11:39:10', '127.0.0.1', null, '127.0.0.1', 'wewsd', '123456', '外国语学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('3', '123782136', '张三丰', '666', 'zxxxxc', '123asd4@qq.com', '2017-05-30 11:39:10', '127.0.0.1', null, '127.0.0.1', 'qaq', '4534534', '计算机学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('4', '123213986', '老王', '322323', 'wangwu', '12ewqe34@qq.com', '2017-01-30 11:39:10', '127.0.0.1', null, '127.0.0.1', '909232', '122343456', '艺术学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('5', '123452136', '李白', 'sdfsdf', 'lisi', '1234wer@qq.com', null, '127.0.0.1', null, '127.0.0.1', '7777777777', '345', '艺术学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('6', '123265136', '赵晓晓', '123123', 'zhaoliu', '12sdfs34@qq.com', null, '127.0.0.1', null, '127.0.0.1', 'future', '123234456', '计算机学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('7', '123342136', '鲁班', 'hhhe', 'asf', '123wqeqwgfd4@qq.com', null, '127.0.0.1', null, '127.0.0.1', 'hhha', '231', '艺术学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('8', '54654745', 'jery', '999', 'zwerwerxc', '1234@qq.com', null, '127.0.0.1', null, '127.0.0.1', 'xixixi', '1234412356', '计算机学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('9', '1223232136', 'tom', '6666', 'zxdfgfdc', '123asdasd4@qq.com', '2017-11-30 11:39:10', '127.0.0.1', null, '127.0.0.1', '89bwye2', '1234325', '外国语学院', null, '0', '0', '0', '0');
INSERT INTO `gds_student` VALUES ('10', '4443453643', '张小三', 'sdfsdfsd', 'zhangxiaosan12', 'zhangxiaosan@163.com', null, null, null, null, null, '234234', '外国语学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('11', '32427856734', '李小四', '123456', 'lixiaosi', 'lixiaosi@163.com', null, null, null, null, null, '2348732', '艺术学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('12', '9876543555', '王小五', '2143214', 'future2', 'wangxiaowu@qq.com', null, null, null, null, null, '12312412', '体育学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('14', '1734782', '笑笑', 'xiaoixao1', 'xiaoxiao1', '7774@163.com', null, null, null, null, null, '666', '计算机学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('15', '1776782', '笑笑', 'xiaoixao2', 'xiaoxiao2', '', null, null, null, null, null, '666', '计算机学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('16', '1734634782', '笑笑', 'xiaoixao3', 'xiaoxiaoxiao3', '777@163.com', null, null, null, null, null, '666', '计算机学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('17', '145678723', '超人', 'superman1', 'superman', '555@111.com', null, null, null, null, null, '158222222222', '艺术学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('18', '15283676432', '超人', 'superman2', 'superman', '123@321.com', null, null, null, null, null, '123321', '计算机学院', null, null, null, null, null);
INSERT INTO `gds_student` VALUES ('19', '299388477', '王小晨', 'wangdeng', 'wangdeng', 'wangxiaodeng@qq.com', '2017-12-12 10:33:59', null, null, null, null, '909898787', '计算机学院', null, null, null, null, null);

-- ----------------------------
-- Table structure for gds_stu_relation
-- ----------------------------
DROP TABLE IF EXISTS `gds_stu_relation`;
CREATE TABLE `gds_stu_relation` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(20) DEFAULT NULL COMMENT '学生id',
  `dict_club_id` int(10) DEFAULT NULL COMMENT '所属社团id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gds_stu_relation
-- ----------------------------
INSERT INTO `gds_stu_relation` VALUES ('1', '1652323723', '1');
INSERT INTO `gds_stu_relation` VALUES ('2', '299388477', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `sex` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'user', '123', '男');
