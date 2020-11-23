/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 03/11/2020 19:46:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `phone` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `nickname` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `password` varchar(256) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `avatar` varchar(256) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
