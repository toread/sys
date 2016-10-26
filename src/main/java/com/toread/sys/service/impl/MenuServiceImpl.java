package com.toread.sys.service.impl;

import org.springframework.stereotype.Service;

import com.toread.sys.mapper.MenuMapper;
import com.toread.sys.entity.Menu;
import com.toread.sys.service.IMenuService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Menu 表数据服务层接口实现类
 *
 */
@Service
public class MenuServiceImpl extends SuperServiceImpl<MenuMapper, Menu> implements IMenuService {


}