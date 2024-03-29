-- id: 20
-- name: 30
-- phone: 20
-- email: 50
-- address: 200
-- comment: 255

-- ----------------------------
-- COMMENT '部门表'
-- Table structure for organize_info
-- ----------------------------
DROP TABLE IF EXISTS `organize_info`;
CREATE TABLE `organize_info` (
  `organize_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `organize_name` varchar(30) COMMENT '部门名',
  `organize_type` varchar(20) COMMENT '部门类型',
  `create_time` datetime COMMENT '创建时间',
  `man_count` int COMMENT '部门人数',
  `staff_id` varchar(20) COMMENT '领导编号',
  `organize_leader` varchar(30) COMMENT '领导',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '医师表'   staff_id: ys_001
-- Table structure for staff_doctor
-- ----------------------------
DROP TABLE IF EXISTS `staff_doctor`;
CREATE TABLE `staff_doctor` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_address` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
); 


-- ----------------------------
-- COMMENT '护理人员表'   staff_id: hs_001
-- Table structure for staff_nurse
-- ----------------------------
DROP TABLE IF EXISTS `staff_nurse`;
CREATE TABLE `staff_nurse` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_address` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
);


-- ----------------------------
-- COMMENT '其它员工'    staff_id: yg_001
-- Table structure for organize_staff
-- ----------------------------
DROP TABLE IF EXISTS `organize_staff`;
CREATE TABLE `organize_staff` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '姓名',
  `staff_gender` varchar(10) COMMENT '性别',
  `staff_age` int COMMENT '年龄',
  `staff_phone` varchar(20) COMMENT '电话',
  `staff_email` varchar(50) COMMENT '邮箱',
  `staff_address` varchar(200) COMMENT '住址',
  `organize_id` varchar(20) COMMENT '部门编号',
  `staff_position` varchar(20) COMMENT '职位',
  `entry_time` datetime COMMENT '入职时间',
  `is_resigned` int COMMENT '是否离职',
  `resign_time` datetime COMMENT '离职时间'
); 


-- ----------------------------
-- COMMENT '任务表'
-- Table structure for daily_mission
-- ----------------------------
DROP TABLE IF EXISTS `daily_task`;
CREATE TABLE `daily_task` (
  `task_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '任务编号',
  `task_name` varchar(100) COMMENT '任务名称',
  `patient_id` varchar(36) COMMENT '负责的病人',
  `patient_name` varchar(30) COMMENT '病人姓名',
  `nurse_id` varchar(20) COMMENT '护理员ID',
  `nurse_name` varchar(30) COMMENT '护理员姓名',
  `task_content` text COMMENT '工作内容',
  `created_time` datetime COMMENT '创建时间',
  `is_delay` int COMMENT '是否延期',
  `update_time` datetime COMMENT '更新时间',
  `is_finished` int COMMENT '是否完成',
  `finish_time` datetime COMMENT '完成时间',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '请假申请表'
