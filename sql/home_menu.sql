/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 47.100.200.104
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 47.100.200.104:6565
 Source Schema         : elderly_healthcare

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 14/05/2022 13:18:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for home_menu
-- ----------------------------
DROP TABLE IF EXISTS `home_menu`;
CREATE TABLE `home_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `router_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_show` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 902 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_menu
-- ----------------------------
INSERT INTO `home_menu` VALUES (1, '2', 'setting', 'smile', '我的首页', '/elderlyHealthcare/home', 1);
INSERT INTO `home_menu` VALUES (2, '1', 'setting', 'smile', '个人信息', '/elderlyHealthcare/setting/personal', 1);
INSERT INTO `home_menu` VALUES (3, '3', 'setting', 'question-circle', '用户手册', '/elderlyHealthcare/setting/question', 1);
INSERT INTO `home_menu` VALUES (4, '4', 'setting', 'smile', '系统后台', '/elderlyHealthcare/root/process', 1);
INSERT INTO `home_menu` VALUES (5, '5', 'setting', 'disconnect', '退出登录', '/elderlyHealthcare/login', 1);
INSERT INTO `home_menu` VALUES (101, '1', 'top', NULL, '公共服务', '/elderlyHealthcare/service', 1);
INSERT INTO `home_menu` VALUES (102, '2', 'top', NULL, '人力资源', '/elderlyHealthcare/human', 1);
INSERT INTO `home_menu` VALUES (103, '3', 'top', NULL, '资产中心', '/elderlyHealthcare/asset', 1);
INSERT INTO `home_menu` VALUES (104, '4', 'top', NULL, '后勤管理', '/elderlyHealthcare/store', 1);
INSERT INTO `home_menu` VALUES (201, '1', 'service', 'line-chart', '数据大屏', '/elderlyHealthcare/service/chart', 1);
INSERT INTO `home_menu` VALUES (202, '3', 'service', 'dot-chart', '监控预警', '/elderlyHealthcare/service/monitor', 1);
INSERT INTO `home_menu` VALUES (203, '2', 'service', 'user-add', '入住登记', '/elderlyHealthcare/service/access', 1);
INSERT INTO `home_menu` VALUES (204, '4', 'service', 'idcard', '病人管理', '/elderlyHealthcare/service/patient', 1);
INSERT INTO `home_menu` VALUES (205, '5', 'service', 'form', '消费登记', '/elderlyHealthcare/service/cost', 1);
INSERT INTO `home_menu` VALUES (301, '1', 'human', 'form', '请假审批', '/elderlyHealthcare/human/vacate', 1);
INSERT INTO `home_menu` VALUES (302, '2', 'human', 'team', '员工管理', '/elderlyHealthcare/human/staff', 1);
INSERT INTO `home_menu` VALUES (401, '1', 'asset', 'dollar', '费用缴纳', '/elderlyHealthcare/asset/payment', 1);
INSERT INTO `home_menu` VALUES (403, '3', 'asset', 'form', '物资申请', '/elderlyHealthcare/asset/apply', 1);
INSERT INTO `home_menu` VALUES (501, '1', 'store', 'shopping-cart', '物资采购', '/elderlyHealthcare/store/order', 1);
INSERT INTO `home_menu` VALUES (502, '2', 'store', 'folder-open', '药品管理', '/elderlyHealthcare/store/medicine', 1);
INSERT INTO `home_menu` VALUES (503, '3', 'store', 'profile', '库存管理', '/elderlyHealthcare/store/storage', 1);
INSERT INTO `home_menu` VALUES (601, '1', 'system', 'profile', '文件配置', '/elderlyHealthcare/root/system/minio', 2);
INSERT INTO `home_menu` VALUES (602, '2', 'system', 'warning', '系统日志', '/elderlyHealthcare/root/system/logs', 0);
INSERT INTO `home_menu` VALUES (603, '3', 'system', 'filter', '路由配置', '/elderlyHealthcare/root/system/router', 2);
INSERT INTO `home_menu` VALUES (701, '1', 'root', NULL, '基本管理', '/elderlyHealthcare/root/process', 2);
INSERT INTO `home_menu` VALUES (702, '2', 'root', NULL, '人员管理', '/elderlyHealthcare/root/staff', 2);
INSERT INTO `home_menu` VALUES (703, '3', 'root', NULL, '系统管理', '/elderlyHealthcare/root/system', 2);
INSERT INTO `home_menu` VALUES (801, '1', 'process', 'calendar', '任务发布', '/elderlyHealthcare/root/process/task', 2);
INSERT INTO `home_menu` VALUES (802, '2', 'process', 'form', '流程审批', '/elderlyHealthcare/root/process/audit', 2);
INSERT INTO `home_menu` VALUES (901, '1', 'staff', 'wallet', '薪资管理', '/elderlyHealthcare/root/staff/salary', 2);
INSERT INTO `home_menu` VALUES (902, '2', 'staff', 'form', '权限管理', '/elderlyHealthcare/root/staff/user', 2);
INSERT INTO `home_menu` VALUES (903, '3', 'staff', 'apartment', '人员调度', '/elderlyHealthcare/root/staff/dispatch', 0);

SET FOREIGN_KEY_CHECKS = 1;
