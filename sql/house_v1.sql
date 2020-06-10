/*
 Navicat Premium Data Transfer

 Source Server         : 众马科技
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 47.99.74.115:4000
 Source Schema         : house_v1

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 21/04/2020 16:46:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_user
-- ----------------------------
DROP TABLE IF EXISTS `a_user`;
CREATE TABLE `a_user`  (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `openid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信用户的唯一标识，现在是28位，在此保留40',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码（AES128加密）',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `created_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 179 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_user
-- ----------------------------
INSERT INTO `a_user` VALUES (168, '18852070321', NULL, NULL, NULL, NULL, '2020-01-17 13:20:13', '2020-01-17 13:20:13', 'A');
INSERT INTO `a_user` VALUES (169, '15605167902', 'oMfAK4ymyF6tx3enmI5HDNaqjihs', 'Oops', NULL, NULL, '2020-01-18 14:53:13', '2020-01-18 14:53:13', 'A');
INSERT INTO `a_user` VALUES (170, '', NULL, NULL, NULL, NULL, '2020-01-18 15:28:14', '2020-01-18 15:28:14', 'A');
INSERT INTO `a_user` VALUES (171, '13813900812', NULL, NULL, NULL, NULL, '2020-03-04 18:56:17', '2020-03-04 18:56:17', 'A');
INSERT INTO `a_user` VALUES (172, '18115133739', 'oMfAK45HmKnwrfrKcgyEHxIQ5DX0', 'Anoxia.', NULL, NULL, '2020-03-04 19:23:03', '2020-03-04 19:23:03', 'A');
INSERT INTO `a_user` VALUES (177, '13270664826', 'oMfAK4_5I82LOJ4MPYisYamCHj58', '', NULL, NULL, '2020-03-23 10:16:28', '2020-03-23 10:16:28', 'A');
INSERT INTO `a_user` VALUES (178, '18061608833', 'oMfAK4564p71-tl63jA42lk1nLHg', '', NULL, NULL, '2020-04-01 17:54:38', '2020-04-01 17:54:38', 'A');

-- ----------------------------
-- Table structure for c_eecstate
-- ----------------------------
DROP TABLE IF EXISTS `c_eecstate`;
CREATE TABLE `c_eecstate`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `table` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表名称',
  `colm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `colm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '列名',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
  `code_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码名称',
  `seq` int(2) NULL DEFAULT NULL COMMENT '序号',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态 X:隐藏；A：显示',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_eecstate
-- ----------------------------
INSERT INTO `c_eecstate` VALUES (1, 'public', '公用表', 'is_enable', '状态', '1', '启用', 1, '', 'A', '2019-06-24 15:21:30', '2019-12-05 13:46:23');
INSERT INTO `c_eecstate` VALUES (2, 'public', '公用表', 'is_enable', '状态', '0', '禁用', 2, '', 'A', '2019-06-24 15:22:26', '2019-12-05 13:46:22');
INSERT INTO `c_eecstate` VALUES (3, 'public', '公用表', 'sex', '性别', 'm', '男', 1, '', 'A', '2019-06-28 13:49:47', '2019-12-05 13:46:24');
INSERT INTO `c_eecstate` VALUES (4, 'public', '公用表', 'sex', '性别', 'f', '女', 2, '', 'A', '2019-06-28 13:50:08', '2019-12-05 13:46:24');
INSERT INTO `c_eecstate` VALUES (5, 'public', '公用表', 'state', '状态', 'A', '可用', 1, '', 'A', '2019-06-30 17:48:32', '2019-12-05 13:46:25');
INSERT INTO `c_eecstate` VALUES (6, 'public', '公用表', 'state', '状态', 'X', '删除', 2, '', 'A', '2019-06-30 17:48:32', '2019-12-05 13:46:25');
INSERT INTO `c_eecstate` VALUES (7, 'public', '公用表', 'state', '状态', 'O', '往期', 3, NULL, 'A', '2019-10-31 11:25:17', '2019-12-05 13:46:42');
INSERT INTO `c_eecstate` VALUES (8, 't_house', '房源', 'price_unit', '价格单位', 'A', '元/月', 1, NULL, 'A', '2019-12-05 13:55:25', '2019-12-08 17:26:10');
INSERT INTO `c_eecstate` VALUES (9, 't_house', '房源', 'price_unit', '价格单位', 'B', '元/㎡/天', 2, NULL, 'A', '2019-12-05 13:55:46', '2019-12-08 17:27:02');
INSERT INTO `c_eecstate` VALUES (10, 't_house', '房源', 'price_unit', '价格单位', 'C', '元/工位/月', 3, NULL, 'A', '2019-12-06 00:20:50', '2019-12-08 17:27:06');
INSERT INTO `c_eecstate` VALUES (11, 't_house_photo', '房源图片', 'type', '图片类型', 'A', '首页照片', 1, NULL, 'A', '2019-12-06 00:20:21', '2019-12-06 00:21:06');
INSERT INTO `c_eecstate` VALUES (12, 't_house_photo', '房源图片', 'type', '图片类型', 'B', '外观照片', 2, NULL, 'A', '2019-12-06 00:21:17', '2019-12-06 00:22:03');
INSERT INTO `c_eecstate` VALUES (13, 't_house_photo', '房源图片', 'type', '图片类型', 'C', '公共区域照片', 3, NULL, 'A', '2019-12-06 00:21:21', '2019-12-06 00:22:03');
INSERT INTO `c_eecstate` VALUES (14, 't_house_photo', '房源图片', 'type', '图片类型', 'D', '周边照片', 4, NULL, 'A', '2019-12-06 00:21:22', '2019-12-12 20:48:11');
INSERT INTO `c_eecstate` VALUES (15, 't_house_photo', '房源图片', 'type', '图片类型', 'E', '其他照片', 5, NULL, 'A', '2019-12-06 00:21:23', '2019-12-12 20:48:15');
INSERT INTO `c_eecstate` VALUES (16, 't_house_extend', '房源续表', 'decorate', '装修情况', 'A', '豪装', 1, NULL, 'A', '2019-12-06 21:31:18', '2019-12-06 21:31:59');
INSERT INTO `c_eecstate` VALUES (17, 't_house_extend', '房源续表', 'decorate', '装修情况', 'B', '精装', 2, NULL, 'A', '2019-12-06 21:31:25', '2019-12-07 09:40:16');
INSERT INTO `c_eecstate` VALUES (18, 't_house_extend', '房源续表', 'decorate', '装修情况', 'C', '简装', 3, NULL, 'A', '2019-12-06 21:31:26', '2019-12-07 09:40:18');
INSERT INTO `c_eecstate` VALUES (19, 't_house_extend', '房源续表', 'decorate', '装修情况', 'D', '标准交付', 4, NULL, 'A', '2019-12-06 21:31:27', '2019-12-07 09:40:20');
INSERT INTO `c_eecstate` VALUES (20, 't_house_extend', '房源续表', 'decorate', '装修情况', 'E', '毛胚', 5, NULL, 'A', '2019-12-06 21:31:27', '2019-12-07 09:40:26');
INSERT INTO `c_eecstate` VALUES (21, 't_field_template', '房源自定义字段', 'fieldType', '字段类型', 'text', '文本输入框', 1, NULL, 'A', '2019-12-12 11:23:14', '2019-12-12 11:23:14');
INSERT INTO `c_eecstate` VALUES (22, 't_field_template', '房源自定义字段', 'fieldType', '字段类型', 'number', '数字输入框', 2, NULL, 'A', '2019-12-12 11:23:19', '2019-12-16 16:05:13');
INSERT INTO `c_eecstate` VALUES (23, 't_field_template', '房源自定义字段', 'fieldType', '字段类型', 'date', '日期输入框', 3, NULL, 'A', '2019-12-12 11:23:20', '2019-12-16 16:05:13');
INSERT INTO `c_eecstate` VALUES (24, 't_field_template', '房源自定义字段', 'fieldType', '字段类型', 'radio', '单选框', 4, NULL, 'A', '2019-12-12 11:23:21', '2019-12-16 16:05:13');
INSERT INTO `c_eecstate` VALUES (25, 't_field_template', '房源自定义字段', 'fieldType', '字段类型', 'checkbox', '多选框', 5, NULL, 'A', '2019-12-12 11:23:21', '2019-12-16 16:05:13');
INSERT INTO `c_eecstate` VALUES (26, 't_house_extend', '房源续表', 'rent_state', '租赁状态', 'A', '调整中', 3, '即不可租的房源，查询时不需要查出此类型的房源', 'A', '2019-12-16 16:03:11', '2020-01-02 15:36:03');
INSERT INTO `c_eecstate` VALUES (27, 't_house_extend', '房源续表', 'rent_state', '租赁状态', 'B', '招租中', 1, NULL, 'A', '2019-12-16 16:03:12', '2020-01-02 15:27:06');
INSERT INTO `c_eecstate` VALUES (28, 't_house_extend', '房源续表', 'rent_state', '租赁状态', 'C', '已出租', 2, NULL, 'A', '2019-12-16 16:03:13', '2020-01-02 15:27:08');
INSERT INTO `c_eecstate` VALUES (31, 't_distribution_user_system', '用户结构表', 'role', '角色', 'A', '分销员', 1, NULL, 'A', '2019-12-21 19:45:10', '2019-12-24 16:22:03');
INSERT INTO `c_eecstate` VALUES (32, 't_distribution_user_system', '用户结构表', 'role', '角色', 'B', '客户', 2, NULL, 'A', '2019-12-21 19:46:36', '2019-12-24 16:22:03');

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地名',
  `pid` int(7) UNSIGNED NULL DEFAULT NULL COMMENT '父级区域标识',
  `seq` int(2) NOT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES (1, '江宁', 1, 1, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (2, '浦口', 1, 2, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (3, '栖霞', 1, 3, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (4, '滨江开发区', 1, 4, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (5, '高淳', 1, 5, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (6, '鼓楼', 1, 6, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (7, '建邺', 1, 7, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (8, '溧水', 1, 8, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (9, '六合', 1, 9, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (10, '秦淮', 1, 10, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (11, '玄武', 1, 11, '2020-01-02 15:19:50', '2020-01-04 15:56:26', 'A');
INSERT INTO `t_area` VALUES (12, '雨花台', 1, 12, '2020-01-02 15:19:50', '2020-01-04 15:57:54', 'A');

-- ----------------------------
-- Table structure for t_area_region_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_area_region_relation`;
CREATE TABLE `t_area_region_relation`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `area_id` int(7) UNSIGNED NOT NULL COMMENT '区域标识',
  `region_id` int(5) UNSIGNED NOT NULL COMMENT '板块标识',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_area_region_relation
-- ----------------------------
INSERT INTO `t_area_region_relation` VALUES (3, 1, 1, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (4, 1, 2, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (5, 1, 3, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (6, 1, 4, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (7, 1, 5, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (8, 1, 6, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (9, 1, 7, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (10, 1, 8, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (11, 1, 9, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (12, 1, 10, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (13, 1, 11, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (14, 1, 12, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (15, 1, 13, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (16, 1, 14, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (17, 1, 15, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (18, 1, 16, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (19, 1, 17, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (20, 2, 18, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (21, 2, 19, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (22, 2, 20, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (23, 2, 21, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (24, 2, 22, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (25, 2, 23, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (26, 2, 24, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (27, 3, 25, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (28, 3, 26, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (29, 3, 27, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (30, 3, 28, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (31, 3, 29, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (32, 3, 30, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (33, 3, 31, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (34, 3, 32, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (35, 3, 33, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (36, 3, 34, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (37, 3, 35, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (38, 3, 36, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (39, 3, 37, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (40, 4, 38, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (41, 4, 39, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (42, 4, 40, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (43, 5, 41, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (44, 6, 42, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (45, 6, 43, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (46, 6, 44, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (47, 6, 45, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (48, 6, 46, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (49, 6, 47, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (50, 6, 48, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (51, 6, 49, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (52, 6, 50, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (53, 6, 51, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (54, 6, 52, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (55, 6, 53, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (56, 6, 54, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (57, 6, 55, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (58, 6, 56, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (59, 6, 57, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (60, 6, 58, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (61, 6, 59, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (62, 7, 60, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (63, 7, 61, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (64, 7, 62, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (65, 7, 63, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (66, 7, 64, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (67, 7, 65, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (68, 7, 66, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (69, 7, 67, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (70, 8, 68, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (71, 9, 69, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (72, 9, 70, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (73, 9, 71, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (74, 9, 72, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (75, 9, 73, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (76, 10, 74, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (77, 10, 75, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (78, 10, 76, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (79, 10, 77, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (80, 10, 78, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (81, 10, 79, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (82, 10, 80, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (83, 10, 81, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (84, 10, 82, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (85, 10, 83, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (86, 10, 84, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (87, 10, 85, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (88, 10, 86, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (89, 10, 87, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (90, 10, 88, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (91, 10, 89, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (92, 10, 90, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (93, 10, 91, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (94, 10, 92, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (95, 11, 93, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (96, 11, 94, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (97, 11, 95, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (98, 11, 96, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (99, 11, 97, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (100, 11, 98, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (101, 11, 99, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (102, 11, 100, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (103, 11, 101, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (104, 11, 102, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (105, 11, 103, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (106, 11, 104, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (107, 11, 105, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (108, 11, 106, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (109, 12, 107, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (110, 12, 108, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (111, 12, 109, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (112, 12, 110, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (113, 12, 111, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (114, 12, 112, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (115, 12, 113, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (116, 12, 114, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');
INSERT INTO `t_area_region_relation` VALUES (117, 12, 115, '2020-01-02 15:22:17', '2020-01-02 15:22:17', 'A');

-- ----------------------------
-- Table structure for t_bargain_user
-- ----------------------------
DROP TABLE IF EXISTS `t_bargain_user`;
CREATE TABLE `t_bargain_user`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标识',
  `bargain_user_publish_id` int(6) UNSIGNED NOT NULL COMMENT '发起砍价表标识',
  `user_id` int(6) UNSIGNED NOT NULL COMMENT '砍价用户标识',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态,A-在用;\r\n            C-审核中，\r\n            B-退回；\r\n            X-删除',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_bargain_user_publish
-- ----------------------------
DROP TABLE IF EXISTS `t_bargain_user_publish`;
CREATE TABLE `t_bargain_user_publish`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_house_bargain_id` int(6) UNSIGNED NOT NULL COMMENT '砍价规则表id',
  `user_id` int(6) UNSIGNED NOT NULL COMMENT '发起砍价的用户id',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A-在用;\r\n            C-审核中，\r\n            B-退回；\r\n            X-删除',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bargain_user_publish
-- ----------------------------
INSERT INTO `t_bargain_user_publish` VALUES (17, 14, 173, 'A', '2020-03-16 14:22:36', '2020-03-16 14:22:36');
INSERT INTO `t_bargain_user_publish` VALUES (18, 19, 172, 'A', '2020-03-19 13:35:35', '2020-03-19 13:35:35');
INSERT INTO `t_bargain_user_publish` VALUES (19, 19, 177, 'A', '2020-03-23 14:27:45', '2020-03-23 14:27:45');

-- ----------------------------
-- Table structure for t_commission
-- ----------------------------
DROP TABLE IF EXISTS `t_commission`;
CREATE TABLE `t_commission`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `user_system_id` int(6) NOT NULL COMMENT '用户结构标识',
  `contract_id` int(6) NOT NULL COMMENT '合同标识',
  `house_id` int(7) NOT NULL COMMENT '房源标识',
  `money` decimal(9, 2) NOT NULL DEFAULT 0.00 COMMENT '佣金金额',
  `pay_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'C' COMMENT '支付状态，\r\nA:已打款\r\n            X:未打款\r\n            C:审核',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态，\r\nA:有效\r\n            X:无效\r\n            C:审核',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_commission_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_commission_rule`;
CREATE TABLE `t_commission_rule`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `house_id` int(7) NOT NULL COMMENT '房源标识',
  `first_level` int(3) NOT NULL COMMENT '一级提成',
  `sec_level` int(3) NOT NULL COMMENT '二级提成',
  `third_level` int(3) NOT NULL COMMENT '三级提成',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态，A:有效\r\n            X:无效\r\n            C:审核',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact`  (
  `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve3` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 185 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES (153, '王越', '18852070321', '2020-01-17 13:20:13', '2020-01-17 13:20:13', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (154, '老张', '18852070321', '2020-01-17 13:43:59', '2020-01-17 13:43:59', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (155, '1', '15605167902', '2020-01-18 15:28:14', '2020-01-18 15:28:14', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (156, '', '', '2020-01-18 15:28:14', '2020-01-18 15:28:14', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (157, '1', '15605167902', '2020-01-18 15:52:07', '2020-01-18 15:52:07', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (158, '', '', '2020-01-18 15:52:07', '2020-01-18 15:52:07', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (159, 'hzp', '13813900812', '2020-03-04 18:56:17', '2020-03-04 18:56:17', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (160, '柠檬', '18115133739', '2020-03-16 13:41:16', '2020-03-16 13:41:16', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (161, '柠檬', '18115133739', '2020-03-16 13:46:40', '2020-03-16 13:46:40', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (162, '柠檬', '18115133739', '2020-03-16 13:46:56', '2020-03-16 13:46:56', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (163, '柠檬', '18115133739', '2020-03-16 13:47:15', '2020-03-16 13:47:15', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (164, '柠檬', '18115133739', '2020-03-16 13:48:49', '2020-03-16 13:48:49', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (165, '柠檬', '18115133739', '2020-03-16 13:53:09', '2020-03-16 13:53:09', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (166, '柠檬', '18115133739', '2020-03-18 09:10:35', '2020-03-18 09:10:35', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (167, '柠檬', '18115133739', '2020-03-18 09:18:01', '2020-03-18 09:18:01', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (168, '柠檬', '18115133739', '2020-03-18 09:20:34', '2020-03-18 09:20:34', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (169, '柠檬', '18115133739', '2020-03-18 09:24:10', '2020-03-18 09:24:10', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (170, '柠檬', '18115133739', '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (171, '柠檬', '18115133739', '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (172, '柠檬', '13813900812', '2020-03-18 09:58:33', '2020-03-18 09:58:33', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (173, '柠檬', '18115133739', '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (174, '柠檬', '18115133739', '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (175, '柠檬', '13813900812', '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (176, '周丰皓', '13270664826', '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (177, '周丰皓', '13270664826', '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (178, '周', '13270664826', '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (179, '周', '13270664826', '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (180, '周', '13270664826', '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (181, '周丰皓', '13270664826', '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (182, '周', '13270664826', '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (183, '周', '13270664826', '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A', NULL, NULL, NULL);
INSERT INTO `t_contact` VALUES (184, '周丰皓', '13270664826', '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_contract_coupon_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_coupon_relation`;
CREATE TABLE `t_contract_coupon_relation`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `coupon_id` int(6) NOT NULL COMMENT '优惠券标识',
  `contract_id` int(6) NOT NULL COMMENT '合同标识',
  `audit_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT '审核状态,A:有效\r\n            X:无效\r\n           W:审核中',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态，A:有效\r\n            X:无效\r\n           W:审核',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标识',
  `coupon_number` int(6) UNSIGNED NOT NULL COMMENT '优惠券编码',
  `discounted_price` decimal(9, 2) NOT NULL COMMENT '优惠金额',
  `condition_price` decimal(9, 2) NOT NULL COMMENT '满足金额',
  `start_date` datetime(0) NOT NULL COMMENT '开始有效时间',
  `end_date` datetime(0) NOT NULL COMMENT '结束有效时间',
  `user_id` int(6) UNSIGNED NULL DEFAULT NULL COMMENT '用户标识',
  `audit_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT '审核状态，A:有效\r\n            X:无效\r\n            W:审核',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态,A:有效\r\n            X:无效\r\n            C:审核',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '使用情况 \'Y\'已使用 ‘N’未使用',
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_coupon
-- ----------------------------
INSERT INTO `t_coupon` VALUES (1, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', NULL, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:50:28', '2020-01-18 14:50:28');
INSERT INTO `t_coupon` VALUES (2, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', NULL, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:50:50', '2020-01-18 14:50:50');
INSERT INTO `t_coupon` VALUES (3, 222, 300.00, 3000.00, '2020-01-03 14:51:04', '2020-01-16 14:51:08', NULL, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:51:07', '2020-01-18 14:51:07');
INSERT INTO `t_coupon` VALUES (20, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 160, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:52:37', '2020-01-18 14:52:37');
INSERT INTO `t_coupon` VALUES (21, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 169, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:53:17', '2020-01-18 14:53:17');
INSERT INTO `t_coupon` VALUES (22, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 169, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:53:30', '2020-01-18 14:53:30');
INSERT INTO `t_coupon` VALUES (23, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', 169, 'W', 'A', NULL, 'N', NULL, '2020-01-18 14:53:41', '2020-01-18 14:53:41');
INSERT INTO `t_coupon` VALUES (24, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 173, 'W', 'A', NULL, 'N', NULL, '2020-03-16 14:10:20', '2020-03-16 14:10:20');
INSERT INTO `t_coupon` VALUES (25, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', 173, 'W', 'A', NULL, 'N', NULL, '2020-03-16 14:10:26', '2020-03-16 14:10:26');
INSERT INTO `t_coupon` VALUES (26, 222, 300.00, 3000.00, '2020-01-03 14:51:04', '2020-01-16 14:51:08', 173, 'W', 'A', NULL, 'N', NULL, '2020-03-16 14:10:28', '2020-03-16 14:10:28');
INSERT INTO `t_coupon` VALUES (27, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 08:43:51', '2020-03-17 08:43:51');
INSERT INTO `t_coupon` VALUES (28, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 08:43:52', '2020-03-17 08:43:52');
INSERT INTO `t_coupon` VALUES (29, 222, 300.00, 3000.00, '2020-01-03 14:51:04', '2020-01-16 14:51:08', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 08:43:53', '2020-03-17 08:43:53');
INSERT INTO `t_coupon` VALUES (30, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 09:43:31', '2020-03-17 09:43:31');
INSERT INTO `t_coupon` VALUES (31, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 09:44:22', '2020-03-17 09:44:22');
INSERT INTO `t_coupon` VALUES (32, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-17 09:45:32', '2020-03-17 09:45:32');
INSERT INTO `t_coupon` VALUES (33, 111, 200.00, 2000.00, '2020-01-02 14:50:46', '2020-01-17 14:50:50', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-19 08:33:13', '2020-03-19 08:33:13');
INSERT INTO `t_coupon` VALUES (34, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 174, 'W', 'A', NULL, 'N', NULL, '2020-03-19 08:52:44', '2020-03-19 08:52:44');
INSERT INTO `t_coupon` VALUES (35, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 174, 'W', 'A', NULL, 'N', NULL, '2020-03-19 08:58:03', '2020-03-19 08:58:03');
INSERT INTO `t_coupon` VALUES (36, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 172, 'W', 'A', NULL, 'N', NULL, '2020-03-23 10:51:07', '2020-03-23 10:51:07');
INSERT INTO `t_coupon` VALUES (37, 123, 100.00, 1000.00, '2020-01-01 14:50:20', '2020-01-19 14:50:24', 177, 'W', 'A', NULL, 'N', NULL, '2020-03-23 13:26:10', '2020-03-23 13:26:10');

-- ----------------------------
-- Table structure for t_distribution_user_system
-- ----------------------------
DROP TABLE IF EXISTS `t_distribution_user_system`;
CREATE TABLE `t_distribution_user_system`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) NOT NULL COMMENT '用户标识',
  `p_user_id` int(6) NULL DEFAULT NULL COMMENT '父用户标识',
  `role` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色(域)\r\nA:一级分销商\r\n            B:二级分销商\r\n            C:分销员\r\n            D:客户\r\n\r\n',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A-在用;\r\n            C-审核中，\r\n            B-退回；\r\n            X-删除',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_distribution_user_system
-- ----------------------------
INSERT INTO `t_distribution_user_system` VALUES (42, 173, NULL, 'A', 'A', '2020-03-16 14:21:35', '2020-03-16 14:21:35');
INSERT INTO `t_distribution_user_system` VALUES (43, 172, NULL, 'A', 'A', '2020-03-17 09:04:24', '2020-03-17 09:04:24');
INSERT INTO `t_distribution_user_system` VALUES (44, 174, NULL, 'A', 'A', '2020-03-18 15:06:45', '2020-03-18 15:06:45');
INSERT INTO `t_distribution_user_system` VALUES (45, 175, NULL, 'A', 'A', '2020-03-23 09:12:36', '2020-03-23 09:12:36');
INSERT INTO `t_distribution_user_system` VALUES (46, 177, NULL, 'A', 'A', '2020-03-23 10:17:03', '2020-03-23 10:17:03');
INSERT INTO `t_distribution_user_system` VALUES (57, 178, NULL, 'A', 'A', '2020-04-01 17:54:42', '2020-04-01 17:54:42');

-- ----------------------------
-- Table structure for t_entrust_publish
-- ----------------------------
DROP TABLE IF EXISTS `t_entrust_publish`;
CREATE TABLE `t_entrust_publish`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) UNSIGNED NOT NULL COMMENT '用户标识',
  `entrust_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT '委托状态,A:已处理\r\n            B:处理中\r\n            W:未处理',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A:有效\r\n            X:无效',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_entrust_publish
-- ----------------------------
INSERT INTO `t_entrust_publish` VALUES (6, 173, 'W', 'A', NULL, NULL, '2020-03-16 18:17:04', '2020-03-16 18:17:04');
INSERT INTO `t_entrust_publish` VALUES (7, 172, 'W', 'A', NULL, NULL, '2020-03-17 09:06:32', '2020-03-17 09:06:32');
INSERT INTO `t_entrust_publish` VALUES (8, 106, 'W', 'A', NULL, NULL, '2020-03-25 19:18:59', '2020-03-25 19:18:59');

-- ----------------------------
-- Table structure for t_facility
-- ----------------------------
DROP TABLE IF EXISTS `t_facility`;
CREATE TABLE `t_facility`  (
  `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `facility` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设施名称',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  `reserve1` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_facility
-- ----------------------------
INSERT INTO `t_facility` VALUES (1, '电梯', '2019-12-27 21:12:45', '2020-01-03 11:04:51', 'A', NULL, NULL);
INSERT INTO `t_facility` VALUES (2, '家具', '2019-12-27 21:12:50', '2020-01-03 11:04:58', 'A', NULL, NULL);
INSERT INTO `t_facility` VALUES (3, '冰箱', '2019-12-27 21:12:50', '2020-01-03 11:05:26', 'A', NULL, NULL);
INSERT INTO `t_facility` VALUES (4, '打印机', '2020-01-03 11:05:32', '2020-01-03 11:05:39', 'A', NULL, NULL);
INSERT INTO `t_facility` VALUES (5, '会议室', '2020-01-03 11:05:44', '2020-01-03 11:05:44', 'A', NULL, NULL);
INSERT INTO `t_facility` VALUES (6, '宽带', '2020-01-03 11:05:49', '2020-01-03 11:05:49', 'A', NULL, NULL);

-- ----------------------------
-- Table structure for t_field_template
-- ----------------------------
DROP TABLE IF EXISTS `t_field_template`;
CREATE TABLE `t_field_template`  (
  `id` int(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `template` json NOT NULL COMMENT '字段模板内容',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_field_template
-- ----------------------------
INSERT INTO `t_field_template` VALUES (23, '{\"label\": \"总租赁房源数\", \"readOnly\": false, \"required\": false, \"sequence\": 1, \"fieldName\": \"totalHouseNum\", \"fieldType\": \"text\", \"maxLength\": 10, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 15:06:06', '2019-12-31 15:06:06', 'A');
INSERT INTO `t_field_template` VALUES (24, '{\"label\": \"物业公司\", \"readOnly\": false, \"required\": false, \"sequence\": 2, \"fieldName\": \"property\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 15:59:38', '2019-12-31 16:19:40', 'A');
INSERT INTO `t_field_template` VALUES (25, '{\"label\": \"物业费\", \"readOnly\": false, \"required\": false, \"sequence\": 3, \"fieldName\": \"propertyPrice\", \"fieldType\": \"text\", \"maxLength\": 15, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:00:45', '2019-12-31 16:00:45', 'A');
INSERT INTO `t_field_template` VALUES (26, '{\"label\": \"停车位\", \"readOnly\": false, \"required\": false, \"sequence\": 4, \"fieldName\": \"parkingSpot\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:02:55', '2019-12-31 16:02:55', 'A');
INSERT INTO `t_field_template` VALUES (27, '{\"label\": \"车位租金\", \"readOnly\": false, \"required\": false, \"sequence\": 5, \"fieldName\": \"parkingSpotPrice\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:03:48', '2019-12-31 16:03:48', 'A');
INSERT INTO `t_field_template` VALUES (28, '{\"label\": \"空调\", \"readOnly\": false, \"required\": false, \"sequence\": 6, \"fieldName\": \"airConditioner\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:05:13', '2020-01-03 14:10:12', 'X');
INSERT INTO `t_field_template` VALUES (29, '{\"label\": \"空调费\", \"readOnly\": false, \"required\": false, \"sequence\": 7, \"fieldName\": \"airConditionerPrice\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:05:40', '2020-01-03 14:10:26', 'X');
INSERT INTO `t_field_template` VALUES (30, '{\"label\": \"空调开放时间\", \"readOnly\": false, \"required\": false, \"sequence\": 8, \"fieldName\": \"airOpenRange\", \"fieldType\": \"text\", \"maxLength\": 50, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:06:34', '2020-01-03 14:09:51', 'X');
INSERT INTO `t_field_template` VALUES (31, '{\"label\": \"电梯\", \"readOnly\": false, \"required\": false, \"sequence\": 9, \"fieldName\": \"elevator\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:07:50', '2019-12-31 16:07:50', 'A');
INSERT INTO `t_field_template` VALUES (32, '{\"label\": \"网络\", \"readOnly\": false, \"required\": false, \"sequence\": 10, \"fieldName\": \"network\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:08:09', '2019-12-31 16:08:09', 'A');
INSERT INTO `t_field_template` VALUES (33, '{\"label\": \"运营公司\", \"readOnly\": false, \"required\": false, \"sequence\": 2, \"fieldName\": \"property\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:18:53', '2019-12-31 16:20:51', 'A');
INSERT INTO `t_field_template` VALUES (36, '{\"label\": \"押金\", \"readOnly\": false, \"required\": false, \"sequence\": 1, \"fieldName\": \"deposit\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:53:28', '2019-12-31 16:53:28', 'A');
INSERT INTO `t_field_template` VALUES (37, '{\"label\": \"办公格局\", \"readOnly\": false, \"required\": false, \"sequence\": 2, \"fieldName\": \"officePattern\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:54:46', '2019-12-31 16:54:46', 'A');
INSERT INTO `t_field_template` VALUES (38, '{\"label\": \"免租期\", \"readOnly\": false, \"required\": false, \"sequence\": 3, \"fieldName\": \"rentFreePeriod\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:55:27', '2019-12-31 16:55:27', 'A');
INSERT INTO `t_field_template` VALUES (39, '{\"label\": \"最短租期\", \"readOnly\": false, \"required\": false, \"sequence\": 4, \"fieldName\": \"minTenancyTerm\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:56:27', '2019-12-31 16:56:27', 'A');
INSERT INTO `t_field_template` VALUES (40, '{\"label\": \"看房时间\", \"readOnly\": false, \"required\": false, \"sequence\": 5, \"fieldName\": \"checkHouseTime\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:57:22', '2019-12-31 16:57:22', 'A');
INSERT INTO `t_field_template` VALUES (41, '{\"label\": \"最早可租\", \"readOnly\": false, \"required\": false, \"sequence\": 6, \"fieldName\": \"earliestRentTime\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2019-12-31 16:58:12', '2019-12-31 16:58:12', 'A');
INSERT INTO `t_field_template` VALUES (42, '{\"label\": \"电费\", \"readOnly\": false, \"required\": false, \"sequence\": 6, \"fieldName\": \"Electricity\", \"fieldType\": \"text\", \"maxLength\": 30, \"minLength\": 0, \"defaultValue\": \"\"}', '2020-01-03 14:11:22', '2020-01-03 14:11:22', 'A');

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `house_type_id` int(2) UNSIGNED NOT NULL COMMENT '房源类型标识',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '无' COMMENT '名称-办公室类别不填',
  `area` int(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '面积-办公室类别必填\r\n            其余类别选填',
  `price` decimal(9, 2) UNSIGNED NULL DEFAULT NULL COMMENT '单价',
  `price_unit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位(域)',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `region_id` int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '板块标识-办公室类别不填',
  `latitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '纬度',
  `longitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '经度',
  `house_extend_id` int(10) UNSIGNED NOT NULL COMMENT '房源扩展信息标识',
  `audit_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT 'A:审核通过\r\nX:未通过\r\nW:审核中',
  `reserve1` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层(域)[暂时先在前端写死]',
  `reserve2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号,办公室必填',
  `reserve3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES (163, 4, '高格共享空间', 1000, NULL, '', '双龙大道1698号', 1, 0.0000000, 0.0000000, 195, 'A', NULL, NULL, NULL, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house` VALUES (164, 1, '新城国际', 3500, NULL, '', '天鹅湖', 18, 0.0000000, 0.0000000, 196, 'A', NULL, NULL, NULL, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house` VALUES (165, 1, '万科中心', 90000, NULL, '', '南门换乘中心', 27, 0.0000000, 0.0000000, 197, 'A', NULL, NULL, NULL, '2020-03-18 09:58:33', '2020-03-18 09:58:33', 'A');
INSERT INTO `t_house` VALUES (166, 5, '万科中心·高层·84m²', 55, 3.20, 'B', '南门换乘中心', 27, 0.0000000, 0.0000000, 198, 'A', '8F', NULL, NULL, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house` VALUES (167, 5, '高格办公空间·高层·120m²', 120, 14110.00, 'A', '双龙大道1698号', 1, 0.0000000, 0.0000000, 199, 'A', '15F', NULL, NULL, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house` VALUES (169, 5, '832', 50, 2.50, 'A', '双龙大道1698号', 1, 0.0000000, 0.0000000, 201, 'A', '8F', NULL, NULL, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house` VALUES (174, 1, '天琪科技大厦', 15900, NULL, '', '江苏省南京市江宁区董村路35号', 1, 0.0000000, 0.0000000, 207, 'A', NULL, NULL, NULL, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house` VALUES (176, 5, '天琪科技大厦 · 28m²', 28, 800.00, 'A', '江苏省南京市江宁区董村路35号', 1, 0.0000000, 0.0000000, 209, 'A', '8F', NULL, NULL, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house` VALUES (179, 5, '天琪科技大厦10F', 300, 300.00, 'A', '江苏省南京市江宁区董村路35号', 1, 0.0000000, 0.0000000, 213, 'A', '10F', NULL, NULL, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house` VALUES (180, 5, '天琪科技大厦12F', 100, 100.00, 'A', '', 1, 25.0000000, 24.0000000, 214, 'A', NULL, NULL, NULL, '2020-03-24 11:08:25', '2020-03-24 11:10:07', 'A');
INSERT INTO `t_house` VALUES (181, 5, '866', 30, 10.00, 'C', '', 1, 25.0000000, 24.0000000, 215, 'A', NULL, NULL, NULL, '2020-03-24 11:28:36', '2020-03-24 11:29:20', 'A');
INSERT INTO `t_house` VALUES (182, 3, '绿地之窗', 1200, NULL, '', '北广场：江苏省南京市雨花台区锦绣街5号。南广场：江苏省南京市江宁区江南路', 111, 0.0000000, 0.0000000, 216, 'A', NULL, NULL, NULL, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house` VALUES (185, 5, '绿地之窗 · 1851m²', 1851, 100.00, 'B', '', 1, 25.0000000, 24.0000000, 219, 'A', NULL, NULL, NULL, '2020-03-24 15:16:07', '2020-03-24 15:16:20', 'A');
INSERT INTO `t_house` VALUES (186, 5, '天琪大厦15F', 60, 60.00, 'B', '', 1, 25.0000000, 24.0000000, 220, 'A', NULL, NULL, NULL, '2020-03-24 15:48:19', '2020-03-24 15:49:05', 'A');
INSERT INTO `t_house` VALUES (187, 3, '光一科技产业园', 5000, NULL, '', '江苏省南京市江宁区将军大道128号', 6, 0.0000000, 0.0000000, 221, 'A', NULL, NULL, NULL, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_audit
-- ----------------------------
DROP TABLE IF EXISTS `t_house_audit`;
CREATE TABLE `t_house_audit`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL,
  `auditor_id` int(6) UNSIGNED NOT NULL COMMENT '审核员 ',
  `audit_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A:有效\r\n            X:无效\r\n            C:审核',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_house_commission
-- ----------------------------
DROP TABLE IF EXISTS `t_house_commission`;
CREATE TABLE `t_house_commission`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `money` decimal(9, 2) NOT NULL COMMENT '佣金，根据房源价格变动',
  `days` int(3) NOT NULL COMMENT '天数',
  `house_id` int(7) NOT NULL COMMENT '房源标识',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态，\r\nA:有效\r\n            X:无效\r\n            C:审核',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_commission
-- ----------------------------
INSERT INTO `t_house_commission` VALUES (57, 14110.00, 15, 163, 'A', NULL, NULL, NULL, '2020-03-18 09:39:08', '2020-03-18 11:54:08');
INSERT INTO `t_house_commission` VALUES (58, 10.00, 15, 164, 'A', NULL, NULL, NULL, '2020-03-18 09:46:25', '2020-03-24 11:28:36');
INSERT INTO `t_house_commission` VALUES (59, 5280.00, 5, 165, 'A', NULL, NULL, NULL, '2020-03-18 09:58:33', '2020-03-18 11:00:52');
INSERT INTO `t_house_commission` VALUES (60, 5280.00, 5, 166, 'A', NULL, NULL, NULL, '2020-03-18 11:00:52', '2020-03-18 11:00:52');
INSERT INTO `t_house_commission` VALUES (61, 14110.00, 15, 167, 'A', NULL, NULL, NULL, '2020-03-18 11:54:08', '2020-03-18 11:54:08');
INSERT INTO `t_house_commission` VALUES (62, 108000.00, 15, 174, 'A', NULL, NULL, NULL, '2020-03-24 09:07:46', '2020-03-24 15:48:19');
INSERT INTO `t_house_commission` VALUES (63, 800.00, 15, 176, 'A', NULL, NULL, NULL, '2020-03-24 09:23:17', '2020-03-24 09:23:17');
INSERT INTO `t_house_commission` VALUES (64, 300.00, 15, 179, 'A', NULL, NULL, NULL, '2020-03-24 11:05:59', '2020-03-24 11:05:59');
INSERT INTO `t_house_commission` VALUES (65, 100.00, 15, 180, 'A', NULL, NULL, NULL, '2020-03-24 11:08:25', '2020-03-24 11:08:25');
INSERT INTO `t_house_commission` VALUES (66, 10.00, 15, 181, 'A', NULL, NULL, NULL, '2020-03-24 11:28:36', '2020-03-24 11:28:36');
INSERT INTO `t_house_commission` VALUES (67, 5553000.00, 15, 182, 'A', NULL, NULL, NULL, '2020-03-24 14:53:31', '2020-03-24 15:16:07');
INSERT INTO `t_house_commission` VALUES (68, 5553000.00, 15, 185, 'A', NULL, NULL, NULL, '2020-03-24 15:16:07', '2020-03-24 15:16:07');
INSERT INTO `t_house_commission` VALUES (69, 108000.00, 15, 186, 'A', NULL, NULL, NULL, '2020-03-24 15:48:19', '2020-03-24 15:48:19');
INSERT INTO `t_house_commission` VALUES (70, 0.00, 0, 187, 'A', NULL, NULL, NULL, '2020-04-02 09:34:13', '2020-04-02 09:34:13');

-- ----------------------------
-- Table structure for t_house_contact_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_house_contact_relation`;
CREATE TABLE `t_house_contact_relation`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `contact_id` int(5) UNSIGNED NOT NULL COMMENT '联系人信息标识',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 192 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_contact_relation
-- ----------------------------
INSERT INTO `t_house_contact_relation` VALUES (177, 163, 170, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_contact_relation` VALUES (178, 164, 171, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_contact_relation` VALUES (179, 165, 172, '2020-03-18 09:58:33', '2020-03-18 09:58:33', 'A');
INSERT INTO `t_house_contact_relation` VALUES (180, 166, 173, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_contact_relation` VALUES (181, 167, 174, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_contact_relation` VALUES (182, 169, 175, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_contact_relation` VALUES (183, 174, 176, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_contact_relation` VALUES (184, 176, 177, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_contact_relation` VALUES (185, 179, 178, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_contact_relation` VALUES (186, 180, 179, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_contact_relation` VALUES (187, 181, 180, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_contact_relation` VALUES (188, 182, 181, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_contact_relation` VALUES (189, 185, 182, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_contact_relation` VALUES (190, 186, 183, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_contact_relation` VALUES (191, 187, 184, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_extend
-- ----------------------------
DROP TABLE IF EXISTS `t_house_extend`;
CREATE TABLE `t_house_extend`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `template_data` json NOT NULL COMMENT '房源类型模板数据',
  `area_id` int(5) UNSIGNED NULL DEFAULT NULL COMMENT ' ',
  `prove` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'X' COMMENT '邦认证;A：认证\r\n X：未认证\r\n',
  `commend` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'X' COMMENT '邦推荐;A：推荐\r\n            X：不推荐',
  `grade` double(3, 1) UNSIGNED NULL DEFAULT NULL COMMENT '评分',
  `like_count` int(7) UNSIGNED NULL DEFAULT 0 COMMENT '点赞数',
  `sale_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'A' COMMENT '销售类型(域);A:分销\r\n            B:直销',
  `price_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'B' COMMENT '价格类型(域);A:砍价\r\n            B:一口价',
  `rent_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'B' COMMENT '租赁状态(域)',
  `decorate` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修情况(域)',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `enterprise` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入驻企业',
  `house_date` date NULL DEFAULT NULL COMMENT '办公室类别不填',
  `max_price` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '除办公室外的房源类型的价格为区间，其中的办公室的最高价格',
  `min_price` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '除办公室外的房源类型的价格为区间，其中的办公室的最高价格',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 222 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_extend
-- ----------------------------
INSERT INTO `t_house_extend` VALUES (195, '{\"network\": \"移动\", \"elevator\": \"99个\", \"property\": \"高格\", \"parkingSpot\": \"10个\", \"propertyPrice\": \"20园\", \"totalHouseNum\": \"99\", \"parkingSpotPrice\": \"20园\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '共享办公', '众马科技、白马科技、黑马科技', '2020-03-18', 3.92, 0.00, NULL, NULL, NULL, '2020-03-18 09:39:08', '2020-03-26 13:13:29', 'A');
INSERT INTO `t_house_extend` VALUES (196, '{\"network\": \"移动\", \"elevator\": \"99\", \"property\": \"信达物业\", \"Electricity\": \"面谈\", \"parkingSpot\": \"2000\", \"propertyPrice\": \"4.8\", \"totalHouseNum\": \"106\", \"parkingSpotPrice\": \"560元/月/个\"}', 2, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '地理位置优越，交通便利', '中国工商银行、中国移动、中国平安、中国石油', '2020-03-17', 0.00, 0.00, NULL, NULL, NULL, '2020-03-18 09:46:25', '2020-03-26 13:13:36', 'A');
INSERT INTO `t_house_extend` VALUES (197, '{\"network\": \"联通\", \"elevator\": \"客梯15\", \"property\": \"万科物业\", \"Electricity\": \"1.2\", \"parkingSpot\": \"559\", \"propertyPrice\": \"5.98\", \"totalHouseNum\": \"74\", \"parkingSpotPrice\": \"月卡550\"}', 3, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '----', '-', '2020-03-18', 3.20, 0.00, NULL, NULL, NULL, '2020-03-18 09:58:33', '2020-03-26 13:13:32', 'A');
INSERT INTO `t_house_extend` VALUES (198, '{\"deposit\": \"-\", \"officePattern\": \"-\", \"checkHouseTime\": \"-\", \"minTenancyTerm\": \"-\", \"rentFreePeriod\": \"-\", \"earliestRentTime\": \"-\"}', 3, 'X', 'X', NULL, 1, 'A', 'B', 'B', 'A', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-18 11:00:52', '2020-03-26 13:13:42', 'A');
INSERT INTO `t_house_extend` VALUES (199, '{\"deposit\": \"-\", \"officePattern\": \"-\", \"checkHouseTime\": \"-\", \"minTenancyTerm\": \"-\", \"rentFreePeriod\": \"-\", \"earliestRentTime\": \"-\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', 'C', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-18 11:54:08', '2020-03-26 13:13:34', 'A');
INSERT INTO `t_house_extend` VALUES (201, '{\"deposit\": \"-\", \"officePattern\": \"-\", \"checkHouseTime\": \"-\", \"minTenancyTerm\": \"-\", \"rentFreePeriod\": \"-\", \"earliestRentTime\": \"-\"}', 1, 'A', 'A', NULL, 2, 'B', 'A', 'B', 'A', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-19 13:35:10', '2020-03-26 13:13:16', 'A');
INSERT INTO `t_house_extend` VALUES (207, '{\"network\": \"-\", \"elevator\": \"电梯3部\", \"property\": \"*自持物业\", \"Electricity\": \"-\", \"parkingSpot\": \"*800个\", \"propertyPrice\": \"4.5元/月/平方米\", \"totalHouseNum\": \"1000\", \"parkingSpotPrice\": \"300/月\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '', '南京众创餐饮管理有限公司', '2016-06-30', 0.95, 0.00, NULL, NULL, NULL, '2020-03-24 09:07:46', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_extend` VALUES (209, '{\"deposit\": \"500元\", \"officePattern\": \"-\", \"checkHouseTime\": \"随时\", \"minTenancyTerm\": \"3个月\", \"rentFreePeriod\": \"1个月\", \"earliestRentTime\": \"现在\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', 'E', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_extend` VALUES (213, '{\"deposit\": \"-\", \"officePattern\": \"-\", \"checkHouseTime\": \"-\", \"minTenancyTerm\": \"-\", \"rentFreePeriod\": \"-\", \"earliestRentTime\": \"-\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', 'B', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 11:05:59', '2020-03-26 13:13:08', 'A');
INSERT INTO `t_house_extend` VALUES (214, '{}', 1, 'X', 'X', NULL, 0, 'A', 'B', '', 'A', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_extend` VALUES (215, '{}', 1, 'X', 'X', NULL, 0, 'A', 'B', '', 'A', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_extend` VALUES (216, '{\"network\": \"-\", \"elevator\": \"-\", \"property\": \"-\", \"parkingSpot\": \"-\", \"propertyPrice\": \"-\", \"totalHouseNum\": \"-\", \"parkingSpotPrice\": \"-\"}', 12, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '', '绿地集团南京宝地置业有限公司，南京乾程置业有限公司，江苏海昇新能源集团有限公司，南京瀚瑞装饰集团有限公司，南京亦鑫同电气有限责任公司', '2017-03-30', 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_extend` VALUES (219, '{}', 1, 'X', 'X', NULL, 0, 'A', 'B', '', 'B', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_extend` VALUES (220, '{}', 1, 'X', 'X', NULL, 0, 'A', 'B', '', 'A', '', '', NULL, 0.00, 0.00, NULL, NULL, NULL, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_extend` VALUES (221, '{\"network\": \"-\", \"elevator\": \"-\", \"property\": \"上理大科技园区物业\", \"parkingSpot\": \"地上200，地下300\", \"propertyPrice\": \"3.5/平/月\", \"totalHouseNum\": \"100\", \"parkingSpotPrice\": \"-\"}', 1, 'X', 'X', NULL, 0, 'A', 'B', 'B', '', '', '江宁丰盛医疗科技有限公司、 光一科技股份有限公司', '2017-06-10', 0.00, 0.00, NULL, NULL, NULL, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_facility_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_house_facility_relation`;
CREATE TABLE `t_house_facility_relation`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL,
  `facility_id` int(5) UNSIGNED NOT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_facility_relation
-- ----------------------------
INSERT INTO `t_house_facility_relation` VALUES (73, 164, 4, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (74, 164, 5, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (75, 164, 6, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (76, 164, 1, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (77, 164, 2, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (78, 164, 3, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (79, 165, 6, '2020-03-18 09:58:33', '2020-03-18 09:58:33', 'A');
INSERT INTO `t_house_facility_relation` VALUES (80, 169, 5, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_facility_relation` VALUES (81, 169, 6, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_facility_relation` VALUES (82, 169, 4, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_facility_relation` VALUES (83, 174, 1, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (84, 174, 2, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (85, 174, 3, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (86, 174, 4, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (87, 174, 5, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (88, 174, 6, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_facility_relation` VALUES (89, 176, 5, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_facility_relation` VALUES (90, 176, 1, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_facility_relation` VALUES (91, 176, 6, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_facility_relation` VALUES (92, 179, 2, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_facility_relation` VALUES (93, 179, 1, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_facility_relation` VALUES (94, 179, 5, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_facility_relation` VALUES (95, 180, 1, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (96, 180, 5, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (97, 180, 6, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_facility_relation` VALUES (98, 181, 1, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_facility_relation` VALUES (99, 181, 4, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_facility_relation` VALUES (100, 181, 5, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_facility_relation` VALUES (101, 182, 1, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_facility_relation` VALUES (102, 182, 6, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_facility_relation` VALUES (103, 182, 5, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_facility_relation` VALUES (104, 185, 1, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (105, 185, 2, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (106, 185, 3, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (107, 185, 4, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (108, 185, 5, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (109, 185, 6, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_facility_relation` VALUES (110, 186, 1, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_facility_relation` VALUES (111, 186, 5, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_facility_relation` VALUES (112, 186, 6, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_facility_relation` VALUES (113, 187, 6, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_facility_relation` VALUES (114, 187, 5, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_facility_relation` VALUES (115, 187, 4, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_facility_relation` VALUES (116, 187, 3, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_facility_relation` VALUES (117, 187, 2, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_facility_relation` VALUES (118, 187, 1, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_metro_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_house_metro_relation`;
CREATE TABLE `t_house_metro_relation`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `metro_position_id` int(6) UNSIGNED NOT NULL COMMENT '地铁站点标识',
  `distance` int(6) UNSIGNED NULL DEFAULT 0 COMMENT '距离',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 141 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_metro_relation
-- ----------------------------
INSERT INTO `t_house_metro_relation` VALUES (126, 163, 1, 55, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_metro_relation` VALUES (127, 164, 31, 66, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_metro_relation` VALUES (128, 165, 56, 900, '2020-03-18 09:58:33', '2020-03-18 09:58:33', 'A');
INSERT INTO `t_house_metro_relation` VALUES (129, 166, 56, 900, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_metro_relation` VALUES (130, 167, 1, 55, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_metro_relation` VALUES (131, 169, 1, 55, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_metro_relation` VALUES (132, 174, 18, 1000, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_metro_relation` VALUES (133, 176, 18, 1000, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_metro_relation` VALUES (134, 179, 18, 1000, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_metro_relation` VALUES (135, 180, 2, 1000, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_metro_relation` VALUES (136, 181, 2, 1000, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_metro_relation` VALUES (137, 182, 75, 600, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_metro_relation` VALUES (138, 185, 2, 600, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_metro_relation` VALUES (139, 186, 2, 600, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');
INSERT INTO `t_house_metro_relation` VALUES (140, 187, 100, 2000, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_house_photo`;
CREATE TABLE `t_house_photo`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL DEFAULT 0 COMMENT '房源标识',
  `photo_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片名',
  `access_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件访问路径',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片类型(域)',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT 'A:有效\r\n            X:无效\r\n            W:临时',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 264 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_photo
-- ----------------------------
INSERT INTO `t_house_photo` VALUES (221, 163, '393a178e6a740b797c37335aa0e430ba_20170314_2641ea2080700aec915ax95s4ul191zp_sp.png', '/house_upload/homePage/20200318093906_393a178e6a740b797c37335aa0e430ba_20170314_2641ea2080700aec915ax95s4ul191zp_sp.png', 'A', 'A', '2020-03-18 09:39:06');
INSERT INTO `t_house_photo` VALUES (222, 164, '大厦.png', '/house_upload/homePage/20200318094623_大厦.png', 'A', 'A', '2020-03-18 09:46:23');
INSERT INTO `t_house_photo` VALUES (223, 165, '1 (1).png', '/house_upload/homePage/20200318095831_1 (1).png', 'A', 'A', '2020-03-18 09:58:31');
INSERT INTO `t_house_photo` VALUES (224, 166, '1 (2).jpg', '/house_upload/homePage/20200318110021_1 (2).jpg', 'A', 'A', '2020-03-18 11:00:21');
INSERT INTO `t_house_photo` VALUES (225, 167, '1 (3).png', '/house_upload/homePage/20200318115406_1 (3).png', 'A', 'A', '2020-03-18 11:54:06');
INSERT INTO `t_house_photo` VALUES (226, 169, '1 (1).jpg', '/house_upload/homePage/20200319133507_1 (1).jpg', 'A', 'A', '2020-03-19 13:35:07');
INSERT INTO `t_house_photo` VALUES (227, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.SgwMn6D7gDXZ86c3271ca3790e5c76ef87a00e4c797a.png', '/house_upload/homePage/20200323174312_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.SgwMn6D7gDXZ86c3271ca3790e5c76ef87a00e4c797a.png', 'A', 'W', '2020-03-23 17:43:12');
INSERT INTO `t_house_photo` VALUES (228, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.GBz7RzoIzZk486c3271ca3790e5c76ef87a00e4c797a.png', '/house_upload/appearance/20200323174314_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.GBz7RzoIzZk486c3271ca3790e5c76ef87a00e4c797a.png', 'B', 'W', '2020-03-23 17:43:14');
INSERT INTO `t_house_photo` VALUES (229, 0, 'wx5d1cf92dcd2c6ee4.o6zAJs-E9DplFDlUdpBVebQck-Is.menKytGTgojp7d370d92b0f98f29729e2e26b7177621.png', '/house_upload/homePage/20200323174659_wx5d1cf92dcd2c6ee4.o6zAJs-E9DplFDlUdpBVebQck-Is.menKytGTgojp7d370d92b0f98f29729e2e26b7177621.png', 'A', 'W', '2020-03-23 17:46:59');
INSERT INTO `t_house_photo` VALUES (230, 174, 's_59c673aa08948.jpg', '/house_upload/homePage/20200324090709_s_59c673aa08948.jpg', 'A', 'A', '2020-03-24 09:07:09');
INSERT INTO `t_house_photo` VALUES (231, 174, 's_59c673aa08948.jpg', '/house_upload/appearance/20200324090715_s_59c673aa08948.jpg', 'B', 'A', '2020-03-24 09:07:15');
INSERT INTO `t_house_photo` VALUES (232, 174, 's_59c673aa08948.jpg', '/house_upload/publicArea/20200324090722_s_59c673aa08948.jpg', 'C', 'A', '2020-03-24 09:07:22');
INSERT INTO `t_house_photo` VALUES (233, 174, 's_59c673aa08948.jpg', '/house_upload/surrounding/20200324090729_s_59c673aa08948.jpg', 'D', 'A', '2020-03-24 09:07:29');
INSERT INTO `t_house_photo` VALUES (234, 174, 's_59c673aa08948.jpg', '/house_upload/other/20200324090737_s_59c673aa08948.jpg', 'E', 'A', '2020-03-24 09:07:37');
INSERT INTO `t_house_photo` VALUES (235, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.zx7UF5GEL5i52e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324091254_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.zx7UF5GEL5i52e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'W', '2020-03-24 09:12:54');
INSERT INTO `t_house_photo` VALUES (236, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.i3FYQoMhuAjO2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324091305_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.i3FYQoMhuAjO2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'W', '2020-03-24 09:13:06');
INSERT INTO `t_house_photo` VALUES (237, 176, 's_59c673aa08948.jpg', '/house_upload/appearance/20200324091934_s_59c673aa08948.jpg', 'B', 'A', '2020-03-24 09:19:34');
INSERT INTO `t_house_photo` VALUES (238, 176, 's_59c673aa08948.jpg', '/house_upload/homePage/20200324092310_s_59c673aa08948.jpg', 'A', 'A', '2020-03-24 09:23:10');
INSERT INTO `t_house_photo` VALUES (239, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.GMggVXwh2cIJ2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324094958_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.GMggVXwh2cIJ2e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'W', '2020-03-24 09:49:58');
INSERT INTO `t_house_photo` VALUES (240, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.DtJ3OmpYxYGT2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324095006_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.DtJ3OmpYxYGT2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'W', '2020-03-24 09:50:07');
INSERT INTO `t_house_photo` VALUES (241, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.v2PbEppa7vGr2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324101207_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.v2PbEppa7vGr2e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'W', '2020-03-24 10:12:07');
INSERT INTO `t_house_photo` VALUES (242, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.0bIix8w94nZU2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324101220_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.0bIix8w94nZU2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'W', '2020-03-24 10:12:20');
INSERT INTO `t_house_photo` VALUES (243, 179, 's_59c673aa08948.jpg', '/house_upload/homePage/20200324110541_s_59c673aa08948.jpg', 'A', 'A', '2020-03-24 11:05:41');
INSERT INTO `t_house_photo` VALUES (244, 179, 's_59c673aa08948.jpg', '/house_upload/appearance/20200324110546_s_59c673aa08948.jpg', 'B', 'A', '2020-03-24 11:05:46');
INSERT INTO `t_house_photo` VALUES (245, 180, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.gzlKW0OregNa2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324110804_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.gzlKW0OregNa2e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'A', '2020-03-24 11:08:04');
INSERT INTO `t_house_photo` VALUES (246, 180, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.JWYK2ppNfXXm2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324110816_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.JWYK2ppNfXXm2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'A', '2020-03-24 11:08:16');
INSERT INTO `t_house_photo` VALUES (247, 180, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.cukBh9wJhqbK2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324110816_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.cukBh9wJhqbK2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'A', '2020-03-24 11:08:16');
INSERT INTO `t_house_photo` VALUES (248, 181, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.1qcFuxggriH52e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324112826_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.1qcFuxggriH52e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'A', '2020-03-24 11:28:26');
INSERT INTO `t_house_photo` VALUES (249, 181, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.gLrYvtNPpxxM2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324112832_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.gLrYvtNPpxxM2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'A', '2020-03-24 11:28:32');
INSERT INTO `t_house_photo` VALUES (250, 182, 's_59c673aa08948.jpg', '/house_upload/homePage/20200324145228_s_59c673aa08948.jpg', 'A', 'A', '2020-03-24 14:52:28');
INSERT INTO `t_house_photo` VALUES (251, 182, 's_59c673aa08948.jpg', '/house_upload/appearance/20200324145236_s_59c673aa08948.jpg', 'B', 'A', '2020-03-24 14:52:36');
INSERT INTO `t_house_photo` VALUES (252, 182, 's_5a0112001d48b.jpg', '/house_upload/publicArea/20200324145321_s_5a0112001d48b.jpg', 'C', 'A', '2020-03-24 14:53:21');
INSERT INTO `t_house_photo` VALUES (253, 182, 's_5a0112001d48b.jpg', '/house_upload/surrounding/20200324145328_s_5a0112001d48b.jpg', 'D', 'A', '2020-03-24 14:53:28');
INSERT INTO `t_house_photo` VALUES (254, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.HYeYOiHarC4B914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/homePage/20200324145653_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.HYeYOiHarC4B914d76c6c45a9801240927a9a296a63c.jpg', 'A', 'W', '2020-03-24 14:56:53');
INSERT INTO `t_house_photo` VALUES (255, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.zfTL43pvD5xy914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/appearance/20200324145655_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.zfTL43pvD5xy914d76c6c45a9801240927a9a296a63c.jpg', 'B', 'W', '2020-03-24 14:56:55');
INSERT INTO `t_house_photo` VALUES (256, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.fehSBVhVDqHG914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/homePage/20200324151006_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.fehSBVhVDqHG914d76c6c45a9801240927a9a296a63c.jpg', 'A', 'W', '2020-03-24 15:10:07');
INSERT INTO `t_house_photo` VALUES (257, 0, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.PC2ecRfVcyqE914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/appearance/20200324151015_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.PC2ecRfVcyqE914d76c6c45a9801240927a9a296a63c.jpg', 'B', 'W', '2020-03-24 15:10:15');
INSERT INTO `t_house_photo` VALUES (258, 185, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.6CKolLuB6LrM914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/homePage/20200324151554_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.6CKolLuB6LrM914d76c6c45a9801240927a9a296a63c.jpg', 'A', 'A', '2020-03-24 15:15:54');
INSERT INTO `t_house_photo` VALUES (259, 185, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.J84tsPEGqn7A914d76c6c45a9801240927a9a296a63c.jpg', '/house_upload/appearance/20200324151601_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.J84tsPEGqn7A914d76c6c45a9801240927a9a296a63c.jpg', 'B', 'A', '2020-03-24 15:16:01');
INSERT INTO `t_house_photo` VALUES (260, 186, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.2QLSz1NEFLvi2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/homePage/20200324154804_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.2QLSz1NEFLvi2e747ef5ca68035f8bba4574d6185b77.jpg', 'A', 'A', '2020-03-24 15:48:04');
INSERT INTO `t_house_photo` VALUES (261, 186, 'wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.9asL4ChsuD3e2e747ef5ca68035f8bba4574d6185b77.jpg', '/house_upload/appearance/20200324154810_wx5d1cf92dcd2c6ee4.o6zAJsxv1JPEs9pnWSxuplKMex8o.9asL4ChsuD3e2e747ef5ca68035f8bba4574d6185b77.jpg', 'B', 'A', '2020-03-24 15:48:10');
INSERT INTO `t_house_photo` VALUES (262, 187, 's_5da6a8998ad1a.jpg', '/house_upload/homePage/20200402093404_s_5da6a8998ad1a.jpg', 'A', 'A', '2020-04-02 09:34:04');
INSERT INTO `t_house_photo` VALUES (263, 187, 's_5da6a8998ad1a.jpg', '/house_upload/appearance/20200402093410_s_5da6a8998ad1a.jpg', 'B', 'A', '2020-04-02 09:34:10');

-- ----------------------------
-- Table structure for t_house_system
-- ----------------------------
DROP TABLE IF EXISTS `t_house_system`;
CREATE TABLE `t_house_system`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `p_house_id` int(7) UNSIGNED NOT NULL COMMENT '父级房源标识',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_system
-- ----------------------------
INSERT INTO `t_house_system` VALUES (123, 166, 165, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_system` VALUES (124, 167, 163, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_system` VALUES (126, 169, 163, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_system` VALUES (132, 176, 174, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_system` VALUES (135, 179, 174, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_system` VALUES (136, 180, 174, '2020-03-24 11:08:25', '2020-03-24 11:08:25', 'A');
INSERT INTO `t_house_system` VALUES (137, 181, 164, '2020-03-24 11:28:36', '2020-03-24 11:28:36', 'A');
INSERT INTO `t_house_system` VALUES (140, 185, 182, '2020-03-24 15:16:07', '2020-03-24 15:16:07', 'A');
INSERT INTO `t_house_system` VALUES (141, 186, 174, '2020-03-24 15:48:19', '2020-03-24 15:48:19', 'A');

-- ----------------------------
-- Table structure for t_house_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_house_tag_relation`;
CREATE TABLE `t_house_tag_relation`  (
  `id` int(7) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `tag_id` int(5) UNSIGNED NOT NULL COMMENT '标签标识',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 397 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_tag_relation
-- ----------------------------
INSERT INTO `t_house_tag_relation` VALUES (331, 163, 4, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (332, 163, 11, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (333, 163, 12, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (334, 163, 5, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (335, 163, 16, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (336, 163, 8, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (337, 163, 6, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (338, 163, 13, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (339, 163, 14, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (340, 163, 15, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (341, 163, 7, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (342, 163, 9, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (343, 163, 10, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (344, 163, 17, '2020-03-18 09:39:08', '2020-03-18 09:39:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (345, 164, 4, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (346, 164, 11, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (347, 164, 5, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (348, 164, 12, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (349, 164, 6, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (350, 164, 13, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (351, 164, 7, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (352, 164, 14, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (353, 164, 8, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (354, 164, 15, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (355, 164, 9, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (356, 164, 16, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (357, 164, 10, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (358, 164, 17, '2020-03-18 09:46:25', '2020-03-18 09:46:25', 'A');
INSERT INTO `t_house_tag_relation` VALUES (359, 166, 5, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (360, 166, 12, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (361, 166, 14, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (362, 166, 7, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (363, 166, 8, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (364, 166, 15, '2020-03-18 11:00:52', '2020-03-18 11:00:52', 'A');
INSERT INTO `t_house_tag_relation` VALUES (365, 167, 4, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (366, 167, 11, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (367, 167, 12, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (368, 167, 5, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (369, 167, 6, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (370, 167, 13, '2020-03-18 11:54:08', '2020-03-18 11:54:08', 'A');
INSERT INTO `t_house_tag_relation` VALUES (371, 169, 12, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (372, 169, 4, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (373, 169, 5, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (374, 169, 6, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (375, 169, 14, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (376, 169, 13, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (377, 169, 11, '2020-03-19 13:35:10', '2020-03-19 13:35:10', 'A');
INSERT INTO `t_house_tag_relation` VALUES (378, 174, 4, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_tag_relation` VALUES (379, 174, 12, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_tag_relation` VALUES (380, 174, 5, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_tag_relation` VALUES (381, 174, 7, '2020-03-24 09:07:46', '2020-03-24 09:07:46', 'A');
INSERT INTO `t_house_tag_relation` VALUES (382, 176, 4, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_tag_relation` VALUES (383, 176, 11, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_tag_relation` VALUES (384, 176, 12, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_tag_relation` VALUES (385, 176, 6, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_tag_relation` VALUES (386, 176, 13, '2020-03-24 09:23:17', '2020-03-24 09:23:17', 'A');
INSERT INTO `t_house_tag_relation` VALUES (387, 179, 13, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_tag_relation` VALUES (388, 179, 5, '2020-03-24 11:05:59', '2020-03-24 11:05:59', 'A');
INSERT INTO `t_house_tag_relation` VALUES (389, 182, 4, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_tag_relation` VALUES (390, 182, 12, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_tag_relation` VALUES (391, 182, 13, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_tag_relation` VALUES (392, 182, 11, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_tag_relation` VALUES (393, 182, 9, '2020-03-24 14:53:31', '2020-03-24 14:53:31', 'A');
INSERT INTO `t_house_tag_relation` VALUES (394, 187, 4, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_tag_relation` VALUES (395, 187, 5, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');
INSERT INTO `t_house_tag_relation` VALUES (396, 187, 6, '2020-04-02 09:34:13', '2020-04-02 09:34:13', 'A');

-- ----------------------------
-- Table structure for t_house_type
-- ----------------------------
DROP TABLE IF EXISTS `t_house_type`;
CREATE TABLE `t_house_type`  (
  `id` int(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名称',
  `type_key` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house_type
-- ----------------------------
INSERT INTO `t_house_type` VALUES (1, '写字楼', 'A', '2019-12-04 15:36:33', '2019-12-05 09:43:18', 'A');
INSERT INTO `t_house_type` VALUES (2, '开发区', 'B', '2019-12-04 15:36:33', '2019-12-05 09:43:20', 'A');
INSERT INTO `t_house_type` VALUES (3, '创意园区', 'C', '2019-12-04 15:36:33', '2019-12-05 09:43:21', 'A');
INSERT INTO `t_house_type` VALUES (4, '共享空间', 'C', '2019-12-04 15:36:33', '2019-12-05 09:43:22', 'A');
INSERT INTO `t_house_type` VALUES (5, '办公室', 'D', '2019-12-04 15:36:33', '2019-12-05 09:43:24', 'A');

-- ----------------------------
-- Table structure for t_metro
-- ----------------------------
DROP TABLE IF EXISTS `t_metro`;
CREATE TABLE `t_metro`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '线路',
  `seq` int(2) UNSIGNED NOT NULL COMMENT '序号',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_metro
-- ----------------------------
INSERT INTO `t_metro` VALUES (1, '1号线', 1, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (2, '2号线', 2, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (3, '3号线', 3, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (4, '10号线', 4, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (5, 'S1号线(机场线)', 5, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (6, 'S8号线(宁天城际)', 6, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (7, '4号线', 7, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (8, 'S3号线(宁和城际)', 8, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (9, 'S9号线(宁高线)', 9, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');
INSERT INTO `t_metro` VALUES (10, 'S7号线(宁溧城际)', 10, '2020-01-02 14:49:54', '2020-01-02 14:49:54', 'A');

-- ----------------------------
-- Table structure for t_metro_position
-- ----------------------------
DROP TABLE IF EXISTS `t_metro_position`;
CREATE TABLE `t_metro_position`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `metro_id` int(6) UNSIGNED NOT NULL COMMENT '地铁标识',
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '站点名称',
  `seq` int(2) UNSIGNED NULL DEFAULT NULL COMMENT '序号',
  `longitude` decimal(10, 7) NOT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NOT NULL COMMENT '纬度',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 175 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_metro_position
-- ----------------------------
INSERT INTO `t_metro_position` VALUES (1, 1, '迈皋桥', 1, 118.8160334, 32.1089692, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (2, 1, '红山动物园', 2, 118.8084611, 32.1021168, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (3, 1, '南京站', 3, 118.8029404, 32.0956849, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (4, 1, '新模范马路', 4, 118.7902777, 32.0861280, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (5, 1, '玄武门', 5, 118.7907346, 32.0765071, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (6, 1, '鼓楼', 6, 118.7902720, 32.0651430, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (7, 1, '珠江路', 7, 118.7906620, 32.0573270, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (8, 1, '新街口', 8, 118.7906110, 32.0476160, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (9, 1, '张府园', 9, 118.7904270, 32.0372200, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (10, 1, '三山街', 10, 118.7881350, 32.0290640, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (11, 1, '中华门', 11, 118.7811610, 32.0130230, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (12, 1, '安德门', 12, 118.7684080, 31.9971110, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (13, 1, '天隆寺', 13, 118.7696510, 31.9851920, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (14, 1, '软件大道', 14, 118.7810380, 31.9832700, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (15, 1, '花神庙', 15, 118.7920220, 31.9841430, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (16, 1, '南京南站', 16, 118.8038210, 31.9760950, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (17, 1, '双龙大道', 17, 118.8236120, 31.9702040, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (18, 1, '河定桥', 18, 118.8266400, 31.9582530, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (19, 1, '胜太路', 19, 118.8280620, 31.9499700, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (20, 1, '百家湖', 20, 118.8277210, 31.9380660, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (21, 1, '小龙湾', 21, 118.8393810, 31.9356980, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (22, 1, '竹山路', 22, 118.8511330, 31.9377400, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (23, 1, '天印大道', 23, 118.8700620, 31.9433810, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (24, 1, '龙眠大道', 24, 118.8835760, 31.9457340, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (25, 1, '南医大·江苏经贸学院站', 25, 118.8967760, 31.9398780, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (26, 1, '南京交院', 26, 118.9110770, 31.9192590, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (27, 1, '中国药科大学', 27, 118.9204910, 31.9040840, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (28, 2, '油坊桥', 1, 118.7269200, 31.9720370, '2020-01-02 14:52:59', '2020-01-03 14:22:45', 'A');
INSERT INTO `t_metro_position` VALUES (29, 2, '雨润大街', 2, 118.7292090, 31.9894060, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (30, 2, '元通', 3, 118.7280410, 32.0016330, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (31, 2, '奥体东', 4, 118.7357570, 32.0104390, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (32, 2, '兴隆大街', 5, 118.7426280, 32.0211830, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (33, 2, '集庆门大街', 6, 118.7461340, 32.0341660, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (34, 2, '云锦路', 7, 118.7539930, 32.0407200, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (35, 2, '莫愁湖', 8, 118.7653180, 32.0435150, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (36, 2, '汉中门', 9, 118.7735500, 32.0486710, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (37, 2, '上海路', 10, 118.7825210, 32.0483160, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (38, 2, '新街口', 11, 118.7906110, 32.0476160, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (39, 2, '大行宫', 12, 118.8012170, 32.0477380, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (40, 2, '西安门', 13, 118.8121280, 32.0465380, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (41, 2, '明故宫', 14, 118.8258830, 32.0453740, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (42, 2, '苜蓿园', 15, 118.8416250, 32.0459510, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (43, 2, '下马坊', 16, 118.8550490, 32.0432080, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (44, 2, '孝陵卫', 17, 118.8649290, 32.0411240, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (45, 2, '钟灵街', 18, 118.8759800, 32.0448720, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (46, 2, '马群', 19, 118.9010530, 32.0557350, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (47, 2, '金马路', 20, 118.9124350, 32.0778170, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (48, 2, '仙鹤门', 21, 118.9113310, 32.0911480, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (49, 2, '学则路', 22, 118.9232780, 32.0977120, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (50, 2, '仙林中心', 23, 118.9368540, 32.1051070, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (51, 2, '羊山公园', 24, 118.9465320, 32.1100630, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (52, 2, '南大仙林校区', 25, 118.9658550, 32.1146260, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (53, 2, '经天路', 26, 118.9832540, 32.1218530, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (54, 3, '林场', 1, 118.6777800, 32.1699470, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (55, 3, '星火路', 2, 118.7031420, 32.1637950, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (56, 3, '东大成贤学院', 3, 118.7143110, 32.1624680, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (57, 3, '泰冯路', 4, 118.7249860, 32.1597610, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (58, 3, '天润城', 5, 118.7405990, 32.1565360, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (59, 3, '柳洲东路', 6, 118.7528490, 32.1457760, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (60, 3, '上元门', 7, 118.7763940, 32.1216030, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (61, 3, '五塘广场', 8, 118.7841050, 32.1166820, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (62, 3, '小市', 9, 118.7920620, 32.1010590, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (63, 3, '南京站', 10, 118.8029210, 32.0954230, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (64, 3, '南京林业大学·新庄', 11, 118.8167480, 32.0829030, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (65, 3, '鸡鸣寺', 12, 118.8041670, 32.0636990, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (66, 3, '浮桥', 13, 118.8027620, 32.0557220, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (67, 3, '大行宫', 14, 118.8012170, 32.0477380, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (68, 3, '常府街', 15, 118.7987840, 32.0400210, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (69, 3, '夫子庙', 16, 118.7974440, 32.0303710, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (70, 3, '武定门', 17, 118.8010550, 32.0200700, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (71, 3, '雨花门', 18, 118.7987380, 32.0102600, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (72, 3, '卡子门', 19, 118.8019170, 32.0012970, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (73, 3, '大明路', 20, 118.8065730, 31.9922960, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (74, 3, '明发广场', 21, 118.8069520, 31.9835210, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (75, 3, '南京南站', 22, 118.8038210, 31.9760950, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (76, 3, '宏运大道', 23, 118.8101870, 31.9658240, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (77, 3, '胜太西路', 24, 118.8139190, 31.9501360, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (78, 3, '天元西路', 25, 118.8150210, 31.9344490, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (79, 3, '九龙湖', 26, 118.8275940, 31.9220630, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (80, 3, '诚信大道', 27, 118.8364800, 31.9139080, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (81, 3, '东大九龙湖校区', 28, 118.8370390, 31.9020580, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (82, 3, '秣周东路', 29, 118.8377940, 31.8749860, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (83, 4, '安德门', 1, 118.7684080, 31.9971110, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (84, 4, '小行', 2, 118.7509650, 31.9880610, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (85, 4, '中胜', 3, 118.7400780, 31.9938630, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (86, 4, '元通', 4, 118.7280410, 32.0016330, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (87, 4, '奥体中心', 5, 118.7246480, 32.0146410, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (88, 4, '梦都大街', 6, 118.7284960, 32.0216220, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (89, 4, '绿博园', 7, 118.7238640, 32.0300420, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (90, 4, '江心洲', 8, 118.7100730, 32.0385410, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (91, 4, '临江路', 9, 118.6712290, 32.0645540, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (92, 4, '浦口万汇城', 10, 118.6631240, 32.0680900, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (93, 4, '南京工业大学', 11, 118.6546240, 32.0728230, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (94, 4, '龙华路', 12, 118.6419060, 32.0704100, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (95, 4, '文德路', 13, 118.6334060, 32.0631930, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (96, 4, '雨山路', 14, 118.6218600, 32.0502210, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (97, 5, '南京南站', 1, 118.8038210, 31.9760950, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (98, 5, '翠屏山', 2, 118.7911000, 31.9487940, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (99, 5, '佛城西路', 3, 118.7977490, 31.9205940, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (100, 5, '吉印大道', 4, 118.8019180, 31.8924950, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (101, 5, '正方中路', 5, 118.8122520, 31.8516860, '2020-01-02 14:52:59', '2020-01-03 14:22:46', 'A');
INSERT INTO `t_metro_position` VALUES (102, 5, '翔宇路北', 6, 118.8281270, 31.7978270, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (103, 5, '翔宇路南', 7, 118.8356330, 31.7608410, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (104, 5, '禄口机场', 8, 118.8798020, 31.7361390, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (105, 6, '泰山新村', 1, 118.7225530, 32.1505720, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (106, 6, '泰冯路', 2, 118.7249860, 32.1597610, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (107, 6, '高新开发区', 3, 118.7262220, 32.1836690, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (108, 6, '信息工程大学', 4, 118.7336420, 32.2085350, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (109, 6, '卸甲甸', 5, 118.7373020, 32.2204260, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (110, 6, '大厂', 6, 118.7466460, 32.2346170, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (111, 6, '葛塘', 7, 118.7602480, 32.2502440, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (112, 6, '长芦', 8, 118.7831790, 32.2796290, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (113, 6, '化工园', 9, 118.7921260, 32.2918460, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (114, 6, '六合开发区', 10, 118.8115020, 32.3115370, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (115, 6, '龙池', 11, 118.8268630, 32.3252180, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (116, 6, '雄州', 12, 118.8433070, 32.3405350, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (117, 6, '凤凰山公园', 13, 118.8517490, 32.3527230, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (118, 6, '方州广场', 14, 118.8564960, 32.3648410, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (119, 6, '沈桥', 15, 118.8981640, 32.4059590, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (120, 6, '八百桥', 16, 118.9396420, 32.4332980, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (121, 6, '金牛湖', 17, 118.9706540, 32.4708610, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (122, 7, '龙江', 1, 118.7442460, 32.0635750, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (123, 7, '南艺·二师·草场', 2, 18.7623120, 32.0663650, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (124, 7, '云南路', 3, 118.7811660, 32.0651890, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (125, 7, '鼓楼', 4, 118.7899950, 32.0650700, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (126, 7, '鸡鸣寺', 5, 118.8041670, 32.0636990, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (127, 7, '九华山', 6, 118.8123380, 32.0636880, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (128, 7, '岗子村', 7, 118.8224680, 32.0716480, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (129, 7, '蒋王庙', 8, 118.8376440, 32.0835530, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (130, 7, '王家湾', 9, 118.8445200, 32.0911050, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (131, 7, '聚宝山', 10, 118.8709620, 32.0994450, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (132, 7, '苏宁总部·徐庄', 11, 118.8956460, 32.0906370, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (133, 7, '金马路', 12, 118.9124350, 32.0778170, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (134, 7, '汇通路', 13, 118.9376400, 32.0843270, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (135, 7, '灵山', 14, 118.9509740, 32.0833570, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (136, 7, '东流', 15, 118.9709470, 32.0829510, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (137, 7, '孟北', 16, 118.9940380, 32.0900000, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (138, 7, '西岗桦墅', 17, 119.0032010, 32.1046450, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (139, 7, '仙林湖', 18, 118.9993390, 32.1312360, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (140, 8, '高家冲', 1, 118.5237510, 31.9146280, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (141, 8, '林山', 2, 118.5375200, 31.9247120, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (142, 8, '桥林新城', 3, 118.5544790, 31.9365490, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (143, 8, '石碛河', 4, 118.5644500, 31.9443400, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (144, 8, '双垅', 5, 118.5736670, 31.9544030, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (145, 8, '兰花塘', 6, 118.5811960, 31.9644060, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (146, 8, '马骡圩', 7, 118.5947510, 31.9792080, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (147, 8, '刘村', 8, 118.6715550, 31.9505820, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (148, 8, '天保', 9, 118.6841770, 31.9596280, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (149, 8, '高庙路', 10, 118.6948040, 31.9748050, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (150, 8, '吴侯街', 11, 118.6995740, 31.9817660, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (151, 8, '平良大街', 12, 118.7090920, 31.9838120, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (152, 8, '永初路', 13, 118.7186620, 31.9802660, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (153, 8, '油坊桥', 14, 118.7269200, 31.9720370, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (154, 8, '贾西', 15, 118.7404640, 31.9649890, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (155, 8, '春江路', 16, 118.7550350, 31.9681710, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (156, 8, '铁心桥', 17, 118.7701960, 31.9703660, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (157, 8, '景明佳园', 18, 118.7852090, 31.9683800, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (158, 8, '南京南站', 19, 118.8038210, 31.9760950, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (159, 9, '翔宇路南', 1, 118.8356330, 31.7608410, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (160, 9, '铜山', 2, 118.8879040, 31.7021500, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (161, 9, '石湫', 3, 118.9138010, 31.6466740, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (162, 9, '明觉', 4, 118.9085640, 31.5523000, '2020-01-02 14:52:59', '2020-01-03 14:22:47', 'A');
INSERT INTO `t_metro_position` VALUES (163, 9, '团结圩', 5, 118.8941860, 31.4017310, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (164, 9, '高淳', 6, 118.8839140, 31.3470580, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (165, 10, '空港新城江宁站', 1, 118.8940930, 31.7436280, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (166, 10, '柘塘', 2, 118.9444430, 31.7628050, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (167, 10, '空港新城溧水站', 3, 118.9960690, 31.7394620, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (168, 10, '群力', 4, 119.0207650, 31.7272290, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (169, 10, '卧龙湖', 5, 119.0495890, 31.6926950, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (170, 10, '溧水', 6, 119.0509920, 31.6686030, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (171, 10, '中山湖', 7, 119.0517160, 31.6531200, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (172, 10, '幸庄', 8, 119.0526200, 31.6310300, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (173, 10, '无想山', 9, 119.0528690, 31.6177040, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');
INSERT INTO `t_metro_position` VALUES (174, 10, '禄口机场', 10, 118.8798020, 31.7359406, '2020-01-02 14:52:59', '2020-01-03 14:22:48', 'A');

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;
CREATE TABLE `t_region`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '板块名',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_region
-- ----------------------------
INSERT INTO `t_region` VALUES (1, '百家湖', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (2, '岔路口', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (3, '淳化', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (4, '东山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (5, '湖熟', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (6, '将军大道', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (7, '江宁大学城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (8, '九龙湖', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (9, '科学院', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (10, '禄口', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (11, '秣陵', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (12, '麒麟科技城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (13, '上坊', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (14, '上峰', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (15, '汤山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (16, '土桥', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (17, '周岗', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (18, '顶山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (19, '高新区', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (20, '江浦街道', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (21, '老山珍珠泉', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (22, '浦口区其他', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (23, '桥北', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (24, '乔林新城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (25, '八卦洲', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (26, '靖安', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (27, '开发区', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (28, '龙潭', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (29, '迈皋桥', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (30, '马群', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (31, '栖霞山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (32, '摄山星城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (33, '仙林大学城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (34, '仙林湖', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (35, '晓庄', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (36, '燕子矶', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (37, '尧化门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (38, '滨江', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (39, '谷里', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (40, '横溪', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (41, '高淳区', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (42, '定淮门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (43, '凤凰西街', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (44, '福建路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (45, '华侨路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (46, '湖南路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (47, '江东', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (48, '建宁路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (49, '金陵小区', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (50, '龙江', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (51, '宁海路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (52, '热河南路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (53, '三牌楼', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (54, '水佐岗', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (55, '五塘广场', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (56, '小市', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (57, '许府巷', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (58, '挹江门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (59, '中央门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (60, '奥南', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (61, '奥体', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (62, '茶南', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (63, '江心洲', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (64, '建邺万达广场', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (65, '南湖', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (66, '南苑', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (67, '兴隆', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (68, '溧水区', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (69, '大厂', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (70, '葛塘', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (71, '六合区其他', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (72, '龙池', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (73, '雄州', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (74, '常府街', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (75, '朝天宫', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (76, '大光路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (77, '大校场', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (78, '大行宫', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (79, '夫子庙', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (80, '光华门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (81, '洪武路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (82, '淮海路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (83, '集庆路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (84, '卡子门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (85, '秦虹', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (86, '瑞金路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (87, '五老村', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (88, '新街口', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (89, '月牙湖', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (90, '长白街', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (91, '长乐路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (92, '中华门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (93, '北京东路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (94, '丹凤街', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (95, '红山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (96, '后宰门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (97, '锁金村', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (98, '卫岗', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (99, '孝陵卫', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (100, '玄武大道', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (101, '玄武门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (102, '徐庄软件园', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (103, '月苑', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (104, '长江路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (105, '珠江路', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (106, '紫金山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (107, '安德门', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (108, '板桥新城', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (109, '韩府山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (110, '梅山', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (111, '南站', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (112, '能仁里', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (113, '天保', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (114, '铁心桥', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');
INSERT INTO `t_region` VALUES (115, '西善桥', '2020-01-02 15:21:10', '2020-01-02 15:21:10', 'A');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  `reserve1` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (4, '近地铁', '2020-01-02 14:14:18', '2020-01-02 14:14:28', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (5, '周边配套齐全', '2020-01-02 14:14:40', '2020-01-02 14:17:40', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (6, '商业综合体', '2020-01-02 14:14:54', '2020-01-02 14:17:52', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (7, '整栋', '2020-01-02 14:15:05', '2020-01-02 14:18:00', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (8, '联合办公', '2020-01-02 14:18:07', '2020-01-02 14:18:07', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (9, '办公家具', '2020-01-02 14:18:14', '2020-01-02 14:18:14', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (10, '价格面议', '2020-01-02 14:18:38', '2020-01-02 14:18:38', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (11, '精装修', '2020-01-02 14:18:53', '2020-01-02 14:18:53', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (12, '独立办公室', '2020-01-02 14:19:08', '2020-01-02 14:19:08', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (13, '开放工位', '2020-01-02 14:19:15', '2020-01-02 14:19:15', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (14, '交通便利', '2020-01-02 14:19:24', '2020-01-02 14:19:24', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (15, '地标建筑', '2020-01-02 14:19:31', '2020-01-02 14:19:31', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (16, '地铁直达', '2020-01-02 14:20:23', '2020-01-02 14:20:23', 'A', NULL, NULL);
INSERT INTO `t_tag` VALUES (17, '方便停车', '2020-01-02 14:20:42', '2020-01-02 14:20:42', 'A', NULL, NULL);

-- ----------------------------
-- Table structure for t_type_filed
-- ----------------------------
DROP TABLE IF EXISTS `t_type_filed`;
CREATE TABLE `t_type_filed`  (
  `id` int(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_type_id` int(2) UNSIGNED NOT NULL COMMENT '房源类型标识',
  `field_template_id` int(6) UNSIGNED NOT NULL COMMENT '房源自定义字段模板标识',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type_filed
-- ----------------------------
INSERT INTO `t_type_filed` VALUES (12, 1, 23, '2019-12-31 15:06:06', '2019-12-31 15:06:06', 'A');
INSERT INTO `t_type_filed` VALUES (13, 1, 24, '2019-12-31 15:59:38', '2019-12-31 15:59:38', 'A');
INSERT INTO `t_type_filed` VALUES (14, 1, 25, '2019-12-31 16:00:45', '2019-12-31 16:00:45', 'A');
INSERT INTO `t_type_filed` VALUES (15, 1, 26, '2019-12-31 16:02:55', '2019-12-31 16:02:55', 'A');
INSERT INTO `t_type_filed` VALUES (16, 1, 27, '2019-12-31 16:03:48', '2019-12-31 16:03:48', 'A');
INSERT INTO `t_type_filed` VALUES (17, 1, 28, '2019-12-31 16:05:13', '2020-01-03 14:10:13', 'X');
INSERT INTO `t_type_filed` VALUES (18, 1, 29, '2019-12-31 16:05:40', '2020-01-03 14:10:26', 'X');
INSERT INTO `t_type_filed` VALUES (19, 1, 30, '2019-12-31 16:06:34', '2020-01-03 14:09:51', 'X');
INSERT INTO `t_type_filed` VALUES (20, 1, 31, '2019-12-31 16:07:50', '2019-12-31 16:07:50', 'A');
INSERT INTO `t_type_filed` VALUES (21, 1, 32, '2019-12-31 16:08:09', '2019-12-31 16:08:09', 'A');
INSERT INTO `t_type_filed` VALUES (22, 2, 23, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (24, 2, 25, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (25, 2, 26, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (26, 2, 27, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (27, 2, 28, '2019-12-31 16:18:21', '2020-01-03 14:10:13', 'X');
INSERT INTO `t_type_filed` VALUES (28, 2, 29, '2019-12-31 16:18:21', '2020-01-03 14:10:26', 'X');
INSERT INTO `t_type_filed` VALUES (29, 2, 30, '2019-12-31 16:18:21', '2020-01-03 14:09:51', 'X');
INSERT INTO `t_type_filed` VALUES (30, 2, 31, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (31, 2, 32, '2019-12-31 16:18:21', '2019-12-31 16:18:21', 'A');
INSERT INTO `t_type_filed` VALUES (32, 3, 23, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (33, 3, 24, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (34, 3, 25, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (35, 3, 26, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (36, 3, 27, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (37, 3, 28, '2019-12-31 16:18:35', '2020-01-03 14:10:13', 'X');
INSERT INTO `t_type_filed` VALUES (38, 3, 29, '2019-12-31 16:18:35', '2020-01-03 14:10:26', 'X');
INSERT INTO `t_type_filed` VALUES (39, 3, 30, '2019-12-31 16:18:35', '2020-01-03 14:09:51', 'X');
INSERT INTO `t_type_filed` VALUES (40, 3, 31, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (41, 3, 32, '2019-12-31 16:18:35', '2019-12-31 16:18:35', 'A');
INSERT INTO `t_type_filed` VALUES (42, 4, 23, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (43, 4, 33, '2019-12-31 16:18:39', '2019-12-31 16:25:04', 'A');
INSERT INTO `t_type_filed` VALUES (44, 4, 25, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (45, 4, 26, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (46, 4, 27, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (47, 4, 28, '2019-12-31 16:18:39', '2020-01-03 14:10:13', 'X');
INSERT INTO `t_type_filed` VALUES (48, 4, 29, '2019-12-31 16:18:39', '2020-01-03 14:10:26', 'X');
INSERT INTO `t_type_filed` VALUES (49, 4, 30, '2019-12-31 16:18:39', '2020-01-03 14:09:51', 'X');
INSERT INTO `t_type_filed` VALUES (50, 4, 31, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (51, 4, 32, '2019-12-31 16:18:39', '2019-12-31 16:18:39', 'A');
INSERT INTO `t_type_filed` VALUES (52, 5, 36, '2019-12-31 16:53:28', '2019-12-31 16:53:28', 'A');
INSERT INTO `t_type_filed` VALUES (53, 5, 37, '2019-12-31 16:54:46', '2019-12-31 16:54:46', 'A');
INSERT INTO `t_type_filed` VALUES (54, 5, 38, '2019-12-31 16:55:27', '2019-12-31 16:55:27', 'A');
INSERT INTO `t_type_filed` VALUES (55, 5, 39, '2019-12-31 16:56:27', '2019-12-31 16:56:27', 'A');
INSERT INTO `t_type_filed` VALUES (56, 5, 40, '2019-12-31 16:57:22', '2019-12-31 16:57:22', 'A');
INSERT INTO `t_type_filed` VALUES (57, 5, 41, '2019-12-31 16:58:12', '2019-12-31 16:58:12', 'A');
INSERT INTO `t_type_filed` VALUES (58, 1, 42, '2020-01-03 14:11:22', '2020-01-03 14:11:22', 'A');

-- ----------------------------
-- Table structure for t_user_browse_history
-- ----------------------------
DROP TABLE IF EXISTS `t_user_browse_history`;
CREATE TABLE `t_user_browse_history`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `browse_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '浏览时间',
  `user_id` int(6) UNSIGNED NOT NULL,
  `house_id` int(7) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 415 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_browse_history
-- ----------------------------
INSERT INTO `t_user_browse_history` VALUES (70, '2020-01-18 14:59:15', 169, 140);
INSERT INTO `t_user_browse_history` VALUES (71, '2020-01-18 14:59:29', 169, 140);
INSERT INTO `t_user_browse_history` VALUES (72, '2020-01-18 14:59:36', 169, 140);
INSERT INTO `t_user_browse_history` VALUES (73, '2020-03-04 19:23:42', 172, 150);
INSERT INTO `t_user_browse_history` VALUES (74, '2020-03-04 19:24:43', 172, 141);
INSERT INTO `t_user_browse_history` VALUES (75, '2020-03-04 19:24:54', 172, 150);
INSERT INTO `t_user_browse_history` VALUES (76, '2020-03-04 19:34:00', 172, 140);
INSERT INTO `t_user_browse_history` VALUES (77, '2020-03-16 13:26:20', 173, 140);
INSERT INTO `t_user_browse_history` VALUES (78, '2020-03-16 14:05:14', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (79, '2020-03-16 14:08:55', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (80, '2020-03-16 14:09:47', 173, 156);
INSERT INTO `t_user_browse_history` VALUES (81, '2020-03-16 14:09:56', 173, 151);
INSERT INTO `t_user_browse_history` VALUES (82, '2020-03-16 14:21:26', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (83, '2020-03-16 14:22:15', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (84, '2020-03-16 15:58:00', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (85, '2020-03-16 16:14:27', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (86, '2020-03-16 16:16:12', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (87, '2020-03-16 16:39:41', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (88, '2020-03-16 16:43:26', 173, 156);
INSERT INTO `t_user_browse_history` VALUES (89, '2020-03-16 17:48:06', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (90, '2020-03-16 17:55:54', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (91, '2020-03-16 18:24:56', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (92, '2020-03-16 18:25:23', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (93, '2020-03-16 18:25:32', 173, 151);
INSERT INTO `t_user_browse_history` VALUES (94, '2020-03-16 18:25:52', 173, 156);
INSERT INTO `t_user_browse_history` VALUES (95, '2020-03-17 08:43:45', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (96, '2020-03-17 08:53:31', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (97, '2020-03-17 08:58:36', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (98, '2020-03-17 09:01:49', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (99, '2020-03-17 09:01:59', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (100, '2020-03-17 09:04:28', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (101, '2020-03-17 09:04:46', 173, 156);
INSERT INTO `t_user_browse_history` VALUES (102, '2020-03-17 09:13:13', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (103, '2020-03-17 09:37:01', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (104, '2020-03-17 09:42:07', 172, 151);
INSERT INTO `t_user_browse_history` VALUES (105, '2020-03-17 09:42:31', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (106, '2020-03-17 09:43:14', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (107, '2020-03-17 09:51:46', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (108, '2020-03-17 09:54:09', 172, 151);
INSERT INTO `t_user_browse_history` VALUES (109, '2020-03-17 10:01:38', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (110, '2020-03-17 10:06:40', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (111, '2020-03-17 10:07:13', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (112, '2020-03-17 10:21:39', 172, 151);
INSERT INTO `t_user_browse_history` VALUES (113, '2020-03-17 10:23:00', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (114, '2020-03-17 10:23:49', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (115, '2020-03-17 10:24:01', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (116, '2020-03-17 10:24:43', 172, 155);
INSERT INTO `t_user_browse_history` VALUES (117, '2020-03-17 11:19:58', 172, 156);
INSERT INTO `t_user_browse_history` VALUES (118, '2020-03-17 16:14:42', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (119, '2020-03-18 08:35:27', 173, 155);
INSERT INTO `t_user_browse_history` VALUES (120, '2020-03-18 15:13:38', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (121, '2020-03-18 15:14:46', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (122, '2020-03-18 15:14:51', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (123, '2020-03-18 15:15:00', 174, 164);
INSERT INTO `t_user_browse_history` VALUES (124, '2020-03-18 15:15:07', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (125, '2020-03-18 15:25:11', 174, 164);
INSERT INTO `t_user_browse_history` VALUES (126, '2020-03-18 15:25:51', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (127, '2020-03-18 15:27:21', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (128, '2020-03-18 15:27:40', 174, 164);
INSERT INTO `t_user_browse_history` VALUES (129, '2020-03-18 15:29:57', 174, 164);
INSERT INTO `t_user_browse_history` VALUES (130, '2020-03-18 15:30:07', 174, 164);
INSERT INTO `t_user_browse_history` VALUES (131, '2020-03-18 15:31:30', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (132, '2020-03-18 16:04:42', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (133, '2020-03-18 16:11:27', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (134, '2020-03-18 16:18:43', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (135, '2020-03-18 17:44:55', 172, 163);
INSERT INTO `t_user_browse_history` VALUES (136, '2020-03-18 17:45:16', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (137, '2020-03-18 17:52:45', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (138, '2020-03-18 18:10:12', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (139, '2020-03-18 18:10:49', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (140, '2020-03-18 18:11:05', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (141, '2020-03-18 18:11:19', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (142, '2020-03-18 18:12:07', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (143, '2020-03-18 18:12:32', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (144, '2020-03-19 08:31:09', 172, 164);
INSERT INTO `t_user_browse_history` VALUES (145, '2020-03-19 08:31:53', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (146, '2020-03-19 08:35:11', 172, 164);
INSERT INTO `t_user_browse_history` VALUES (147, '2020-03-19 08:42:13', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (148, '2020-03-19 08:52:39', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (149, '2020-03-19 08:59:57', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (150, '2020-03-19 09:03:42', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (151, '2020-03-19 09:04:02', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (152, '2020-03-19 09:04:15', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (153, '2020-03-19 09:18:19', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (154, '2020-03-19 09:29:24', 172, 166);
INSERT INTO `t_user_browse_history` VALUES (155, '2020-03-19 09:56:22', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (156, '2020-03-19 10:31:50', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (157, '2020-03-19 11:04:54', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (158, '2020-03-19 11:10:32', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (159, '2020-03-19 11:11:36', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (160, '2020-03-19 11:15:21', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (161, '2020-03-19 11:16:18', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (162, '2020-03-19 11:17:40', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (163, '2020-03-19 11:20:06', 174, 163);
INSERT INTO `t_user_browse_history` VALUES (164, '2020-03-19 13:31:41', 172, 166);
INSERT INTO `t_user_browse_history` VALUES (165, '2020-03-19 13:31:50', 172, 165);
INSERT INTO `t_user_browse_history` VALUES (166, '2020-03-19 13:31:55', 172, 164);
INSERT INTO `t_user_browse_history` VALUES (167, '2020-03-19 13:32:06', 172, 164);
INSERT INTO `t_user_browse_history` VALUES (168, '2020-03-19 13:32:13', 172, 166);
INSERT INTO `t_user_browse_history` VALUES (169, '2020-03-19 13:35:27', 172, 169);
INSERT INTO `t_user_browse_history` VALUES (170, '2020-03-19 14:31:05', 172, 163);
INSERT INTO `t_user_browse_history` VALUES (171, '2020-03-19 14:34:21', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (172, '2020-03-19 14:34:34', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (173, '2020-03-19 14:34:54', 174, 167);
INSERT INTO `t_user_browse_history` VALUES (174, '2020-03-20 09:06:06', 174, 166);
INSERT INTO `t_user_browse_history` VALUES (175, '2020-03-20 09:06:08', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (176, '2020-03-20 09:06:28', 172, 163);
INSERT INTO `t_user_browse_history` VALUES (177, '2020-03-20 10:18:28', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (178, '2020-03-20 10:30:27', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (179, '2020-03-20 10:31:17', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (180, '2020-03-20 16:41:12', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (181, '2020-03-20 16:46:00', 174, 166);
INSERT INTO `t_user_browse_history` VALUES (182, '2020-03-20 16:56:24', 174, 165);
INSERT INTO `t_user_browse_history` VALUES (183, '2020-03-20 17:53:08', 174, 166);
INSERT INTO `t_user_browse_history` VALUES (184, '2020-03-20 17:53:22', 172, 164);
INSERT INTO `t_user_browse_history` VALUES (185, '2020-03-20 17:53:54', 172, 165);
INSERT INTO `t_user_browse_history` VALUES (186, '2020-03-23 13:05:59', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (187, '2020-03-23 13:07:12', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (188, '2020-03-23 13:12:28', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (189, '2020-03-23 13:14:29', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (190, '2020-03-23 13:14:38', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (191, '2020-03-23 13:16:21', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (192, '2020-03-23 13:16:29', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (193, '2020-03-23 13:16:38', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (194, '2020-03-23 13:16:42', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (195, '2020-03-23 13:18:20', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (196, '2020-03-23 13:20:36', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (197, '2020-03-23 13:21:19', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (198, '2020-03-23 13:21:29', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (199, '2020-03-23 13:22:26', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (200, '2020-03-23 13:25:36', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (201, '2020-03-23 13:27:33', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (202, '2020-03-23 14:12:47', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (203, '2020-03-23 14:19:43', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (204, '2020-03-23 14:21:38', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (205, '2020-03-23 14:23:21', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (206, '2020-03-23 14:23:35', 177, 165);
INSERT INTO `t_user_browse_history` VALUES (207, '2020-03-23 14:23:40', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (208, '2020-03-23 14:23:49', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (209, '2020-03-23 14:27:31', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (210, '2020-03-23 14:27:44', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (211, '2020-03-23 14:28:23', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (212, '2020-03-23 15:38:06', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (213, '2020-03-23 16:47:33', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (214, '2020-03-23 16:47:38', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (215, '2020-03-24 08:22:51', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (216, '2020-03-24 09:20:40', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (217, '2020-03-24 14:39:48', 172, 176);
INSERT INTO `t_user_browse_history` VALUES (218, '2020-03-24 14:53:52', 177, 182);
INSERT INTO `t_user_browse_history` VALUES (219, '2020-03-24 15:01:09', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (220, '2020-03-24 15:31:39', 172, 176);
INSERT INTO `t_user_browse_history` VALUES (221, '2020-03-24 17:31:15', 172, 176);
INSERT INTO `t_user_browse_history` VALUES (222, '2020-03-25 13:39:19', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (223, '2020-03-25 13:41:13', 177, 181);
INSERT INTO `t_user_browse_history` VALUES (224, '2020-03-25 15:18:32', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (225, '2020-03-25 19:21:14', 106, 186);
INSERT INTO `t_user_browse_history` VALUES (226, '2020-03-25 19:22:29', 106, 164);
INSERT INTO `t_user_browse_history` VALUES (227, '2020-03-25 19:23:05', 106, 164);
INSERT INTO `t_user_browse_history` VALUES (228, '2020-03-26 09:04:29', 172, 167);
INSERT INTO `t_user_browse_history` VALUES (229, '2020-03-26 11:11:53', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (230, '2020-03-27 09:50:38', 177, 182);
INSERT INTO `t_user_browse_history` VALUES (231, '2020-03-31 09:43:55', 177, 165);
INSERT INTO `t_user_browse_history` VALUES (232, '2020-03-31 16:03:54', 177, 176);
INSERT INTO `t_user_browse_history` VALUES (233, '2020-04-01 17:54:55', 178, 169);
INSERT INTO `t_user_browse_history` VALUES (234, '2020-04-01 17:57:28', 178, 163);
INSERT INTO `t_user_browse_history` VALUES (235, '2020-04-02 08:31:24', 177, 181);
INSERT INTO `t_user_browse_history` VALUES (236, '2020-04-02 08:49:27', 177, 169);
INSERT INTO `t_user_browse_history` VALUES (237, '2020-04-02 08:54:34', 177, 164);
INSERT INTO `t_user_browse_history` VALUES (238, '2020-04-02 08:55:12', 177, 180);
INSERT INTO `t_user_browse_history` VALUES (239, '2020-04-02 08:58:38', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (240, '2020-04-02 08:59:46', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (241, '2020-04-02 09:00:05', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (242, '2020-04-02 09:06:09', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (243, '2020-04-02 09:06:35', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (244, '2020-04-02 09:08:38', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (245, '2020-04-02 09:10:30', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (246, '2020-04-02 09:11:46', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (247, '2020-04-02 09:17:02', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (248, '2020-04-02 09:17:11', 177, 179);
INSERT INTO `t_user_browse_history` VALUES (249, '2020-04-02 09:18:09', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (250, '2020-04-02 09:19:28', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (251, '2020-04-02 09:21:40', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (252, '2020-04-02 09:22:18', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (253, '2020-04-02 09:23:45', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (254, '2020-04-02 09:24:31', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (255, '2020-04-02 09:24:43', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (256, '2020-04-02 09:25:00', 177, 163);
INSERT INTO `t_user_browse_history` VALUES (257, '2020-04-02 09:25:12', 177, 185);
INSERT INTO `t_user_browse_history` VALUES (258, '2020-04-02 09:34:34', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (259, '2020-04-02 09:42:36', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (260, '2020-04-02 09:47:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (261, '2020-04-02 09:48:49', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (262, '2020-04-02 09:49:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (263, '2020-04-02 09:53:50', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (264, '2020-04-02 10:07:47', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (265, '2020-04-02 10:09:31', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (266, '2020-04-02 10:11:17', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (267, '2020-04-02 10:18:57', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (268, '2020-04-02 10:20:10', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (269, '2020-04-02 10:20:31', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (270, '2020-04-02 10:21:44', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (271, '2020-04-02 10:21:55', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (272, '2020-04-02 10:22:04', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (273, '2020-04-02 10:23:29', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (274, '2020-04-02 10:26:55', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (275, '2020-04-02 10:27:21', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (276, '2020-04-02 10:27:39', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (277, '2020-04-02 10:27:55', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (278, '2020-04-02 10:32:38', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (279, '2020-04-02 10:33:13', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (280, '2020-04-02 10:39:29', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (281, '2020-04-02 10:40:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (282, '2020-04-02 10:42:51', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (283, '2020-04-02 10:43:03', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (284, '2020-04-02 10:48:16', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (285, '2020-04-02 10:48:54', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (286, '2020-04-02 10:53:24', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (287, '2020-04-02 11:23:40', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (288, '2020-04-02 13:13:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (289, '2020-04-02 13:28:00', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (290, '2020-04-02 13:32:48', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (291, '2020-04-02 13:42:44', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (292, '2020-04-02 13:43:26', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (293, '2020-04-02 13:46:27', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (294, '2020-04-02 13:51:21', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (295, '2020-04-02 14:08:32', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (296, '2020-04-02 14:08:54', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (297, '2020-04-02 14:43:56', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (298, '2020-04-02 14:46:36', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (299, '2020-04-02 15:25:36', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (300, '2020-04-02 15:26:03', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (301, '2020-04-02 15:26:24', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (302, '2020-04-02 15:26:41', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (303, '2020-04-02 15:30:00', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (304, '2020-04-02 15:41:03', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (305, '2020-04-02 15:43:17', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (306, '2020-04-02 15:43:44', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (307, '2020-04-02 15:44:34', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (308, '2020-04-02 15:44:41', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (309, '2020-04-02 15:45:29', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (310, '2020-04-02 15:55:35', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (311, '2020-04-02 15:56:13', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (312, '2020-04-02 15:59:04', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (313, '2020-04-02 15:59:51', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (314, '2020-04-02 16:03:24', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (315, '2020-04-02 16:04:42', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (316, '2020-04-02 16:05:07', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (317, '2020-04-02 16:05:34', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (318, '2020-04-02 16:05:56', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (319, '2020-04-02 16:12:45', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (320, '2020-04-02 16:13:07', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (321, '2020-04-02 16:13:28', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (322, '2020-04-02 16:16:37', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (323, '2020-04-02 16:31:24', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (324, '2020-04-02 16:34:22', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (325, '2020-04-02 16:36:40', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (326, '2020-04-02 16:36:51', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (327, '2020-04-07 08:46:05', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (328, '2020-04-07 08:53:44', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (329, '2020-04-07 08:54:22', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (330, '2020-04-07 08:54:57', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (331, '2020-04-07 09:05:02', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (332, '2020-04-07 09:10:09', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (333, '2020-04-07 09:14:00', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (334, '2020-04-07 09:15:07', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (335, '2020-04-07 09:27:17', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (336, '2020-04-07 09:27:42', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (337, '2020-04-07 09:31:28', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (338, '2020-04-07 09:37:51', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (339, '2020-04-07 09:38:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (340, '2020-04-07 09:38:12', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (341, '2020-04-07 09:38:42', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (342, '2020-04-07 09:39:55', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (343, '2020-04-07 09:39:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (344, '2020-04-07 10:09:03', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (345, '2020-04-07 10:11:07', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (346, '2020-04-07 10:12:46', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (347, '2020-04-07 10:13:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (348, '2020-04-07 10:13:42', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (349, '2020-04-07 10:14:11', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (350, '2020-04-07 10:17:32', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (351, '2020-04-07 10:18:28', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (352, '2020-04-07 10:20:47', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (353, '2020-04-07 10:30:08', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (354, '2020-04-07 10:49:21', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (355, '2020-04-07 10:50:20', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (356, '2020-04-07 11:02:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (357, '2020-04-07 11:02:17', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (358, '2020-04-07 11:10:48', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (359, '2020-04-07 13:04:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (360, '2020-04-07 13:15:43', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (361, '2020-04-07 13:30:00', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (362, '2020-04-07 13:32:33', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (363, '2020-04-07 13:32:49', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (364, '2020-04-07 13:34:37', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (365, '2020-04-07 13:38:10', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (366, '2020-04-07 13:46:10', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (367, '2020-04-07 13:46:55', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (368, '2020-04-07 13:47:20', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (369, '2020-04-07 14:40:40', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (370, '2020-04-07 14:44:37', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (371, '2020-04-07 14:44:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (372, '2020-04-07 14:45:47', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (373, '2020-04-07 14:48:47', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (374, '2020-04-07 15:19:17', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (375, '2020-04-07 15:24:54', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (376, '2020-04-07 15:26:14', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (377, '2020-04-07 15:29:28', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (378, '2020-04-07 15:34:47', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (379, '2020-04-07 15:35:00', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (380, '2020-04-07 16:18:37', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (381, '2020-04-07 18:04:35', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (382, '2020-04-08 08:39:07', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (383, '2020-04-08 08:49:25', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (384, '2020-04-08 08:50:25', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (385, '2020-04-08 08:51:04', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (386, '2020-04-08 08:57:01', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (387, '2020-04-08 09:00:57', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (388, '2020-04-08 09:03:42', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (389, '2020-04-08 09:10:06', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (390, '2020-04-08 09:15:21', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (391, '2020-04-08 09:15:37', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (392, '2020-04-08 09:16:41', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (393, '2020-04-08 09:18:05', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (394, '2020-04-08 09:18:41', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (395, '2020-04-08 09:19:46', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (396, '2020-04-08 09:19:56', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (397, '2020-04-08 09:21:38', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (398, '2020-04-08 09:25:58', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (399, '2020-04-08 09:29:39', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (400, '2020-04-08 09:30:15', 177, 186);
INSERT INTO `t_user_browse_history` VALUES (401, '2020-04-08 09:30:34', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (402, '2020-04-08 09:31:21', 177, 187);
INSERT INTO `t_user_browse_history` VALUES (403, '2020-04-08 09:31:24', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (404, '2020-04-08 10:09:35', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (405, '2020-04-08 10:09:49', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (406, '2020-04-08 10:12:18', 177, 167);
INSERT INTO `t_user_browse_history` VALUES (407, '2020-04-13 11:23:11', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (408, '2020-04-13 11:23:26', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (409, '2020-04-13 11:23:47', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (410, '2020-04-13 11:24:05', 177, 186);
INSERT INTO `t_user_browse_history` VALUES (411, '2020-04-13 11:24:29', 177, 166);
INSERT INTO `t_user_browse_history` VALUES (412, '2020-04-13 11:24:34', 177, 165);
INSERT INTO `t_user_browse_history` VALUES (413, '2020-04-13 11:24:40', 177, 174);
INSERT INTO `t_user_browse_history` VALUES (414, '2020-04-13 11:24:53', 177, 174);

-- ----------------------------
-- Table structure for t_user_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_user_collection`;
CREATE TABLE `t_user_collection`  (
  `id` int(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(6) UNSIGNED NULL DEFAULT NULL,
  `house_id` int(7) UNSIGNED NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_collection
-- ----------------------------
INSERT INTO `t_user_collection` VALUES (58, 172, 150, '2020-03-04 19:23:17', '2020-03-04 19:23:21', 'A');
INSERT INTO `t_user_collection` VALUES (59, 172, 140, '2020-03-04 19:23:22', '2020-03-04 19:23:22', 'A');
INSERT INTO `t_user_collection` VALUES (60, 172, 141, '2020-03-04 19:23:23', '2020-03-04 19:23:23', 'A');
INSERT INTO `t_user_collection` VALUES (61, 173, 155, '2020-03-16 14:03:16', '2020-03-16 14:07:04', 'A');
INSERT INTO `t_user_collection` VALUES (62, 173, 151, '2020-03-16 18:23:44', '2020-03-16 18:23:44', 'A');
INSERT INTO `t_user_collection` VALUES (63, 173, 156, '2020-03-16 18:24:03', '2020-03-17 09:37:06', 'X');
INSERT INTO `t_user_collection` VALUES (64, 172, 156, '2020-03-17 09:06:13', '2020-03-17 09:06:21', 'A');
INSERT INTO `t_user_collection` VALUES (65, 172, 155, '2020-03-17 09:06:16', '2020-03-17 09:22:55', 'A');
INSERT INTO `t_user_collection` VALUES (66, 172, 151, '2020-03-17 09:06:18', '2020-03-17 09:06:18', 'A');
INSERT INTO `t_user_collection` VALUES (67, NULL, 156, '2020-03-17 09:36:19', '2020-03-17 09:36:19', 'A');
INSERT INTO `t_user_collection` VALUES (68, NULL, 151, '2020-03-17 09:36:37', '2020-03-17 09:36:37', 'A');
INSERT INTO `t_user_collection` VALUES (69, NULL, 155, '2020-03-17 09:36:38', '2020-03-17 09:36:38', 'A');
INSERT INTO `t_user_collection` VALUES (70, NULL, 155, '2020-03-17 09:57:26', '2020-03-17 09:57:26', 'A');
INSERT INTO `t_user_collection` VALUES (71, 173, 163, '2020-03-18 09:39:31', '2020-03-18 10:30:38', 'A');
INSERT INTO `t_user_collection` VALUES (72, 173, 164, '2020-03-18 10:30:33', '2020-03-18 10:30:34', 'X');
INSERT INTO `t_user_collection` VALUES (73, 172, 163, '2020-03-18 18:19:08', '2020-03-20 17:52:32', 'X');
INSERT INTO `t_user_collection` VALUES (74, 174, 164, '2020-03-18 18:19:20', '2020-03-18 18:19:21', 'X');
INSERT INTO `t_user_collection` VALUES (75, 174, 165, '2020-03-18 18:19:23', '2020-03-19 14:35:01', 'X');
INSERT INTO `t_user_collection` VALUES (76, 174, 163, '2020-03-18 18:19:33', '2020-03-18 18:19:35', 'X');
INSERT INTO `t_user_collection` VALUES (77, 174, 166, '2020-03-18 18:19:39', '2020-03-18 18:19:40', 'X');
INSERT INTO `t_user_collection` VALUES (78, 174, 167, '2020-03-19 14:34:40', '2020-03-19 14:34:50', 'X');
INSERT INTO `t_user_collection` VALUES (79, 174, 169, '2020-03-20 08:38:28', '2020-03-20 16:17:53', 'X');
INSERT INTO `t_user_collection` VALUES (80, 172, 167, '2020-03-20 17:52:13', '2020-03-26 13:13:34', 'X');
INSERT INTO `t_user_collection` VALUES (81, 172, 166, '2020-03-20 17:52:15', '2020-03-26 13:13:42', 'X');
INSERT INTO `t_user_collection` VALUES (82, 172, 164, '2020-03-20 17:52:17', '2020-03-26 13:13:36', 'X');
INSERT INTO `t_user_collection` VALUES (83, 172, 169, '2020-03-20 17:52:18', '2020-03-26 13:13:16', 'A');
INSERT INTO `t_user_collection` VALUES (84, 172, 165, '2020-03-20 17:52:23', '2020-03-26 13:13:32', 'X');
INSERT INTO `t_user_collection` VALUES (85, 177, 167, '2020-03-23 14:11:49', '2020-03-24 13:24:24', 'X');
INSERT INTO `t_user_collection` VALUES (86, 177, 163, '2020-03-23 14:11:53', '2020-03-23 15:27:08', 'A');
INSERT INTO `t_user_collection` VALUES (87, 177, 169, '2020-03-23 14:12:47', '2020-03-23 14:12:47', 'A');
INSERT INTO `t_user_collection` VALUES (88, 177, 166, '2020-03-23 15:26:02', '2020-03-23 15:26:02', 'A');
INSERT INTO `t_user_collection` VALUES (89, 172, 179, '2020-03-26 13:13:08', '2020-03-26 13:13:08', 'X');

-- ----------------------------
-- Table structure for t_user_house_bargain
-- ----------------------------
DROP TABLE IF EXISTS `t_user_house_bargain`;
CREATE TABLE `t_user_house_bargain`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标识',
  `house_id` int(6) UNSIGNED NOT NULL COMMENT '房源标识',
  `bargain_start_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '砍价开始时间',
  `bargain_end_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '砍价结束时间',
  `bargain_num` int(2) UNSIGNED NOT NULL COMMENT '砍价总人数',
  `bargain_price` decimal(9, 2) UNSIGNED NOT NULL COMMENT '每人砍价金额',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态，A-在用;X-删除',
  `created_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `origin_price` decimal(9, 2) UNSIGNED NULL DEFAULT NULL COMMENT '房源原始价格（默认元/月）',
  `bargain_end_price` decimal(9, 2) NULL DEFAULT NULL COMMENT '砍价结束金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_house_bargain
-- ----------------------------
INSERT INTO `t_user_house_bargain` VALUES (10, 141, '2020-01-16 08:00:00', '2020-01-17 00:00:00', 10, 50.00, 'A', '2020-01-17 13:43:59', '2020-01-17 13:43:59', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (11, 152, '2020-03-16 00:00:00', '2020-03-31 00:00:00', 10, 100.00, 'A', '2020-03-16 13:46:40', '2020-03-16 13:46:40', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (12, 153, '2020-03-16 00:00:00', '2020-03-31 00:00:00', 10, 100.00, 'A', '2020-03-16 13:46:56', '2020-03-16 13:46:56', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (13, 154, '2020-03-16 00:00:00', '2020-03-31 00:00:00', 10, 100.00, 'A', '2020-03-16 13:47:15', '2020-03-16 13:47:15', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (14, 155, '2020-03-16 00:00:00', '2020-03-31 00:00:00', 10, 100.00, 'A', '2020-03-16 13:48:49', '2020-03-16 13:48:49', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (15, 156, '2020-03-16 00:00:00', '2020-03-31 00:00:00', 10, 100.00, 'A', '2020-03-16 13:53:09', '2020-03-16 13:53:09', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (16, 160, '2020-03-18 00:00:00', '2021-03-18 00:00:00', 10, 50.00, 'A', '2020-03-18 09:18:01', '2020-03-18 09:18:01', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (17, 161, '2020-03-18 00:00:00', '2021-03-18 00:00:00', 10, 50.00, 'A', '2020-03-18 09:20:34', '2020-03-18 09:20:34', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (18, 162, '2020-03-18 00:00:00', '2021-03-18 00:00:00', 10, 50.00, 'A', '2020-03-18 09:24:10', '2020-03-18 09:24:10', NULL, NULL);
INSERT INTO `t_user_house_bargain` VALUES (19, 169, '2020-03-19 00:00:00', '2021-03-13 00:00:00', 20, 500.00, 'A', '2020-03-19 13:35:10', '2020-03-19 13:35:10', NULL, NULL);

-- ----------------------------
-- Table structure for t_user_house_contract_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_house_contract_relation`;
CREATE TABLE `t_user_house_contract_relation`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标识',
  `access_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `user_id` int(6) UNSIGNED NOT NULL COMMENT '用户标识',
  `audit_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'W' COMMENT '审核状态,A:审核通过\r\n            X:未通过\r\n            W:审核中',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态,A：有效\r\n            X：无效\r\n  ',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_house_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_house_relation`;
CREATE TABLE `t_user_house_relation`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(6) UNSIGNED NOT NULL,
  `house_id` int(7) UNSIGNED NOT NULL,
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A：有效\r\n            X：无效\r\n            C：审核',
  `publish_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  `state_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_property
-- ----------------------------
DROP TABLE IF EXISTS `t_user_property`;
CREATE TABLE `t_user_property`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) UNSIGNED NOT NULL COMMENT '用户标识',
  `house_id` int(7) UNSIGNED NOT NULL COMMENT '房源标识',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT 'A:有效\r\n            X:无效',
  `reserve1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_property
-- ----------------------------
INSERT INTO `t_user_property` VALUES (10, 169, 140, 'A', NULL, NULL, NULL, '2020-01-18 15:05:10', '2020-01-18 15:05:10');
INSERT INTO `t_user_property` VALUES (11, 172, 151, 'A', NULL, NULL, NULL, '2020-03-17 09:17:17', '2020-03-17 09:17:17');
INSERT INTO `t_user_property` VALUES (12, 173, 151, 'A', NULL, NULL, NULL, '2020-03-17 09:17:56', '2020-03-17 09:17:56');
INSERT INTO `t_user_property` VALUES (13, 174, 163, 'A', NULL, NULL, NULL, '2020-03-18 18:20:23', '2020-03-18 18:20:23');
INSERT INTO `t_user_property` VALUES (14, 174, 165, 'A', NULL, NULL, NULL, '2020-03-20 09:05:03', '2020-03-20 09:05:03');
INSERT INTO `t_user_property` VALUES (15, 172, 163, 'A', NULL, NULL, NULL, '2020-03-20 09:06:43', '2020-03-20 09:06:43');
INSERT INTO `t_user_property` VALUES (16, 174, 164, 'A', NULL, NULL, NULL, '2020-03-20 15:19:27', '2020-03-20 15:19:27');
INSERT INTO `t_user_property` VALUES (17, 177, 163, 'A', NULL, NULL, NULL, '2020-03-23 13:31:48', '2020-03-23 13:31:48');
INSERT INTO `t_user_property` VALUES (18, 177, 165, 'A', NULL, NULL, NULL, '2020-03-23 13:32:38', '2020-03-23 13:32:38');
INSERT INTO `t_user_property` VALUES (19, 177, 164, 'A', NULL, NULL, NULL, '2020-03-23 13:34:57', '2020-03-23 13:34:57');
INSERT INTO `t_user_property` VALUES (20, 177, 174, 'A', NULL, NULL, NULL, '2020-03-24 09:09:05', '2020-03-24 09:09:05');
INSERT INTO `t_user_property` VALUES (21, 177, 182, 'A', NULL, NULL, NULL, '2020-03-24 14:59:20', '2020-03-24 14:59:20');

-- ----------------------------
-- Table structure for t_user_search_history
-- ----------------------------
DROP TABLE IF EXISTS `t_user_search_history`;
CREATE TABLE `t_user_search_history`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(6) UNSIGNED NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '搜索词条',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '状态日期',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'A' COMMENT '状态：\r\nA-在用;\r\nX-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_search_history
-- ----------------------------
INSERT INTO `t_user_search_history` VALUES (20, 28, 'xing', '2020-03-16 14:08:07', '2020-03-18 08:52:19', 'X');
INSERT INTO `t_user_search_history` VALUES (21, 28, '旺', '2020-03-17 13:48:16', '2020-03-18 08:53:15', 'A');

SET FOREIGN_KEY_CHECKS = 1;
