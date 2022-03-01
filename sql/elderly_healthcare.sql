SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- COMMENT '部门表'
-- Table structure for organize_depart
-- ----------------------------
DROP TABLE IF EXISTS `organize_depart`;
CREATE TABLE `organize_depart`  (
  `depart_id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `depart_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名'
  `man_number` int NULL DEFAULT NULL COMMENT '部门人数'
  PRIMARY KEY (`depart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '医师表'
-- Table structure for employee_doctor
-- ----------------------------
DROP TABLE IF EXISTS `employee_doctor`;
CREATE TABLE `employee_doctor`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ID',
  `staff_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `depart_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `staff_authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `stuff_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `stuff_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `stuff_adress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `in_time` datetime NULL DEFAULT NULL COMMENT '入职时间',
  `is_resigned` int NULL DEFAULT NULL COMMENT '是否离职',
  `resign_time` datetime NULL DEFAULT NULL COMMENT '离职时间'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '护理员表'
-- Table structure for employee_nurse
-- ----------------------------
DROP TABLE IF EXISTS `employee_nurse`;
CREATE TABLE `employee_nurse`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ID',
  `staff_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `depart_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `staff_authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `stuff_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `stuff_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `stuff_adress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `in_time` datetime NULL DEFAULT NULL COMMENT '入职时间',
  `is_resigned` int NULL DEFAULT NULL COMMENT '是否离职',
  `resign_time` datetime NULL DEFAULT NULL COMMENT '离职时间'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '普通员工表'
-- Table structure for organize_staff
-- ----------------------------
DROP TABLE IF EXISTS `organize_staff`;
CREATE TABLE `organize_staff`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ID',
  `staff_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `depart_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `staff_authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `stuff_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `stuff_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `stuff_adress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `in_time` datetime NULL DEFAULT NULL COMMENT '入职时间',
  `is_resigned` int NULL DEFAULT NULL COMMENT '是否离职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '员工任务表'
-- Table structure for daily_mission
-- ----------------------------
DROP TABLE IF EXISTS `daily_mission`;
CREATE TABLE `daily_mission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `task_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务编号',
  `patient_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责病人',
  `task_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作内容',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '工资表'
-- Table structure for employee_salary
-- ----------------------------
DROP TABLE IF EXISTS `employee_salary`;
CREATE TABLE `employee_salary`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `depart_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_days` double NULL DEFAULT NULL COMMENT '工作天数',
  `off_days` double NULL DEFAULT NULL COMMENT '请假天数',
  `deduct_acount` double NULL DEFAULT NULL COMMENT '罚款',
  `insurance_count` double NULL DEFAULT NULL COMMENT '保险',
  `allowance_count` double NULL DEFAULT NULL COMMENT '补贴',
  `salary_count` double NULL DEFAULT NULL COMMENT '总数',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '工资文件表'
-- Table structure for salary_detail_files
-- ----------------------------
DROP TABLE IF EXISTS `salary_detail_files`;
CREATE TABLE `salary_detail_files`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `salary_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资编号',
  `file_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `in_time` datetime NULL DEFAULT NULL COMMENT '上传时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '文件名',
  `minio_bucket` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '桶名',
  `minio_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '存储名称',
  `is_deleted` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '是否删除'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '疾病目录'
-- Table structure for illness_catalog
-- ----------------------------
DROP TABLE IF EXISTS `illness_catalog`;
CREATE TABLE `illness_catalog`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ill_id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病编号',
  `ill_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病类别',
  `ill_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病名',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '疾病预警'
-- Table structure for illness_warning
-- ----------------------------
DROP TABLE IF EXISTS `illness_warning`;
CREATE TABLE `illness_warning`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ill_id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病编号',
  `ill_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病类别',
  `ill_index` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '疾病指标',
  `warn_index` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '阈值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- 邮件信息表
-- Table structure for info_mail
-- ----------------------------
DROP TABLE IF EXISTS `info_mail`;
CREATE TABLE `info_mail`  (
  `mail_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮件编号',
  `sender_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送人',
  `mail_sender` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送邮箱',
  `receiver_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收件人',
  `mail_receiver` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收件邮箱',
  `send_time` datetime NOT NULL COMMENT '发件时间',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物编号',
  PRIMARY KEY (`mail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '病人信息表'
-- Table structure for patient_user
-- ----------------------------
DROP TABLE IF EXISTS `patient_user`;
CREATE TABLE `patient_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `patient_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `patient_age` int NULL DEFAULT NULL COMMENT '年龄',
  `patient_phone` int NULL DEFAULT NULL COMMENT '电话',
  `contact_phone` int NULL DEFAULT NULL COMMENT '紧急电话',
  `charge_nurse` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主治医师',
  `charge_doctor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责看护',
  `is_out` int NULL DEFAULT NULL COMMENT '是否出院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '身体状况表'
-- Table structure for patient_details
-- ----------------------------
DROP TABLE IF EXISTS `patient_details`;
CREATE TABLE `patient_details`  (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '病人消费记录'
-- Table structure for paitent_cost_detail
-- ----------------------------
DROP TABLE IF EXISTS `paitent_cost_detail`;
CREATE TABLE `paitent_cost_detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '病人编号',
  `case_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病例编号',
  `cost_list` text NOT NULL COMMENT '清单',
  `cost_count` double NOT NULL COMMENT '总价',
  `in_time` datetime NULL DEFAULT NULL COMMENT '入院时间',
  `out_time` datetime NULL DEFAULT NULL COMMENT '出院时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '消费记录发票'
-- Table structure for patient_case_files
-- ----------------------------
DROP TABLE IF EXISTS `patient_case_files`;
CREATE TABLE `patient_cost_files`  (
  `case_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病例编号',
  `patient_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '病人编号',
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病例名称',
  `file_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `in_time` datetime NULL DEFAULT NULL COMMENT '上传时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '文件名',
  `minio_bucket` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '桶名',
  `minio_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '存储名称',
  `is_deleted` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL '是否删除'
  PRIMARY KEY (`case_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '入住登记模板'
-- Table structure for register_template
-- ----------------------------
DROP TABLE IF EXISTS `register_template`;
CREATE TABLE `register_template`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `temp_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模板编号',
  `temp_ill` varchar(30) COMMENT '疾病'，
  `temp_time` datetime COMMENT '入住时长'，
  `cost_level` int COMMENT '消费套餐选择'，
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注'
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '药品目录表'
-- Table structure for medicine_catalog
-- ----------------------------
DROP TABLE IF EXISTS `medicine_catalog`;
CREATE TABLE `medicine_catalog`  (
  `goods_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物编号',
  `goods_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名',
  `goods_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品类别',
  `goods_price` double NOT NULL COMMENT '单价',
  `produce_time` datetime NOT NULL COMMENT '生产日期',
  `overdue_time` datetime NOT NULL COMMENT '过期时间',
  `produce_vendor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '生产厂商',
  `goods_count` int NOT NULL COMMENT '库存数量',
  `warn_line` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '库存预警线(数量不低于)',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '货物库存'
-- Table structure for warehose_storage
-- ----------------------------
DROP TABLE IF EXISTS `warehose_storage`;
CREATE TABLE `warehose_storage`  (
  `goods_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物编号',
  `goods_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物名',
  `goods_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物类别',
  `goods_price` double NOT NULL COMMENT '单价',
  `produce_time` datetime NOT NULL COMMENT '生产日期',
  `overdue_time` datetime NOT NULL COMMENT '过期时间',
  `produce_vendor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '生产厂商',
  `goods_count` int NOT NULL COMMENT '库存数量',
  `warn_line` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '库存预警线(数量不低于)',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注'
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '订单管理表'
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods`  (
  `goods_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物编号',
  `goods_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名',
  `goods_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品类别',
  `goods_price` double NOT NULL COMMENT '单价',
  `order_count` int NOT NULL COMMENT '购买量',
  `order_time` datetime NOT NULL COMMENT '购买时间',
  `staff_id` varchar(15) NOT NULL COMMENT '负责人 ID',
  `staff_name` varchar(30) NOT NULL COMMENT '负责人',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '系统用户表'
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) NOT NULL AUTO_INCREMENT COMMENT '账号',
  `password` varchar(20) NOT NULL AUTO_INCREMENT COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '员工用户表'
-- Table structure for staff_user
-- ----------------------------
DROP TABLE IF EXISTS `staff_user`;
CREATE TABLE `staff_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) NOT NULL AUTO_INCREMENT COMMENT '账号',
  `password` varchar(20) NOT NULL AUTO_INCREMENT COMMENT '密码',
  `user_authority` varchar(20) NOT NULL AUTO_INCREMENT COMMENT '账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- COMMENT '系统日志表'
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `log_id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `log_module` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '来源模块',
  `log_info` text NOT NULL AUTO_INCREMENT COMMENT '日志信息',
  `in_time` datetime NOT NULL AUTO_INCREMENT COMMENT '登记时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
