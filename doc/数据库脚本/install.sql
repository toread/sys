CREATE TABLE accctl_resources
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '资源uuid' AUTO_INCREMENT,
    type VARCHAR(2) NOT NULL COMMENT '资源类型',
    name VARCHAR(18) NOT NULL COMMENT '资源名称',
    val VARCHAR(256) NOT NULL COMMENT '资源值',
    state VARCHAR(2) NOT NULL COMMENT '资源状态',
    c_time DATETIME NOT NULL COMMENT '创建时间',
    u_time DATETIME COMMENT '更新时间'
);
CREATE TABLE accctl_role
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '角色uuid' AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL COMMENT '角色名称',
    state VARCHAR(2) NOT NULL COMMENT '角色状态',
    c_time DATETIME NOT NULL COMMENT '创建时间',
    u_time DATETIME COMMENT '修改时间'
);
CREATE TABLE accctl_role_resources
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键' AUTO_INCREMENT,
    role_id BIGINT(20) NOT NULL COMMENT '角色uuid',
    resources_id BIGINT(20) NOT NULL COMMENT '资源uuid',
    c_time DATETIME COMMENT '创建时间'
);
CREATE TABLE accctl_user
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '用户主键',
    code VARCHAR(18) NOT NULL COMMENT '用户登陆代码',
    pwd VARCHAR(18) NOT NULL COMMENT '用户密码',
    state VARCHAR(2) NOT NULL COMMENT '用户状态',
    c_time DATETIME NOT NULL COMMENT '创建时间',
    u_time DATETIME COMMENT '修改时间'
);
CREATE TABLE accctl_user_role
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键' AUTO_INCREMENT,
    user_id BIGINT(20) NOT NULL COMMENT '用户uuid',
    role_id BIGINT(20) NOT NULL COMMENT '角色uuid',
    c_time DATETIME COMMENT '创建时间'
);
CREATE UNIQUE INDEX resources_type_value ON accctl_resources (type, val);