-- Table structure for vacate_info
-- ----------------------------
DROP TABLE IF EXISTS `vacate_info`;
CREATE TABLE `vacate_info` (
  `id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `organize_name` varchar(30) COMMENT '部门名',
  `organize_type` varchar(20) COMMENT '部门类型',
  `staff_id` varchar(20) COMMENT '申请人编号',
  `staff_name` varchar(30) COMMENT '申请人姓名',
  `vacate_type` varchar(20) COMMENT '请假类别',
  `vacate_reason` varchar(255) COMMENT '请假原因',
  `start_time` datetime COMMENT '开始时间',
  `end_time` datetime COMMENT '结束时间',
  `count_time` double COMMENT '请假天数',
  `auditor_id` varchar(30) COMMENT '审核人编号',
  `auditor_name` varchar(30) COMMENT '审核人姓名',
  `is_approve` int COMMENT '是否批准',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '工资表'
-- Table structure for employee_salary
-- ----------------------------
DROP TABLE IF EXISTS `employee_salary`;
CREATE TABLE `employee_salary` (
  `salary_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `organize_id` varchar(20) COMMENT '部门编号',
  `organize_name` varchar(20) COMMENT '部门名',
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '员工姓名',
  `work_date` varchar(20) COMMENT '月份',
  `work_days` double COMMENT '工作天数',
  `off_days` double COMMENT '请假天数',
  `deduct_count` double COMMENT '罚款',
  `insurance_count` double COMMENT '保险',
  `allowance_count` double COMMENT '补贴',
  `salary_count` double COMMENT '总数',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '工资文件'
-- Table structure for salary_detail_files
-- ----------------------------
DROP TABLE IF EXISTS `salary_detail_files`;
CREATE TABLE `salary_detail_files` (
  `file_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `salary_id` varchar(36) COMMENT '工资编号',
  `staff_id` varchar(20) COMMENT '员工编号',
  `staff_name` varchar(30) COMMENT '员工姓名',
  `file_type` varchar(30) COMMENT '文件类型',
  `file_name` varchar(100) COMMENT '文件名',
  `minio_bucket` varchar(100) COMMENT '桶名',
  `minio_path` varchar(100) COMMENT '存储名称',
  `upload_time` datetime COMMENT '上传时间',
  `update_time` datetime COMMENT '更新时间',
  `is_deleted` int COMMENT '是否删除',
  `comment` varchar(500) COMMENT '备注'
); 


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
); 


-- ----------------------------
-- COMMENT '病人信息表'
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info` (
  `patient_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_name` varchar(30) COMMENT '姓名',
  `in_time` datetime COMMENT '登记时间',
  `patient_gender` varchar(30) COMMENT '性别',
  `patient_age` int COMMENT '年龄',
  `patient_height` double COMMENT '身高(cm)',
  `patient_weight` double COMMENT '体重(kg)',
  `eye_left` double COMMENT '视力 左',
  `eye_right` double COMMENT '视力 右',
  `body_temper` double COMMENT '体温( 摄氏度)',
  `heart_beat` double COMMENT '心率( n/min)',
  `blood_pressure` varchar(30) COMMENT '血压( mmHg)',
  `blood_glucose` varchar(30) COMMENT '血糖',
  `blood_fat` varchar(30) COMMENT '血脂( mmo/L)',
  `body_detail` varchar(255) COMMENT '身体状况',
  `patient_phone` varchar(20) COMMENT '联系电话',
  `patient_address` varchar(100) COMMENT '籍贯住址，联动控件',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '病人联系人信息表'
-- Table structure for patient_contact
-- ----------------------------
DROP TABLE IF EXISTS `patient_contact`;
CREATE TABLE `patient_contact` (
  `id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '编号',
  `contact_name` varchar(50) COMMENT '姓名',
  `contact_phone` varchar(20) COMMENT '电话',
  `is_deleted` int COMMENT '状态',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '病历信息'
-- Table structure for patient_case_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_case_info`;
CREATE TABLE `patient_case_info` (
  `case_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `patient_name` varchar(30) COMMENT '病人姓名',
  `nurse_id` varchar(20) COMMENT '护理员编号',
  `nurse_name` varchar(30) COMMENT '护理员姓名',
  `doctor_id` varchar(20) COMMENT '主治医师编号',
  `doctor_name` varchar(30) COMMENT '主治医师姓名',
  `case_describe` text COMMENT '描述',
  `in_time` datetime COMMENT '入住时间',
  `is_leave` int COMMENT '是否出院',
  `out_time` datetime COMMENT '出院时间',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '病人身体指标信息'
-- Table structure for patient_body_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_body_info`;
CREATE TABLE `patient_body_info` (
  `id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `patient_name` varchar(30) COMMENT '病人姓名',
  `body_temper` double COMMENT '体温(摄氏度)',
  `heart_beat` double COMMENT '心率(n/min)',
  `blood_pressure` varchar(30) COMMENT '血压(mmHg)',
  `blood_glucose` varchar(30) COMMENT '血糖',
  `blood_fat` varchar(30) COMMENT '血脂(mmo/L)',
  `drug_info` varchar(255) COMMENT '用药详情',
  `body_detail` varchar(255) COMMENT '身体状况',
  `in_time` datetime COMMENT '登记时间',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '病例文件'
-- Table structure for patient_case_files
-- ----------------------------
DROP TABLE IF EXISTS `patient_case_files`;
CREATE TABLE `patient_case_files` (
  `file_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `patient_name` varchar(30) COMMENT '病人姓名',
  `cast_id` varchar(36) COMMENT '病历编号',
  `file_type` varchar(30) COMMENT '文件类型',
  `file_name` varchar(100) COMMENT '文件名',
  `minio_bucket` varchar(50) COMMENT '桶名',
  `minio_path` varchar(100) COMMENT '存储名称',
  `upload_time` datetime COMMENT '上传时间',
  `update_time` datetime COMMENT '更新时间',
  `is_deleted` int COMMENT '是否删除'
); 


-- ----------------------------
-- COMMENT '消费信息表'
-- Table structure for patient_cost_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_cost_info`;
CREATE TABLE `patient_cost_info`  (
  `cost_id` varchar(20) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `patient_id` varchar(36) COMMENT '病人编号',
  `patient_name` varchar(30) COMMENT '病人姓名',
  `doctor_id` varchar(30) COMMENT '医师Id',
  `doctor_name` varchar(30) COMMENT '医师名',
  `in_time` datetime COMMENT '入院时间',
  `out_time` datetime COMMENT '出院时间',
  `cost_count` double COMMENT '总价',
  `is_pay` int COMMENT '是否结算',
  `pay_time` datetime COMMENT '付款时间',
  `comment` varchar(500) COMMENT '备注'
);


-- ----------------------------
-- COMMENT '消费详情信息'
-- Table structure for patient_cost_detail
-- ----------------------------
DROP TABLE IF EXISTS `patient_cost_detail`;
CREATE TABLE `patient_cost_detail`  (
    `id` varchar(20) NOT NULL PRIMARY KEY COMMENT '主键ID',
    `cost_id` varchar(20) COMMENT '消费关联字段',
    `goods_type` varchar(50) COMMENT '类别',
    `goods_name` varchar(50) COMMENT '名称',
    `goods_price` double COMMENT '单价',
    `goods_number` int COMMENT '数量',
    `cost_count` double COMMENT '总价',
    `comment` varchar(500) COMMENT '备注'
);


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
); 


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
); 


-- ----------------------------
-- COMMENT '货物库存'
-- Table structure for warehouse_storage
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_storage`;
CREATE TABLE `warehouse_storage`  (
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
); 


-- ----------------------------
-- COMMENT '订单管理表'
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods`  (
  `order_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '订单编号',
  `order_name` varchar(30) COMMENT '订单名',
  `goods_name` varchar(50) COMMENT '商品名',
  `goods_type` varchar(50) COMMENT '商品类别',
  `goods_price` double COMMENT '单价',
  `order_count` int COMMENT '购买量',
  `cost_count` double COMMENT '总价',
  `order_time` datetime COMMENT '购买时间',
  `staff_id` varchar(20) COMMENT '负责人Id',
  `staff_name` varchar(30) COMMENT '负责人姓名',
  `delivery_time` datetime COMMENT '交付时间',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '物资申请表'
-- Table structure for asset_apply_info
-- ----------------------------
DROP TABLE IF EXISTS `asset_apply_info`;
CREATE TABLE `asset_apply_info`  (
  `apply_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '申请订单编号',
  `organize_unit` varchar(30) COMMENT '申请单位，冗余字段',
  `organize_name` varchar(30) COMMENT '申请部门',
  `staff_id` varchar(20) COMMENT '申请人',
  `staff_name` varchar(30) COMMENT '申请人姓名',
  `apply_time` datetime COMMENT '申请时间',
  `apply_reason` varchar(255) COMMENT '申请原因',
  `receive_name` varchar(30) COMMENT '收件人',
  `receive_phone` varchar(30) COMMENT '收件电话',
  `receive_address` varchar(100) COMMENT '收货地址',
  `cost_money` double COMMENT '总金额',
  `current_state` int COMMENT '当前状态',
  `is_finished` int COMMENT '是否完成',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '物资申请关联表'
-- Table structure for asset_apply_goods
-- ----------------------------
DROP TABLE IF EXISTS `asset_apply_goods`;
CREATE TABLE `asset_apply_goods`  (
  `id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `apply_id` varchar(36) COMMENT '申请订单编号',
  `goods_name` varchar(50) COMMENT '商品名',
  `goods_type` varchar(50) COMMENT '商品规格',
  `goods_price` double COMMENT '单价',
  `apply_count` int COMMENT '申请量',
  `cost_money` double COMMENT '总价',
  `comment` varchar(500) COMMENT '备注'
); 


-- ----------------------------
-- COMMENT '登录表'
-- Table structure for login_user
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user`  (
  `id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
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
); 


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
); 


-- ----------------------------
-- COMMENT '系统日志表'
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `log_id` varchar(36) NOT NULL PRIMARY KEY COMMENT '主键ID',
  `log_name` varchar(50) COMMENT '日志名称',
  `log_module` varchar(50) COMMENT '来源模块',
  `log_info` varchar(500) COMMENT '日志信息',
  `log_level` int COMMENT '日志等级',
  `log_describe` text COMMENT '描述',
  `in_time` datetime COMMENT '登记时间',
  `is_handle` int COMMENT '是否处理'
); 


-- ----------------------------
-- COMMENT '系统菜单表'
-- Table structure for home_menu
-- ----------------------------
DROP TABLE IF EXISTS `home_menu`;
CREATE TABLE `home_menu`  (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  `menu_key` varchar(50) COMMENT '菜单索引',
  `menu_type` varchar(50) COMMENT '菜单类型',
  `menu_icon` varchar(50) COMMENT '菜单图标',
  `menu_title` varchar(50) COMMENT '菜单名称',
  `router_name` varchar(50) COMMENT '路由地址',
  `is_show` int(11) COMMENT '是否展示'
);


-- ----------------------------
-- COMMENT '系统文件配置表'
-- Table structure for file_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_config`;
CREATE TABLE `sys_file_config`  (
    `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    `sys_type` varchar(50) COMMENT '系统类别',
    `unit_type` varchar(50) COMMENT '单位类别',
    `case_bucket` varchar(50) COMMENT '病例文件桶名',
    `salary_bucket` varchar(50) COMMENT '工资文件桶名',
    `avatar_bucket` varchar(50) COMMENT '头像文件桶名',
    `storage_bucket` varchar(50) COMMENT '仓库文件桶名',
    `comment` varchar(500) COMMENT '备注'
);





-- ---------- Abandon ------------------


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
); 


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
  `warn_index` varchar(50) COMMENT '阈值'
); 