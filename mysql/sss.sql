/*
Navicat MySQL Data Transfer

Source Server         : server
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : Demo

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-22 23:39:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `snumber` varchar(255) NOT NULL,
  `phoneNum` char(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `rate` double(16,2) DEFAULT NULL,
  PRIMARY KEY (`snumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `user` VALUES ('adminyiru', '15210229199', '123', '怡如', '男', '3', 'CUFE', 'MIS', '0.0');
INSERT INTO `user` VALUES ('adminyiru2', '15210229199', '123', '怡如', '男', '3', 'CUFE', 'MIS', '0.0');


-- ----------------------------
-- Table structure for `oeders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderNumber` varchar(255) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `Qnumber` varchar(255) DEFAULT NULL,
  `Anumber` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `Qevaluate` varchar(255) DEFAULT NULL,
  `Aevaluate` varchar(255) DEFAULT NULL,
  `Qrate` int(1) DEFAULT NULL,
  `Arate` int(1) DEFAULT NULL,
  `Qreport` varchar(255) DEFAULT NULL,
  `Areport` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderNumber`),
  foreign key(Qnumber) references user(snumber),
  foreign key(Anumber) references user(snumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------


INSERT INTO `orders` VALUES ('297ac948-ca0b-4025-9120-94987c341f62', '考研', '随便', '线上', '互相监督一起学习', 'adminyiru', null, 'waiting','','',null,null,'','');


INSERT INTO `orders` VALUES ('496fe26a-e263-4581-8744-54afea8abcf9', '期末复习', '今天开始', '线上', '一起期末复习', 'adminyiru', 'adminyiru2', 'doing','','',null,null,'','');

INSERT INTO `orders` VALUES ('62fd2835-0176-4f69-b5fa-4287cee61cc3', '期末复习', '今天开始', '线上', '一起期末复习', 'adminyiru', 'adminyiru2', 'done', '不错','不行',5,0,'','偷拍我');