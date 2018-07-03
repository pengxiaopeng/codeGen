/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3304
 Source Schema         : zyfast

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 03/07/2018 15:36:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bid_blog
-- ----------------------------
DROP TABLE IF EXISTS `bid_blog`;
CREATE TABLE `bid_blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` mediumtext CHARACTER SET gbk COLLATE gbk_chinese_ci NULL,
  `label` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `modify_date` datetime(0) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `modify_user_id` bigint(20) NULL DEFAULT NULL,
  `create_user_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bid_blog
-- ----------------------------
INSERT INTO `bid_blog` VALUES (1, 'sss', 'labless', 'aaa,bbb,ccds', '2018-07-25 17:17:20', '2018-07-04 17:17:15', NULL, NULL, 'titla', 'aaa');

SET FOREIGN_KEY_CHECKS = 1;
