package com.toread.sys.service;

import com.toread.sys.entity.User;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends ISuperService<User> {
    /**
     * 增加用户
     * @param user
     * @param departmentId
     */
    void addUser(User user,Long departmentId);

    /**
     * 删除用户
     * @param user
     * @param departmentId
     */
    void deleteUser(User user,Long departmentId);

    /**
     *
     * @param user
     * @return
     */
    boolean userLogin(User user);
}