package com.toread.sys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.service.BaseService;
import com.toread.sys.entity.User;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends BaseService<User,Long> {
    /**
     * 增加用户
     * @param user
     * @param departmentId
     */
    void addUser(User user,Long departmentId);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);

    /**
     *
     * @param user
     * @return
     */
    boolean userLogin(User user);

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    Page<User> queryUsers(PageInfo<User> page, User user);
}