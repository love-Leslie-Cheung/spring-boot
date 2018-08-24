-- Table: 员工表
CREATE TABLE t_staff (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	code VARCHAR(255),
	name VARCHAR(255),
	idCard VARCHAR(255),
	phone VARCHAR(255),
	email VARCHAR(255),
	department VARCHAR(255),
	position VARCHAR(255),
	hiredate DATE
);

-- Table: 用户表
CREATE TABLE t_user (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	login_name VARCHAR(255) NOT NULL UNIQUE COMMENT '用户名',
	salt VARCHAR(255) COMMENT '盐',
	password VARCHAR(255) NOT NULL COMMENT '密码',
	state BIT DEFAULT 1 COMMENT '是否启用',
	username VARCHAR(255) COMMENT '用户名',
	role_id BIGINT COMMENT '角色ID，便于前端显示',
	add_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间'
);

-- Table: 权限表
CREATE TABLE t_permission (
  id   BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(255) COMMENT '权限描述',
  permission VARCHAR(255) COMMENT '权限字符串',
  url VARCHAR(255) COMMENT '赋权路径'
);

-- Table: 角色表
CREATE TABLE t_role (
	id BIGINT PRIMARY KEY NOT NULL,
	available BIT COMMENT '是否可用',
	role VARCHAR(255) COMMENT '角色字符串',
	description VARCHAR(255) COMMENT '角色描述'
);

-- Table: 角色-权限关系表
CREATE TABLE rt_role_permission (
  id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  role_id BIGINT NOT NULL COMMENT '角色ID',
  permission_id BIGINT NOT NULL COMMENT '权限ID'
);

-- Table: 用户-角色关系表
CREATE TABLE rt_user_role (
  id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id BIGINT NOT NULL COMMENT '用户ID',
	role_id BIGINT NOT NULL COMMENT '角色ID'
);

-- Table: 历史记录表
CREATE TABLE t_history (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	operator_code VARCHAR(255),
	operation_target VARCHAR(255) COMMENT '操作员',
	operation_type VARCHAR(255) COMMENT '操作类型',
	operating_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
	operate_result VARCHAR(255) COMMENT '操作结果'
);

-- Table: 薪资表
CREATE TABLE t_salary (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	code VARCHAR(255),
	name VARCHAR(255),
	basic_wage_should_be_issued VARCHAR(30),
	weekend_fixed_overtime_wage_should_be_issued VARCHAR(30),
	post_allowance_should_be_issued VARCHAR(30),
	performance_allowance_should_be_issued VARCHAR(30),
	total_contract_wages VARCHAR(30),
	seniority_allowance VARCHAR(30),
	meal_allowance VARCHAR(30),
	other_allowance VARCHAR(30),
	other_pre_tax_buckle VARCHAR(30),
	total_payroll_should_be_issued VARCHAR(30),
	real_basic_salary VARCHAR(30),
	fixed_overtime_pay_for_the_weekend VARCHAR(30),
	real_post_allowance VARCHAR(30),
	real_performance_allowance VARCHAR(30),
	sick_pay VARCHAR(30),
	total_pre_tax_wages VARCHAR(30),
	social_security VARCHAR(30),
	total_housing_provident_fund VARCHAR(30),
	income_tax_on_personal_incom VARCHAR(30),
	dormitory_expense VARCHAR(30),
	utilities_expense VARCHAR(30),
	mutual_fund VARCHAR(30),
	telephone_fare VARCHAR(30),
	network_fee VARCHAR(30),
	other_supplementary_deductions_after_tax VARCHAR(30),
	real_payroll VARCHAR(30),
	real_bonus VARCHAR(30),
	total VARCHAR(30)
);

-- t_email_config
create table t_email_config(
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  host VARCHAR(255) COMMENT '邮件服务器',
  port VARCHAR(255) COMMENT '发送端口',
  send_email VARCHAR(255) COMMENT '发送邮箱',
  password VARCHAR(255) COMMENT '发送密码'
);

-- INSERT INTO t_staff (code, name, idCard, phone, email, position, department, hiredate)
-- VALUES ('DM10001', 'Peter', '1234567890', '1356666666', 'peter@cygia.com', '', '', '2018-07-07');
-- INSERT INTO t_staff (code, name, idCard, phone, email, position, department, hiredate)
-- VALUES ('DM10002', 'Demo', '5656565656', '1355555555', 'demo@cygia.com', '', '', '2018-02-03');

INSERT INTO t_user (login_name, salt, password, state, username) VALUES ('admin', 'admin', 'a309d76c2ae0b8215a99a3f099674c3f', 1, 'Admin');

INSERT INTO t_role VALUES (1, 1, 'admin', '管理员');
INSERT INTO t_role VALUES (2, 1, 'user', '用户');

INSERT INTO hyacinth.t_permission VALUES (1, '系统设置', 'system:setting', '/views/systemSetting');
INSERT INTO hyacinth.t_permission VALUES (2, '添加用户', 'user:add', '/views/user/add');
INSERT INTO hyacinth.t_permission VALUES (3, '删除用户', 'user:delete', '/views/user/delete');
INSERT INTO hyacinth.t_permission VALUES (4, '查询用户信息', 'user:query', '/views/user/userManagement');
INSERT INTO hyacinth.t_permission VALUES (5, '更新用户信息', 'user:update', '/views/user/update');

INSERT INTO hyacinth.rt_role_permission(role_id, permission_id) VALUES (1, 1);
INSERT INTO hyacinth.rt_role_permission(role_id, permission_id) VALUES (1, 2);
INSERT INTO hyacinth.rt_role_permission(role_id, permission_id) VALUES (1, 3);
INSERT INTO hyacinth.rt_role_permission(role_id, permission_id) VALUES (1, 4);
INSERT INTO hyacinth.rt_role_permission(role_id, permission_id) VALUES (1, 5);

INSERT INTO rt_user_role(user_id, role_id) VALUES (1, 1);
UPDATE t_user set role_id = 1 WHERE id = 1;

-- INSERT INTO hyacinth.t_history (id, code, operator, operation_type, operating_time, operate_result) VALUES (1, 'DM10001', 'Peter', '修改个人密码', '2018-07-13 06:41:23', '成功');
-- INSERT INTO hyacinth.t_history (id, code, operator, operation_type, operating_time, operate_result) VALUES (2, 'DM10002', 'Demo', '修改个人密码', '2018-07-13 06:42:14', '成功');
-- INSERT INTO hyacinth.t_history (id, code, operator, operation_type, operating_time, operate_result) VALUES (3, 'DM10001', 'Peter', '修改用户密码', '2018-07-13 06:43:00', '成功');
-- INSERT INTO hyacinth.t_history (id, code, operator, operation_type, operating_time, operate_result) VALUES (4, 'DM10002', 'Demo', '导入员工信息', '2018-07-13 06:43:40', '成功');
-- INSERT INTO hyacinth.t_history (id, code, operator, operation_type, operating_time, operate_result) VALUES (5, 'DM10002', 'Demo', '导入薪资信息', '2018-07-13 06:44:03', '成功');