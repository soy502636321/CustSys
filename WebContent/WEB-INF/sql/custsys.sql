/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : custsys

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2013-08-08 18:53:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `base_class`
-- ----------------------------
DROP TABLE IF EXISTS `base_class`;
CREATE TABLE `base_class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '业务种类：基础表',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_class
-- ----------------------------
INSERT INTO `base_class` VALUES ('1', '种类-1', '');

-- ----------------------------
-- Table structure for `base_delivery`
-- ----------------------------
DROP TABLE IF EXISTS `base_delivery`;
CREATE TABLE `base_delivery` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DELIVERY_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '交付方式：基础表',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_delivery
-- ----------------------------
INSERT INTO `base_delivery` VALUES ('1', '交付-1', '');

-- ----------------------------
-- Table structure for `base_industry`
-- ----------------------------
DROP TABLE IF EXISTS `base_industry`;
CREATE TABLE `base_industry` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户行业：基础表',
  `INDUSTRY_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_industry
-- ----------------------------
INSERT INTO `base_industry` VALUES ('1', '行业-1', '');

-- ----------------------------
-- Table structure for `base_main`
-- ----------------------------
DROP TABLE IF EXISTS `base_main`;
CREATE TABLE `base_main` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAIN_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_main
-- ----------------------------
INSERT INTO `base_main` VALUES ('1', '主营-1', '');

-- ----------------------------
-- Table structure for `base_maintaintype`
-- ----------------------------
DROP TABLE IF EXISTS `base_maintaintype`;
CREATE TABLE `base_maintaintype` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAINTAINTYPE_NAME` varchar(100) DEFAULT NULL COMMENT '维护类型：基础表',
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_maintaintype
-- ----------------------------
INSERT INTO `base_maintaintype` VALUES ('1', '维护-1', '');

-- ----------------------------
-- Table structure for `base_payment`
-- ----------------------------
DROP TABLE IF EXISTS `base_payment`;
CREATE TABLE `base_payment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PAYMENT_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '支付方式：基础表',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_payment
-- ----------------------------
INSERT INTO `base_payment` VALUES ('1', '支付-1', '');

-- ----------------------------
-- Table structure for `base_production`
-- ----------------------------
DROP TABLE IF EXISTS `base_production`;
CREATE TABLE `base_production` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_production
-- ----------------------------
INSERT INTO `base_production` VALUES ('1', '生产人', '备注：生产人');
INSERT INTO `base_production` VALUES ('2', '检查人', '备注：检查人');
INSERT INTO `base_production` VALUES ('3', '鉴定人', '备注：鉴定人');

-- ----------------------------
-- Table structure for `base_quality`
-- ----------------------------
DROP TABLE IF EXISTS `base_quality`;
CREATE TABLE `base_quality` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUALITY_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '业务品质：基础表',
  PRIMARY KEY (`ID`),
  KEY `FK4C070D913414C29F` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_quality
-- ----------------------------
INSERT INTO `base_quality` VALUES ('1', '品质-1', '');

-- ----------------------------
-- Table structure for `base_source`
-- ----------------------------
DROP TABLE IF EXISTS `base_source`;
CREATE TABLE `base_source` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户来源：基础表',
  `SOURCE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_source
-- ----------------------------
INSERT INTO `base_source` VALUES ('1', '来源-1', '');

-- ----------------------------
-- Table structure for `base_state`
-- ----------------------------
DROP TABLE IF EXISTS `base_state`;
CREATE TABLE `base_state` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户状态：基础表',
  `STATE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_state
-- ----------------------------
INSERT INTO `base_state` VALUES ('1', '状态-1', '');

-- ----------------------------
-- Table structure for `base_type`
-- ----------------------------
DROP TABLE IF EXISTS `base_type`;
CREATE TABLE `base_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户类型：基础表',
  `TYPE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_type
-- ----------------------------
INSERT INTO `base_type` VALUES ('1', '类型-1', '');

