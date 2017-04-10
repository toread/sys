/*
Navicat MySQL Data Transfer

Source Server         : 51数据库
Source Server Version : 50717
Source Host           : 100.73.12.50:3306
Source Database       : access_ctl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-10 22:21:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `dpt_id` bigint(20) NOT NULL COMMENT '部门主键',
  `dpt_pid` bigint(20) NOT NULL COMMENT '父部门id',
  `dpt_name` varchar(64) NOT NULL COMMENT '部门名称',
  `dpt_type` varchar(2) NOT NULL COMMENT '部门类型',
  `dpt_state` int(11) NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`dpt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('1', '0', '市委', '1', '1');
INSERT INTO `sys_department` VALUES ('848187607425101824', '1', '办公室', '1', '1');
INSERT INTO `sys_department` VALUES ('848187607597068288', '848187607425101824', '秘书组', '2', '1');
INSERT INTO `sys_department` VALUES ('848187607676760064', '848187607597068288', '监理秘书', '2', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单主键',
  `menu_name` varchar(32) NOT NULL COMMENT '菜单名字',
  `menu_icon` varchar(32) NOT NULL COMMENT '图标',
  `menu_url` varchar(64) DEFAULT NULL COMMENT '资源URL',
  `menu_pid` bigint(20) NOT NULL COMMENT '菜单主键',
  `menu_state` varchar(2) NOT NULL COMMENT '状态',
  `menu_order` int(11) NOT NULL COMMENT '排序',
  `menu_c_time` datetime NOT NULL COMMENT '创建时间',
  `menu_u_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '资源树', 'home', null, '1', '1', '1', '2017-04-06 15:24:58', '2017-04-06 15:24:58');
INSERT INTO `sys_menu` VALUES ('849885626806419456', '权限管理', 'ios-locked', null, '1', '1', '1', '2017-04-06 15:24:58', '2017-04-06 15:24:58');
INSERT INTO `sys_menu` VALUES ('849885627146158080', '机构管理', 'ios-people', null, '1', '1', '2', '2017-04-06 15:24:58', '2017-04-06 15:24:58');
INSERT INTO `sys_menu` VALUES ('849885627146158088', '菜单管理', 'android-menu', null, '849885626806419456', '1', '1', '2017-04-06 15:24:58', '2017-04-06 15:24:58');

-- ----------------------------
-- Table structure for sys_resouce_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_resouce_menu`;
CREATE TABLE `sys_resouce_menu` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `res_id` bigint(20) NOT NULL COMMENT '资源id',
  `c_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resouce_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `res_id` bigint(20) NOT NULL COMMENT '资源uuid',
  `res_type` varchar(2) NOT NULL COMMENT '资源类型',
  `res_name` varchar(18) NOT NULL COMMENT '资源名称',
  `res_val` varchar(256) NOT NULL COMMENT '资源值',
  `res_state` varchar(2) NOT NULL COMMENT '资源状态',
  `res_c_time` datetime NOT NULL COMMENT '创建时间',
  `res_u_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '1', '用户添加', '/user/add', '1', '2017-02-10 07:19:09', '2017-02-10 07:19:09');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色uuid',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_state` varchar(2) NOT NULL COMMENT '角色状态',
  `role_c_time` datetime NOT NULL COMMENT '创建时间',
  `role_u_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('821994218194960384', '传奇世界', '1', '2017-01-19 16:14:28', '2017-01-19 16:14:28');
INSERT INTO `sys_role` VALUES ('847989095895441408', '官员员', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');
INSERT INTO `sys_role` VALUES ('847989096616861696', '官员员', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');
INSERT INTO `sys_role` VALUES ('847989097040486400', '官员员', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色uuid',
  `res_id` bigint(20) NOT NULL COMMENT '资源uuid',
  `c_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '1', '1', '2017-02-10 07:19:10');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `user_code` varchar(18) NOT NULL COMMENT '用户登陆代码',
  `user_pwd` varchar(128) NOT NULL COMMENT '用户密码',
  `user_state` varchar(2) NOT NULL COMMENT '用户状态',
  `user_c_time` datetime NOT NULL COMMENT '创建时间',
  `user_u_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('818754958872956928', 'chuanqi122212', 'b85bf0f7330be07933314afcfc04aa8e8bb33827eb03bdf2f65ff26fd32444f5', '1', '2017-01-10 17:42:49', '2017-04-02 00:12:41');
INSERT INTO `sys_user` VALUES ('847989095748640768', 'toread', 'toread', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');
INSERT INTO `sys_user` VALUES ('847989096377786368', 'toread', 'toread', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');
INSERT INTO `sys_user` VALUES ('847989096923045888', 'toread', 'toread', '1', '2017-04-01 09:48:50', '2017-04-01 09:48:50');
INSERT INTO `sys_user` VALUES ('848188558647115776', '1212', 'b8dc2c143be8994682b08461f46487e05874e59dd9ab65cf973e3a3c67a763aa', '0', '2017-04-01 23:01:26', '2017-04-01 23:01:26');
INSERT INTO `sys_user` VALUES ('848188640192774144', '121212', 'e4c08f0ad22e548723c18d8c5c7a4b0f43f31826233f958c99bfa0d3e764d8d4', '0', '2017-04-01 23:01:45', '2017-04-01 23:01:45');
INSERT INTO `sys_user` VALUES ('848189373407444992', '21212', '496645fd7fc9302bc9955b4439722cdfd81a20b5eff797e5392e243f9cc86184', '1', '2017-04-01 23:04:40', '2017-04-01 23:04:40');
INSERT INTO `sys_user` VALUES ('848189373407445000', '453434343', '57896f11d4419bc4236a297dafc6b65e32ae1a55b5c8407cb1891980c4f681c2', '1', '2017-04-01 23:04:49', '2017-04-01 23:04:49');
INSERT INTO `sys_user` VALUES ('848189909603074048', '12121', 'b30d5a635ec13790993bab2f9b865d11ab6c0e24247c1d12ed291a93d8b61147', '0', '2017-04-01 23:06:48', '2017-04-01 23:06:48');
INSERT INTO `sys_user` VALUES ('848215290150256640', '2121', '3a8beeca27a2d08c0b77ef20ad08d6f16665177b4b848475719384e2bf298001', '1', '2017-04-02 00:47:39', '2017-04-02 00:47:39');
INSERT INTO `sys_user` VALUES ('849648799259754496', '2323232232', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '1', '2017-04-05 23:43:54', '2017-04-05 23:43:54');
INSERT INTO `sys_user` VALUES ('849648994957590528', '212121从第三发', 'fa06649d2452dd59fdca38d6e2d2c733282e6afe63957b617e6668c4f18e8842', '1', '2017-04-05 23:44:41', '2017-04-05 23:44:41');
INSERT INTO `sys_user` VALUES ('849649059050749952', '12121212121', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '1', '2017-04-05 23:44:56', '2017-04-05 23:44:56');
INSERT INTO `sys_user` VALUES ('849649402073513984', '122121212121', '35d98600430a7811aefeef1566afbf5f5e51309c508485a4f073c86147e85200', '1', '2017-04-05 23:46:18', '2017-04-05 23:46:18');

-- ----------------------------
-- Table structure for sys_user_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_department`;
CREATE TABLE `sys_user_department` (
  `id` bigint(20) NOT NULL COMMENT '用户部门id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `dpt_id` bigint(20) NOT NULL COMMENT '部门id',
  `c_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_department
-- ----------------------------
INSERT INTO `sys_user_department` VALUES ('818754959019757568', '818754958872956928', '1', '2017-01-10 17:42:49');
INSERT INTO `sys_user_department` VALUES ('848188559200763904', '848188558647115776', '1', '2017-04-01 23:01:26');
INSERT INTO `sys_user_department` VALUES ('848188640297631744', '848188640192774144', '1', '2017-04-01 23:01:45');
INSERT INTO `sys_user_department` VALUES ('848189373524885504', '848189373407444992', '1', '2017-04-01 23:04:40');
INSERT INTO `sys_user_department` VALUES ('848189409977581568', '848189373407445000', '1', '2017-04-01 23:04:49');
INSERT INTO `sys_user_department` VALUES ('848189909695348736', '848189909603074048', '1', '2017-04-01 23:06:48');
INSERT INTO `sys_user_department` VALUES ('848215290271891456', '848215290150256640', '1', '2017-04-02 00:47:39');
INSERT INTO `sys_user_department` VALUES ('849648800224444416', '849648799259754496', '1', '2017-04-05 23:43:54');
INSERT INTO `sys_user_department` VALUES ('849648995091808256', '849648994957590528', '1', '2017-04-05 23:44:41');
INSERT INTO `sys_user_department` VALUES ('849649059218522112', '849649059050749952', '1', '2017-04-05 23:44:56');
INSERT INTO `sys_user_department` VALUES ('849649402300006400', '849649402073513984', '1', '2017-04-05 23:46:18');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户uuid',
  `role_id` bigint(20) NOT NULL COMMENT '角色uuid',
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '818754958872956928', '821994218194960384', '2017-02-10 07:19:08');
INSERT INTO `sys_user_role` VALUES ('44', '818754958872956928', '821994218194960384', '2017-02-10 07:14:22');
INSERT INTO `sys_user_role` VALUES ('847989096168071168', '847989095748640768', '847989095895441408', null);
INSERT INTO `sys_user_role` VALUES ('847989096692359168', '847989096377786368', '847989096616861696', null);
INSERT INTO `sys_user_role` VALUES ('847989097174704128', '847989096923045888', '847989097040486400', null);
