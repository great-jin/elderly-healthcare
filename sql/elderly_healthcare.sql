-- id: 20
-- name: 30
-- phone: 20
-- email: 50
-- adress: 200
-- comment: 255


-- ----------------------------
-- COMMENT '部门表'
-- Table structure for organize_info
-- ----------------------------
DROP TABLE IF EXISTS `organize_info`;
CREATE TABLE `organize_info` (
  `organize_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '编号',
  `organize_name` varchar(30) COMMENT '部门名',
  `organize_type` varchar(20) COMMENT '部门类型',
  `create_time` datetime COMMENT '创建时间',
  `man_count` int COMMENT '部门人数',
  `staff_id` varchar(20) COMMENT '领导编号',
  `organize_leader` varchar(30) COMMENT '领导',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '医师表'   staff_id: ys_001
-- Table structure for staff_doctor
-- ----------------------------
DROP TABLE IF EXISTS `staff_doctor`;
CREATE TABLE `staff_doctor` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_adress` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
) 


-- ----------------------------
-- COMMENT '护理人员表'   staff_id: hs_001
-- Table structure for staff_nurse
-- ----------------------------
DROP TABLE IF EXISTS `staff_nurse`;
CREATE TABLE `staff_nurse` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_adress` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
) 


-- ----------------------------
-- COMMENT '其它员工'    staff_id: yg_001
-- Table structure for organize_staff
-- ----------------------------
DROP TABLE IF EXISTS `organize_staff`;
CREATE TABLE `organize_staff` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_adress` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
) 


