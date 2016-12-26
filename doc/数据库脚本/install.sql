CREATE  DATABASE  access_ctl DEFAULT  CHAR SET   utf8 COLLATE utf8_general_ci;

use mysql;
CREATE TABLE sys_department
(
    dpt_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '部门主键',
    dpt_pid BIGINT(20) NOT NULL COMMENT '父部门id',
    dpt_name VARCHAR(64) NOT NULL COMMENT '部门名称',
    dpt_type VARCHAR(2) NOT NULL COMMENT '部门类型'
);
CREATE TABLE sys_menu
(
    menu_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '菜单主键',
    menu_name VARCHAR(32) NOT NULL COMMENT '菜单名字',
    menu_icon VARCHAR(32) NOT NULL COMMENT '图标',
    menu_pid BIGINT(20) NOT NULL COMMENT '菜单主键',
    menu_state VARCHAR(2) NOT NULL COMMENT '状态',
    menu_order INT(11) NOT NULL COMMENT '排序',
    menu_c_time DATETIME NOT NULL COMMENT '创建时间',
    menu_u_time DATETIME COMMENT '更新时间'
);
CREATE TABLE sys_resouce_menu
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
    menu_id BIGINT(20) NOT NULL COMMENT '菜单ID',
    res_id BIGINT(20) NOT NULL COMMENT '资源id',
    c_time DATETIME NOT NULL COMMENT '创建时间'
);
CREATE TABLE sys_resource
(
    res_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '资源uuid',
    res_type VARCHAR(2) NOT NULL COMMENT '资源类型',
    res_name VARCHAR(18) NOT NULL COMMENT '资源名称',
    res_val VARCHAR(256) NOT NULL COMMENT '资源值',
    res_state VARCHAR(2) NOT NULL COMMENT '资源状态',
    res_c_time DATETIME NOT NULL COMMENT '创建时间',
    res_u_time DATETIME COMMENT '更新时间'
);
CREATE TABLE sys_role
(
    role_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '角色uuid',
    role_name VARCHAR(32) NOT NULL COMMENT '角色名称',
    role_state VARCHAR(2) NOT NULL COMMENT '角色状态',
    role_c_time DATETIME NOT NULL COMMENT '创建时间',
    role_u_time DATETIME COMMENT '修改时间'
);
CREATE TABLE sys_role_resource
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
    role_id BIGINT(20) NOT NULL COMMENT '角色uuid',
    res_id BIGINT(20) NOT NULL COMMENT '资源uuid',
    c_time DATETIME NOT NULL COMMENT '创建时间'
);
CREATE TABLE sys_user
(
    user_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '用户主键',
    user_code VARCHAR(18) NOT NULL COMMENT '用户登陆代码',
    user_pwd VARCHAR(18) NOT NULL COMMENT '用户密码',
    user_state VARCHAR(2) NOT NULL COMMENT '用户状态',
    user_c_time DATETIME NOT NULL COMMENT '创建时间',
    user_u_time DATETIME COMMENT '修改时间'
);
CREATE TABLE sys_user_department
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '用户部门id',
    user_id BIGINT(20) NOT NULL COMMENT '用户id',
    dpt_id BIGINT(20) NOT NULL COMMENT '部门id',
    c_time DATETIME NOT NULL COMMENT '创建时间'
);
CREATE TABLE sys_user_role
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
    user_id BIGINT(20) NOT NULL COMMENT '用户uuid',
    role_id BIGINT(20) NOT NULL COMMENT '角色uuid',
    c_time DATETIME COMMENT '创建时间'
);