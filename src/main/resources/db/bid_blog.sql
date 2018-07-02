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

 Date: 02/07/2018 09:29:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bid_blog
-- ----------------------------
DROP TABLE IF EXISTS `bid_blog`;
CREATE TABLE `bid_blog`  (
  `id` int(11) NOT NULL,
  `content` mediumtext CHARACTER SET gbk COLLATE gbk_chinese_ci NULL,
  `label` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `modify_date` datetime(0) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `modify_user_id` bigint(20) NULL DEFAULT NULL,
  `create_user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