-- ----------------------------
-- Table structure for `business_class`
-- ----------------------------
DROP TABLE IF EXISTS `business_class`;
CREATE TABLE `business_class` (
  `BUSINESS_ID` int(11) NOT NULL,
  `CLASS_ID` int(11) NOT NULL,
  PRIMARY KEY (`BUSINESS_ID`,`CLASS_ID`),
  KEY `FK8B47FC39372FFC00` (`CLASS_ID`),
  KEY `FK8B47FC397D1C4F7E` (`BUSINESS_ID`),
  CONSTRAINT `FK8B47FC39372FFC00` FOREIGN KEY (`CLASS_ID`) REFERENCES `base_class` (`ID`),
  CONSTRAINT `FK8B47FC397D1C4F7E` FOREIGN KEY (`BUSINESS_ID`) REFERENCES `sys_business` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_class
-- ----------------------------
INSERT INTO `business_class` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `business_quality`
-- ----------------------------
DROP TABLE IF EXISTS `business_quality`;
CREATE TABLE `business_quality` (
  `BUSINESS_ID` int(11) NOT NULL,
  `QUALITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`BUSINESS_ID`,`QUALITY_ID`),
  KEY `FKCD2967807D1C4F7E` (`BUSINESS_ID`),
  KEY `FKCD2967802F4FC120` (`QUALITY_ID`),
  CONSTRAINT `FKCD2967802F4FC120` FOREIGN KEY (`QUALITY_ID`) REFERENCES `base_quality` (`ID`),
  CONSTRAINT `FKCD2967807D1C4F7E` FOREIGN KEY (`BUSINESS_ID`) REFERENCES `sys_business` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_quality
-- ----------------------------
INSERT INTO `business_quality` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `role_function`
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `ROLE_ID` int(11) DEFAULT NULL,
  `FUNCTION_ID` int(11) DEFAULT NULL,
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `FUNCTION_ID` (`FUNCTION_ID`),
  CONSTRAINT `role_function_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `role_function_ibfk_2` FOREIGN KEY (`FUNCTION_ID`) REFERENCES `sys_function` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('2', '13');
INSERT INTO `role_function` VALUES ('2', '15');
INSERT INTO `role_function` VALUES ('2', '17');
INSERT INTO `role_function` VALUES ('2', '14');
INSERT INTO `role_function` VALUES ('2', '16');
INSERT INTO `role_function` VALUES ('2', '18');
INSERT INTO `role_function` VALUES ('2', '84');
INSERT INTO `role_function` VALUES ('2', '85');
INSERT INTO `role_function` VALUES ('2', '60');
INSERT INTO `role_function` VALUES ('2', '61');
INSERT INTO `role_function` VALUES ('2', '62');
INSERT INTO `role_function` VALUES ('2', '63');
INSERT INTO `role_function` VALUES ('2', '64');
INSERT INTO `role_function` VALUES ('2', '65');
INSERT INTO `role_function` VALUES ('2', '66');
INSERT INTO `role_function` VALUES ('2', '67');
INSERT INTO `role_function` VALUES ('2', '68');
INSERT INTO `role_function` VALUES ('2', '69');
INSERT INTO `role_function` VALUES ('2', '70');
INSERT INTO `role_function` VALUES ('2', '86');
INSERT INTO `role_function` VALUES ('2', '87');
INSERT INTO `role_function` VALUES ('2', '88');
INSERT INTO `role_function` VALUES ('2', '72');
INSERT INTO `role_function` VALUES ('2', '73');
INSERT INTO `role_function` VALUES ('2', '74');
INSERT INTO `role_function` VALUES ('2', '75');
INSERT INTO `role_function` VALUES ('2', '76');
INSERT INTO `role_function` VALUES ('2', '77');
INSERT INTO `role_function` VALUES ('3', '13');
INSERT INTO `role_function` VALUES ('3', '15');
INSERT INTO `role_function` VALUES ('3', '17');
INSERT INTO `role_function` VALUES ('3', '14');
INSERT INTO `role_function` VALUES ('3', '16');
INSERT INTO `role_function` VALUES ('3', '18');
INSERT INTO `role_function` VALUES ('3', '60');
INSERT INTO `role_function` VALUES ('3', '61');
INSERT INTO `role_function` VALUES ('3', '62');
INSERT INTO `role_function` VALUES ('3', '63');
INSERT INTO `role_function` VALUES ('3', '64');
INSERT INTO `role_function` VALUES ('3', '65');
INSERT INTO `role_function` VALUES ('3', '67');
INSERT INTO `role_function` VALUES ('3', '68');
INSERT INTO `role_function` VALUES ('3', '81');
INSERT INTO `role_function` VALUES ('3', '69');
INSERT INTO `role_function` VALUES ('3', '82');
INSERT INTO `role_function` VALUES ('3', '94');
INSERT INTO `role_function` VALUES ('3', '75');
INSERT INTO `role_function` VALUES ('3', '77');
INSERT INTO `role_function` VALUES ('3', '78');
INSERT INTO `role_function` VALUES ('3', '80');

-- ----------------------------
-- Table structure for `supplier_classes`
-- ----------------------------
DROP TABLE IF EXISTS `supplier_classes`;
CREATE TABLE `supplier_classes` (
  `SUPPLIER_ID` int(11) NOT NULL,
  `CLASS_ID` int(11) NOT NULL,
  PRIMARY KEY (`SUPPLIER_ID`,`CLASS_ID`),
  KEY `FK7CC4CB3372FFC00` (`CLASS_ID`),
  KEY `FK7CC4CB3F81F83FE` (`SUPPLIER_ID`),
  CONSTRAINT `FK7CC4CB3372FFC00` FOREIGN KEY (`CLASS_ID`) REFERENCES `base_class` (`ID`),
  CONSTRAINT `FK7CC4CB3F81F83FE` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `sys_supplier` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier_classes
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier_qualities`
-- ----------------------------
DROP TABLE IF EXISTS `supplier_qualities`;
CREATE TABLE `supplier_qualities` (
  `SUPPLIER` int(11) NOT NULL,
  `QUALITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`SUPPLIER`,`QUALITY_ID`),
  KEY `FKFC1C732A2F4FC120` (`QUALITY_ID`),
  KEY `FKFC1C732AB227E95C` (`SUPPLIER`),
  CONSTRAINT `FKFC1C732A2F4FC120` FOREIGN KEY (`QUALITY_ID`) REFERENCES `base_quality` (`ID`),
  CONSTRAINT `FKFC1C732AB227E95C` FOREIGN KEY (`SUPPLIER`) REFERENCES `sys_supplier` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier_qualities
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_business`
-- ----------------------------
DROP TABLE IF EXISTS `sys_business`;
CREATE TABLE `sys_business` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUST_ID` int(11) DEFAULT NULL,
  `BUSINESS_NO` varchar(100) NOT NULL,
  `CONTRACT_NO` varchar(500) DEFAULT NULL,
  `THEME` varchar(500) DEFAULT NULL,
  `BUSINESS_TIME` datetime DEFAULT NULL,
  `DELIVERY_TIME` datetime DEFAULT NULL,
  `QUANTITY` double DEFAULT NULL,
  `UNITPRICE` double DEFAULT NULL,
  `ESTIMATED_AMOUNT` double DEFAULT NULL,
  `ACTUAL_AMOUNT` double DEFAULT NULL,
  `PAYMENT_ID` int(11) DEFAULT NULL,
  `INVOICE` varchar(10) DEFAULT NULL,
  `DELIVERY_ID` int(10) DEFAULT NULL,
  `COMPLAINTS` varchar(10) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CLAIM` text,
  `OPERATE_TIME` date DEFAULT NULL,
  `CORRESPONDS_PRICE` double DEFAULT NULL,
  `PAGE_NUMBER` double DEFAULT NULL,
  `DUTY` double DEFAULT NULL,
  `CASH_BACK` double DEFAULT NULL,
  `RAW_MATERIALS` varchar(500) DEFAULT NULL,
  `PRODUCT_TYPE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUST_ID` (`CUST_ID`),
  KEY `PAYMENT_ID` (`PAYMENT_ID`),
  KEY `DELIVERY_ID` (`DELIVERY_ID`),
  KEY `FK52ED88F221509234` (`DELIVERY_ID`),
  KEY `FK52ED88F23AD14FC0` (`PAYMENT_ID`),
  KEY `FK52ED88F268A2E49E` (`CUST_ID`),
  CONSTRAINT `FK52ED88F221509234` FOREIGN KEY (`DELIVERY_ID`) REFERENCES `base_delivery` (`ID`),
  CONSTRAINT `FK52ED88F23AD14FC0` FOREIGN KEY (`PAYMENT_ID`) REFERENCES `base_payment` (`ID`),
  CONSTRAINT `FK52ED88F268A2E49E` FOREIGN KEY (`CUST_ID`) REFERENCES `sys_cust` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_business
-- ----------------------------
INSERT INTO `sys_business` VALUES ('1', '1', '201308080001', '2323232323', '', '2013-08-01 00:00:00', '2013-08-06 00:00:00', '23', '23', '2', null, '1', '', null, '', '', null, '2013-08-08', '2', '2', '2', '2', '', '');

-- ----------------------------
-- Table structure for `sys_contact`
-- ----------------------------
DROP TABLE IF EXISTS `sys_contact`;
CREATE TABLE `sys_contact` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUST_ID` int(11) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `POSITION` varchar(100) DEFAULT NULL,
  `MOBILE` varchar(100) DEFAULT NULL,
  `OFFICE` varchar(100) DEFAULT NULL,
  `FAMILTY` varchar(100) DEFAULT NULL,
  `QQ` varchar(100) DEFAULT NULL,
  `MSN` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `FAX` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(300) DEFAULT NULL,
  `INTERESTS` varchar(500) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `WEIBO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUST_ID` (`CUST_ID`),
  CONSTRAINT `sys_contact_ibfk_1` FOREIGN KEY (`CUST_ID`) REFERENCES `sys_cust` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_cust`
-- ----------------------------
DROP TABLE IF EXISTS `sys_cust`;
CREATE TABLE `sys_cust` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `POSTAL_CODE` varchar(100) DEFAULT NULL,
  `INDUSTRY_ID` int(11) DEFAULT NULL,
  `TYPE_ID` int(11) DEFAULT NULL,
  `SOURCE_ID` int(11) DEFAULT NULL,
  `STATE_ID` int(11) DEFAULT NULL,
  `WEBSITE` varchar(500) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `FEATURE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `INDUSTRY_ID` (`INDUSTRY_ID`),
  KEY `TYPE_ID` (`TYPE_ID`),
  KEY `SOURCE_ID` (`SOURCE_ID`),
  KEY `STATE_ID` (`STATE_ID`),
  CONSTRAINT `sys_cust_ibfk_1` FOREIGN KEY (`INDUSTRY_ID`) REFERENCES `base_industry` (`ID`),
  CONSTRAINT `sys_cust_ibfk_2` FOREIGN KEY (`TYPE_ID`) REFERENCES `base_type` (`ID`),
  CONSTRAINT `sys_cust_ibfk_3` FOREIGN KEY (`SOURCE_ID`) REFERENCES `base_source` (`ID`),
  CONSTRAINT `sys_cust_ibfk_4` FOREIGN KEY (`STATE_ID`) REFERENCES `base_state` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_cust
-- ----------------------------
INSERT INTO `sys_cust` VALUES ('1', '客户-1', '', '', '1', '1', '1', '1', '', '', null);

-- ----------------------------
-- Table structure for `sys_function`
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FUNCTION_NAME` varchar(100) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `FUNCTION_URL` varchar(500) DEFAULT NULL,
  `FUNCTION_TYPE` varchar(10) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PARENT_ID` (`PARENT_ID`),
  CONSTRAINT `sys_function_ibfk_1` FOREIGN KEY (`PARENT_ID`) REFERENCES `sys_function` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('13', '客户管理', null, null, '01', '客户管理');
INSERT INTO `sys_function` VALUES ('14', '客户管理', '13', '/sysCust/sysCustAction!query', '01', '客户管理》客户管理');
INSERT INTO `sys_function` VALUES ('15', '业务管理', null, null, '01', '业务管理');
INSERT INTO `sys_function` VALUES ('16', '业务管理', '15', '/sysBusiness/sysBusinessAction!query', '01', '业务管理》业务管理');
INSERT INTO `sys_function` VALUES ('17', '维护管理', null, null, '01', '维护管理');
INSERT INTO `sys_function` VALUES ('18', '维护管理', '17', '/sysMaintain/sysMaintainAction!query', '01', '维护管理》维护管理');
INSERT INTO `sys_function` VALUES ('20', '客户行业', '9000', '/system/baseIndustryAction!query', '01', '系统管理》客户行业');
INSERT INTO `sys_function` VALUES ('21', '客户类型', '9000', '/system/baseTypeAction!query', '01', '系统管理》客户类型');
INSERT INTO `sys_function` VALUES ('22', '客户来源', '9000', '/system/baseSourceAction!query', '01', '系统管理》客户来源');
INSERT INTO `sys_function` VALUES ('23', '客户状态', '9000', '/system/baseStateAction!query', '01', '系统管理》客户状态');
INSERT INTO `sys_function` VALUES ('24', '交付方式', '9000', '/system/baseDeliveryAction!query', '01', '系统管理》交付方式');
INSERT INTO `sys_function` VALUES ('25', '业务品质', '9000', '/system/baseQualityAction!query', '01', '系统管理》业务品质');
INSERT INTO `sys_function` VALUES ('26', '业务种类', '9000', '/system/baseClassAction!query', '01', '系统管理》业务种类');
INSERT INTO `sys_function` VALUES ('27', '支付方式', '9000', '/system/basePaymentAction!query', '01', '系统管理》支付方式');
INSERT INTO `sys_function` VALUES ('28', '维护类型', '9000', '/system/baseMaintaintypeAction!query', '01', '系统管理》维护类型');
INSERT INTO `sys_function` VALUES ('29', '增  加', '26', 'baseClassAction!add', '02', '系统管理》业务种类》增加');
INSERT INTO `sys_function` VALUES ('30', '修  改', '26', 'baseClassAction!edit', '02', '系统管理》业务种类》修改');
INSERT INTO `sys_function` VALUES ('31', '删  除', '26', 'baseClassAction!delete', '02', '系统管理》业务种类》删除');
INSERT INTO `sys_function` VALUES ('32', '增  加', '24', 'baseDeliveryAction!add', '02', '系统管理》交付方式》增加');
INSERT INTO `sys_function` VALUES ('33', '修  改', '24', 'baseDeliveryAction!edit', '02', '系统管理》交付方式》修改');
INSERT INTO `sys_function` VALUES ('34', '删  除', '24', 'baseDeliveryAction!delete', '02', '系统管理》交付方式》删除');
INSERT INTO `sys_function` VALUES ('35', '增  加', '20', 'baseIndustryAction!add', '02', '系统管理》客户行业》增加');
INSERT INTO `sys_function` VALUES ('36', '修  改', '20', 'baseIndustryAction!edit', '02', '系统管理》客户行业》修改');
INSERT INTO `sys_function` VALUES ('37', '删  除', '20', 'baseIndustryAction!delete', '02', '系统管理》客户行业》删除');
INSERT INTO `sys_function` VALUES ('38', '增  加', '28', 'baseMaintaintypeAction!add', '02', '系统管理》维护类型》增加');
INSERT INTO `sys_function` VALUES ('39', '修  改', '28', 'baseMaintaintypeAction!edit', '02', '系统管理》维护类型》修改');
INSERT INTO `sys_function` VALUES ('40', '删  除', '28', 'baseMaintaintypeAction!delete', '02', '系统管理》维护类型》删除');
INSERT INTO `sys_function` VALUES ('41', '增  加', '27', 'basePaymentAction!add', '02', '系统管理》支付方式》增加');
INSERT INTO `sys_function` VALUES ('42', '修  改', '27', 'basePaymentAction!edit', '02', '系统管理》支付方式》修改');
INSERT INTO `sys_function` VALUES ('43', '删  除', '27', 'basePaymentAction!delete', '02', '系统管理》支付方式》删除');
INSERT INTO `sys_function` VALUES ('44', '增  加', '25', 'baseQualityAction!add', '02', '系统管理》业务品质》增加');
INSERT INTO `sys_function` VALUES ('45', '修  改', '25', 'baseQualityAction!edit', '02', '系统管理》业务品质》修改');
INSERT INTO `sys_function` VALUES ('46', '删  除', '25', 'baseQualityAction!delete', '02', '系统管理》业务品质》删除');
INSERT INTO `sys_function` VALUES ('47', '增  加', '22', 'baseSourceAction!add', '02', '系统管理》客户来源》增加');
INSERT INTO `sys_function` VALUES ('48', '修  改', '22', 'baseSourceAction!edit', '02', '系统管理》客户来源》修改');
INSERT INTO `sys_function` VALUES ('49', '删  除', '22', 'baseSourceAction!delete', '02', '系统管理》客户来源》删除');
INSERT INTO `sys_function` VALUES ('50', '增  加', '23', 'baseStateAction!add', '02', '系统管理》客户状态》增加');
INSERT INTO `sys_function` VALUES ('51', '修  改', '23', 'baseStateAction!edit', '02', '系统管理》客户状态》修改');
INSERT INTO `sys_function` VALUES ('52', '删  除', '23', 'baseStateAction!delete', '02', '系统管理》客户管理》删除');
INSERT INTO `sys_function` VALUES ('53', '增  加', '21', 'baseTypeAction!add', '02', '系统管理》客户类型》增加');
INSERT INTO `sys_function` VALUES ('54', '修  改', '21', 'baseTypeAction!edit', '02', '系统管理》客户类型》修改');
INSERT INTO `sys_function` VALUES ('55', '删  除', '21', 'baseTypeAction!delete', '02', '系统管理》客户类型》删除');
INSERT INTO `sys_function` VALUES ('56', '用户管理', '9000', '/system/sysUserAction!query', '01', '系统管理》用户管理');
INSERT INTO `sys_function` VALUES ('57', '增  加', '56', 'sysUserAction!add', '02', '系统管理》用户管理》增加');
INSERT INTO `sys_function` VALUES ('58', '修  改', '56', 'sysUserAction!edit', '02', '系统管理》用户管理》修改');
INSERT INTO `sys_function` VALUES ('59', '删  除', '56', 'sysUserAction!delete', '02', '系统管理》用户管理》删除');
INSERT INTO `sys_function` VALUES ('60', '添加客户', '14', 'sysCustAction!add', '02', '客户管理》客户管理》添加客户');
INSERT INTO `sys_function` VALUES ('61', '联系方式', '14', 'sysCustAction!contactQuery', '02', '客户管理》客户管理》联系方式');
INSERT INTO `sys_function` VALUES ('62', '维护记录', '14', 'sysCustAction!maintainQuery', '02', '客户管理》客户管理》维护记录');
INSERT INTO `sys_function` VALUES ('63', '业务管理', '14', 'sysCustAction!businessQuery', '02', '客户管理》客户管理》业务管理');
INSERT INTO `sys_function` VALUES ('64', '客户特点', '14', 'sysCustAction!feature', '02', '客户管理》客户管理》客户特点');
INSERT INTO `sys_function` VALUES ('65', '添加订单', '16', 'sysBusinessAction!add', '02', '业务管理》业务管理》添加订单');
INSERT INTO `sys_function` VALUES ('66', '修改订单', '16', 'sysBusinessAction!edit', '02', '业务管理》业务管理》修改订单');
INSERT INTO `sys_function` VALUES ('67', '订单要求', '16', 'sysBusinessAction!claim', '02', '业务管理》业务管理》订单要求');
INSERT INTO `sys_function` VALUES ('68', '客户特点', '16', 'sysBusinessAction!feature', '02', '业务管理》业务管理》客户特色');
INSERT INTO `sys_function` VALUES ('69', '添加维护', '18', 'sysMaintainAction!add', '02', '维护管理》维护管理》添加维护');
INSERT INTO `sys_function` VALUES ('70', '修改维护', '18', 'sysMaintainAction!edit', '02', '维护管理》维护管理》修改维护');
INSERT INTO `sys_function` VALUES ('71', '修改客户', '14', 'sysCustAction!edit', '02', '客户挂你了》客户管理》修改客户');
INSERT INTO `sys_function` VALUES ('72', '添加联系', '61', 'sysContactAction!add', '02', '客户管理》客户管理》联系方式》添加联系');
INSERT INTO `sys_function` VALUES ('73', '修改联系', '61', 'sysContactAction!edit', '02', '客户管理》客户管理》联系方式》修改联系');
INSERT INTO `sys_function` VALUES ('74', '查  询', '61', 'sysContactAction!query', '02', '客户管理》客户管理》联系方式》查询');
INSERT INTO `sys_function` VALUES ('75', '添加维护', '62', 'sysMaintainForCustAction!add', '02', '客户管理》客户管理》维护记录》添加维护');
INSERT INTO `sys_function` VALUES ('76', '修改维护', '62', 'sysMaintainForCustAction!edit', '02', '客户管理》客户管理》维护记录》修改维护');
INSERT INTO `sys_function` VALUES ('77', '查  询', '62', 'sysMaintainForCustAction!query', '02', '客户管理》客户管理》维护记录》查询');
INSERT INTO `sys_function` VALUES ('78', '添加订单', '63', 'sysBusinessForCustAction!add', '02', '客户管理》客户管理》业务管理》添加订单');
INSERT INTO `sys_function` VALUES ('79', '修改订单', '63', 'sysBusinessForCustAction!edit', '02', '客户管理》客户管理》业务管理》修改订单');
INSERT INTO `sys_function` VALUES ('80', '查  询', '63', 'sysBusinessForCustAction!query', '02', '客户管理》客户管理》业务管理》查询');
INSERT INTO `sys_function` VALUES ('81', '生产记录', '16', 'sysBusinessAction!record', '02', '业务管理》业务管理》生产记录');
INSERT INTO `sys_function` VALUES ('82', '添加记录', '81', 'sysRecordAction!add', '02', '业务管理》业务管理》生产记录》添加记录');
INSERT INTO `sys_function` VALUES ('83', '修改记录', '81', 'sysRecordAction!edit', '02', '业务管理》业务管理》生产记录》修改记录');
INSERT INTO `sys_function` VALUES ('84', '供应商管理', null, null, '01', '供应商管理');
INSERT INTO `sys_function` VALUES ('85', '供应商管理', '84', '/sysSupplier/sysSupplierAction!query', '01', '供应商管理》供应商管理');
INSERT INTO `sys_function` VALUES ('86', '添加供应商', '85', 'sysSupplierAction!add', '02', '供应商管理》供应商管理》添加供应商');
INSERT INTO `sys_function` VALUES ('87', '修改供应商', '85', 'sysSupplierAction!edit', '02', '供应商管理》供应商管理》修改供应商');
INSERT INTO `sys_function` VALUES ('88', '删除供应商', '85', 'sysSupplierAction!delete', '02', '供应商管理》供应商管理》删除供应商');
INSERT INTO `sys_function` VALUES ('89', '供应商主营', '9000', '/system/baseMainAction!query', '01', '系统管理》供应商主营');
INSERT INTO `sys_function` VALUES ('90', '增  加', '89', 'baseMainAction!add', '02', '系统管理》供应商主营》增加');
INSERT INTO `sys_function` VALUES ('91', '修  改', '89', 'baseMainAction!edit', '02', '系统管理》供应商主营》修改');
INSERT INTO `sys_function` VALUES ('92', '删  除', '89', 'baseMainAction!delete', '02', '系统管理》供应商主营》删除');
INSERT INTO `sys_function` VALUES ('93', '删除记录', '81', 'sysRecordAction!delete', '02', '业务管理》业务管理》生产记录》删除记录');
INSERT INTO `sys_function` VALUES ('94', '查  询', '81', 'sysRecordAction!query', '02', '业务管理》业务管理》生产记录》查询');
INSERT INTO `sys_function` VALUES ('95', '删除记录', '81', 'sysRecordAction!delete', '02', '业务管理》业务管理》生产记录》删除记录');
INSERT INTO `sys_function` VALUES ('96', '生产类型', '9000', '/system/baseProductionAction!query', '01', '系统管理》生产类型');
INSERT INTO `sys_function` VALUES ('97', '增  加', '96', 'baseProductionAction!add', '02', '系统管理》生产类型》增加');
INSERT INTO `sys_function` VALUES ('98', '修  改', '96', 'baseProductionAction!edit', '02', '系统管理》生产类型》修改');
INSERT INTO `sys_function` VALUES ('99', '删  除', '96', 'baseProductionAction!delete', '02', '系统管理》生产类型》删除');
INSERT INTO `sys_function` VALUES ('9000', '系统管理', null, null, '01', '系统管理');
INSERT INTO `sys_function` VALUES ('9001', '删除客户', '14', 'sysCustAction!add', '02', '客户管理》客户管理》删除客户');

-- ----------------------------
-- Table structure for `sys_maintain`
-- ----------------------------
DROP TABLE IF EXISTS `sys_maintain`;
CREATE TABLE `sys_maintain` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUST_ID` int(11) DEFAULT NULL,
  `MAINTAIN_TIME` datetime DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `TYPE_ID` int(11) DEFAULT NULL,
  `ACTIVE_DESC` varchar(500) DEFAULT NULL,
  `RESULT` varchar(500) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUST_ID` (`CUST_ID`),
  KEY `TYPE_ID` (`TYPE_ID`),
  CONSTRAINT `sys_maintain_ibfk_1` FOREIGN KEY (`CUST_ID`) REFERENCES `sys_cust` (`ID`),
  CONSTRAINT `sys_maintain_ibfk_2` FOREIGN KEY (`TYPE_ID`) REFERENCES `base_maintaintype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_maintain
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_record`
-- ----------------------------
DROP TABLE IF EXISTS `sys_record`;
CREATE TABLE `sys_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUSINESS_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `PRODUCTION_ID` int(11) DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `TOTAL` double DEFAULT NULL,
  `DEBIT` double DEFAULT NULL,
  `SUPPLIER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `BUSINESS_ID` (`BUSINESS_ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `PRODUCTION_ID` (`PRODUCTION_ID`),
  KEY `FKE533DA03F81F83FE` (`SUPPLIER_ID`),
  CONSTRAINT `FKE533DA03F81F83FE` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `sys_supplier` (`ID`),
  CONSTRAINT `sys_record_ibfk_1` FOREIGN KEY (`BUSINESS_ID`) REFERENCES `sys_business` (`ID`),
  CONSTRAINT `sys_record_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`),
  CONSTRAINT `sys_record_ibfk_3` FOREIGN KEY (`PRODUCTION_ID`) REFERENCES `base_production` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_record
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '全部权限');
INSERT INTO `sys_role` VALUES ('2', '主管', '指定权限');
INSERT INTO `sys_role` VALUES ('3', '业务员', '指定权限');

-- ----------------------------
-- Table structure for `sys_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `sys_supplier`;
CREATE TABLE `sys_supplier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `PHONE_TH1` varchar(100) DEFAULT NULL,
  `PHONE_TH2` varchar(100) DEFAULT NULL,
  `QQ` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `MAIN_TH1_ID` int(11) DEFAULT NULL,
  `MAIN_TH2_ID` int(11) DEFAULT NULL,
  `MAIN_TH3_ID` int(11) DEFAULT NULL,
  `MAIN_TH4_ID` int(11) DEFAULT NULL,
  `OTHER` varchar(500) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CLASS_ID` int(11) DEFAULT NULL,
  `QUALITY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CLASS_ID` (`CLASS_ID`),
  KEY `QUALITY_ID` (`QUALITY_ID`),
  KEY `MAIN_TH1_ID` (`MAIN_TH1_ID`),
  KEY `MAIN_TH2_ID` (`MAIN_TH2_ID`),
  KEY `MAIN_TH3_ID` (`MAIN_TH3_ID`),
  KEY `MAIN_TH4_ID` (`MAIN_TH4_ID`),
  CONSTRAINT `sys_supplier_ibfk_3` FOREIGN KEY (`MAIN_TH1_ID`) REFERENCES `base_main` (`ID`),
  CONSTRAINT `sys_supplier_ibfk_4` FOREIGN KEY (`MAIN_TH2_ID`) REFERENCES `base_main` (`ID`),
  CONSTRAINT `sys_supplier_ibfk_5` FOREIGN KEY (`MAIN_TH3_ID`) REFERENCES `base_main` (`ID`),
  CONSTRAINT `sys_supplier_ibfk_6` FOREIGN KEY (`MAIN_TH4_ID`) REFERENCES `base_main` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `PHONE_TH1` varchar(100) DEFAULT NULL,
  `PHONE_TH2` varchar(100) DEFAULT NULL,
  `EMAIL_TH1` varchar(100) DEFAULT NULL,
  `EMAIL_TH2` varchar(100) DEFAULT NULL,
  `USER_STATE` varchar(10) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$1$hqmis$SbJV5WUMpMkFs0IIs3SyJ/', '1', '小胡', '01', '8299603', null, '502636321', null, '01', '23');
INSERT INTO `sys_user` VALUES ('2', '12345', '$1$hqmis$6v6ujeCfHrkBxjUMzST/2/', '2', '小周', '01', '', null, '', null, '01', '');
INSERT INTO `sys_user` VALUES ('3', 'prince', '$1$hqmis$SbJV5WUMpMkFs0IIs3SyJ/', '3', '小猪', '01', '', null, '', null, '01', '');
INSERT INTO `sys_user` VALUES ('4', 'huxiao', '$1$hqmis$SbJV5WUMpMkFs0IIs3SyJ/', '2', 'huxiao', '01', '232323', null, '', null, '01', '23');
