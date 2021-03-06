package com.toread.sys.controller;

import com.alibaba.fastjson.JSON;
import com.toread.sys.entity.Menu;
import com.toread.sys.service.IMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author toread
 */
@RestController
@RequestMapping(path = "/menu")
public class MenuController {

    private static  final Logger log = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private IMenuService menuService;

    /**
     * 增加一个列表
     * @param menu
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "add")
    public Boolean addMenu(Menu menu){
        return menuService.addTreeNode(menu);
    }

    /**
     * 删除列表
     * @param menu
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "delete")
    public Boolean deleteMenu(Menu menu){
        return  menuService.deleteTreeNode(menu);
    }

    /**
     * 更新列表
     * @param menu
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "update")
    public Boolean updateMenu(Menu menu){
        return menuService.updateTreeNode(menu);
    }

    /**
     * 获取子节点
     * @param menuPid
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},path = "getChildes")
    public List<Menu> getChildes(@RequestParam("pid") Long menuPid){
        List<Menu> menus =  menuService.findChildes(menuPid);
        log.info(JSON.toJSONString(menus));
        return  menus;
    }
}
