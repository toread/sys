package com.toread.sys.service.impl;

import com.toread.sys.common.tree.service.SimpleTreeServiceImpl;
import com.toread.sys.entity.Menu;
import com.toread.sys.mapper.MenuMapper;
import com.toread.sys.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 *
 * Menu 表数据服务层接口实现类
 *
 */
@Service
public class MenuServiceImpl extends SimpleTreeServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    protected Class<Menu> getEntityClass() {
        return Menu.class;
    }

    @Override
    protected String keyName() {
        return IMenuService.TREE_KEY;
    }

    @Override
    protected Object rootId() {
        return 1l;
    }
}