package com.toread.sys.config;

/**
 * @author 黎志兵
 */
public class APIRout {
    //机构模块
   public static class  DeptAPI{
       public static final String DELETE="/depart/delete";      //删除机构
       public static final String ADD="/depart/add";            //更新机构
       public static final String UPDATE="/depart/update";      //增加机构
       public static final String CHILDES="/depart/childes";    //获取子节点
   }

}
