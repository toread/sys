package com.toread.sys.service;

import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.service.SimpleTreeService;
import com.toread.sys.entity.Menu;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * Menu 表数据服务层接口
 *
 */
public interface IMenuService extends SimpleTreeService<Menu> {
    String TREE_KEY = "MENU_TREE";
}