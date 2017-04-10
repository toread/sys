package com.toread.sys.controller;

import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.common.tree.convert.elementTree.ElementTreeConvert;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Menu;
import com.toread.sys.service.IMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author toread
 */
@RestController
public class MenuController {

  private static final Logger log = LoggerFactory.getLogger(MenuController.class);

  @Autowired
  private IMenuService menuService;

  /**
   * 增加一个列表
   *
   * @param menu
   * @return
   */
  @RequestMapping(method = {RequestMethod.POST}, value = APIRout.MenuAPI.ADD)
  public Boolean addMenu(@RequestBody Menu menu) {
    return menuService.addTreeNode(menu);
  }

  /**
   * 删除列表
   *
   * @param menu
   * @return
   */
  @RequestMapping(method = {RequestMethod.POST}, value = APIRout.MenuAPI.DELETE)
  public Boolean deleteMenu(@RequestBody Menu menu) {
    return menuService.deleteTreeNode(menu);
  }

  /**
   * 更新列表
   *
   * @param menu
   * @return
   */
  @RequestMapping(method = {RequestMethod.POST}, value = APIRout.MenuAPI.UPDATE)
  public Boolean updateMenu(@RequestBody Menu menu) {
    return menuService.updateTreeNode(menu);
  }

  /**
   * 获取子节点
   *
   * @param menuPid
   * @return
   */
  @RequestMapping(method = {RequestMethod.POST}, value = APIRout.MenuAPI.GET_CHILDES)
  public List<Menu> getChildes(@RequestBody Long menuPid) {
    Menu menu = new Menu();
    menu.setMenuId(menuPid);
    TreeNode<Menu> treeNode = menuService.buildTree().findTreeNode(menu);
    Menu tagMenu = ElementTreeConvert.convert(treeNode);
    return tagMenu.getChildren();
  }
}
