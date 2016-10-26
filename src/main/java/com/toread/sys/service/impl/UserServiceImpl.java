package com.toread.sys.service.impl;

import org.springframework.stereotype.Service;

import com.toread.sys.mapper.UserMapper;
import com.toread.sys.entity.User;
import com.toread.sys.service.IUserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {


}