-- ----------------------------
-- COMMENT '任务表'
-- Table structure for daily_mission
-- ----------------------------
DROP TABLE IF EXISTS `daily_task`;
CREATE TABLE `daily_task` (
  `task_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '任务编号',
  `task_name` varchar(100) COMMENT '任务名称',
  `patient_id` varchar(36) COMMENT '负责的病人',
  `task_content` text COMMENT '工作内容',
  `staff_id` varchar(20) COMMENT '负责人',
  `created_time` datetime COMMENT '创建时间',
  `is_delay` int COMMENT '是否延期',
  `update_time` datetime COMMENT '更新时间',
  `is_finished` int COMMENT '是否完成',
  `finish_time` datetime COMMENT '完成时间',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '工资表'
-- Table structure for employee_salary
-- ----------------------------
DROP TABLE IF EXISTS `employee_salary`;
CREATE TABLE `employee_salary` (
  `salary_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `staff_id` varchar(20) COMMENT '员工编号',
  `organize_id` varchar(20) COMMENT '部门编号',
  `work_date` varchar(20) COMMENT '月份',
  `work_days` double COMMENT '工作天数',
  `off_days` double COMMENT '请假天数',
  `deduct_count` double COMMENT '罚款',
  `insurance_count` double COMMENT '保险',
  `allowance_count` double COMMENT '补贴',
  `salary_count` double COMMENT '总数',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '工资文件'
-- Table structure for salary_detail_files
-- ----------------------------
DROP TABLE IF EXISTS `salary_detail_files`;
CREATE TABLE `salary_detail_files` (
  `file_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `salary_id` varchar(36) COMMENT '工资编号',
  `staff_id` varchar(20) COMMENT '员工编号',
  `file_type` varchar(30) COMMENT '文件类型',
  `file_name` varchar(100) COMMENT '文件名',
  `minio_bucket` varchar(100) COMMENT '桶名',
  `minio_path` varchar(100) COMMENT '存储名称',
  `upload_time` datetime COMMENT '上传时间',
  `update_time` datetime COMMENT '更新时间',
  `is_deleted` int COMMENT '是否删除',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '入住登记模板'
-- Table structure for register_template
-- ----------------------------
DROP TABLE IF EXISTS `register_template`;
CREATE TABLE `register_template` (
  `temp_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '模板编号',
  `temp_level` int COMMENT '套餐选择',
  `temp_ill` varchar(30) COMMENT '疾病',
  `temp_time` double COMMENT '入住天数',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '病人信息表'
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info` (
  `patient_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '编号',
  `patient_name` varchar(50) COMMENT '姓名',
  `patient_gender` varchar(10) COMMENT '性别',
  `patient_age` int COMMENT '年龄',
  `patient_phone` varchar(20) COMMENT '电话',
  `contact_name` varchar(30) COMMENT '紧急联系人',
  `contact_phone` varchar(20) COMMENT '紧急电话',
  `in_time` datetime COMMENT '入住时间',
  `is_leave` int COMMENT '是否出院'
) 


-- ----------------------------
-- COMMENT '病历信息'
-- Table structure for patient_case_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_case_info`;
CREATE TABLE `patient_case_info` (
  `cast_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '编号',
  `patient_id` varchar(36) COMMENT '病人编号',
  `patient_name` varchar(30) COMMENT '姓名',
  `case_describe` text COMMENT '描述',
  `charge_doctor` varchar(20) COMMENT '主治医师 ID',
  `charge_nurse` varchar(20) COMMENT '护理员 ID',
  `in_time` datetime COMMENT '入住时间',
  `is_leave` int COMMENT '是否出院',
  `out_time` datetime COMMENT '出院时间',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '病例文件'
-- Table structure for patient_case_files
-- ----------------------------
DROP TABLE IF EXISTS `patient_case_files`;
CREATE TABLE `patient_case_files` (
  `file_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '文件ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `cast_id` varchar(36) COMMENT '病历编号',
  `file_type` varchar(30) COMMENT '文件类型',
  `file_name` varchar(100) COMMENT '文件名',
  `minio_bucket` varchar(50) COMMENT '桶名',
  `minio_path` varchar(100) COMMENT '存储名称',
  `upload_time` datetime COMMENT '上传时间',
  `update_time` datetime COMMENT '更新时间',
  `is_deleted` int COMMENT '是否删除'
) 


-- ----------------------------
-- COMMENT '消费记录'
-- Table structure for paitent_cost_detail
-- ----------------------------
DROP TABLE IF EXISTS `paitent_cost_detail`;
CREATE TABLE `paitent_cost_detail`  (
  `cost_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `charge_doctor` varchar(30) COMMENT '主治医师',
  `cost_list` text COMMENT '清单',
  `in_time` datetime COMMENT '入院时间',
  `out_time` datetime COMMENT '出院时间',
  `cost_count` double COMMENT '总价',
  `is_pay` int COMMENT '是否结算',
  `pay_time` datetime COMMENT '付款时间',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '疾病目录'
-- Table structure for illness_catalog
-- ----------------------------
DROP TABLE IF EXISTS `illness_catalog`;
CREATE TABLE `illness_catalog`  (
  `ill_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '疾病编号',
  `ill_type` varchar(50) COMMENT '疾病类别',
  `ill_name` varchar(50) COMMENT '疾病名',
  `ill_describe` text COMMENT '描述',
  `ill_index` varchar(50) COMMENT '疾病指标',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '药品目录'
-- Table structure for medicine_catalog
-- ----------------------------
DROP TABLE IF EXISTS `medicine_catalog`;
CREATE TABLE `medicine_catalog`  (
  `drug_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '药品编号',
  `goods_id` varchar(50) COMMENT '入库编号',
  `drug_name` varchar(50) COMMENT '药品名',
  `drug_type` varchar(50) COMMENT '药品类别',
  `drug_price` double COMMENT '单价',
  `goods_count` int COMMENT '库存数量',
  `produce_time` datetime COMMENT '生产日期',
  `overdue_time` datetime COMMENT '过期时间',
  `is_overdue` int COMMENT '是否过期',
  `produce_vendor` varchar(50) COMMENT '生产厂商',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '货物库存'
-- Table structure for warehose_storage
-- ----------------------------
DROP TABLE IF EXISTS `warehose_storage`;
CREATE TABLE `warehose_storage`  (
  `goods_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '货物编号',
  `goods_name` varchar(50) COMMENT '货物名',
  `goods_type` varchar(50) COMMENT '货物类别',
  `goods_price` double COMMENT '单价',
  `goods_count` int COMMENT '库存数量',
  `warn_line` double COMMENT '库存预警线(数量不低于)',
  `produce_time` datetime COMMENT '生产日期',
  `purchase_time` datetime COMMENT '购买日期',
  `purchase_staff` varchar(20) COMMENT '购买人',
  `produce_vendor` varchar(50) COMMENT '生产厂商',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '订单管理表'
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_goods`  (
  `order_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '订单编号',
  `order_name` varchar(30) COMMENT '订单名',
  `goods_name` varchar(50) COMMENT '商品名',
  `goods_type` varchar(50) COMMENT '商品类别',
  `goods_price` double COMMENT '单价',
  `order_count` int COMMENT '购买量',
  `cost_count` double COMMENT '总价',
  `order_time` datetime COMMENT '购买时间',
  `staff_id` varchar(20) COMMENT '负责人',
  `delivery_time` datetime COMMENT '交付时间',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '登录表'
-- Table structure for staff_user
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user`  (
  `id` varchar(36) NOT NULL PRIMARY KEY,
  `staff_id` varchar(20) COMMENT '员工编号',
  `user_name` varchar(50) COMMENT '用户名',
  `user_pwd` varchar(50) COMMENT '密码',
  `organize_id` varchar(20) COMMENT '部门编号',
  `user_avatar` varchar(500) COMMENT '头像',
  `user_power` int COMMENT '权限',
  `is_disabled` int COMMENT '是否启用',
  `register_time` datetime COMMENT '注册时间',
  `update_time` datetime COMMENT '更新时间',
  `destroy_time` datetime COMMENT '注销时间',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '邮件信息表'
-- Table structure for mail_info
-- ----------------------------
DROP TABLE IF EXISTS `mail_info`;
CREATE TABLE `mail_info`  (
  `mail_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '邮件编号',
  `staff_id` varchar(20) COMMENT '员工编号',
  `sender_name` varchar(30) COMMENT '发送人',
  `sender_mail` varchar(50) COMMENT '发送邮箱',
  `receiver_name` varchar(30) COMMENT '收件人',
  `receiver_mail` varchar(50) COMMENT '收件邮箱',
  `send_time` datetime COMMENT '发件时间',
  `is_sended` int COMMENT '是否发送成功？',
  `comment` varchar(500) COMMENT '备注'
) 


-- ----------------------------
-- COMMENT '系统日志表'
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `log_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '编号',
  `log_name` varchar(50) COMMENT '日志名称',
  `log_module` varchar(50) COMMENT '来源模块',
  `log_info` varchar(500) COMMENT '日志信息',
  `log_level` int COMMENT '日志等级',
  `log_describe` text COMMENT '描述',
  `in_time` datetime COMMENT '登记时间'
) 





------------ Abandon ------------------


-- ----------------------------
-- COMMENT '系统用户表'
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_name` varchar(30) COMMENT '用户名',
  `user_pwd` varchar(50) COMMENT '密码',
  `user_power` int COMMENT '权限',
  `is_disabled` int COMMENT '是否启用',
  `avatar` varchar(500) COMMENT '头像',
  `register_time` datetime COMMENT '注册时间',
  `update_time` datetime COMMENT '更新时间',
  `destroy_time` datetime COMMENT '注销时间'
) 


-- ----------------------------
-- COMMENT '疾病预警'
-- Table structure for illness_warning
-- ----------------------------
DROP TABLE IF EXISTS `illness_warning`;
CREATE TABLE `illness_warning`  (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `ill_id` varchar(15) COMMENT '疾病编号',
  `ill_type` varchar(50) COMMENT '疾病类别',
  `ill_index` varchar(50) COMMENT '疾病指标',
  `ill_describe` text COMMENT '描述',
  `warn_index` varchar(50) COMMENT '阈值',
) 