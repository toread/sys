package com.toread.sys.service;

import com.toread.sys.common.tree.service.SimpleTreeService;
import com.toread.sys.entity.Menu;

/**
 *
 * Menu 表数据服务层接口
 *
 */
public interface IMenuService extends SimpleTreeService<Menu> {
    String TREE_KEY = "MENU_TREE";
}