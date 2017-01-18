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

    //用户模块
    public static class  roleAPI{
        public static final String DELETE="/user/delete";      //删除用户
        public static final String ADD="/user/add";            //更新用户
        public static final String UPDATE="/user/update";      //增加用户
        public static final String QUERY="/user/query";      //查询用户
    }

    /**
     * 资源模块
     */
    public static class RoleAPI{
        public static final String DELETE="/role/delete";      //删除资源
        public static final String ADD="/role/add";            //更新资源
        public static final String UPDATE="/role/update";      //增加资源
        public static final String QUERY="/role/query";       //查询资源
    }

}
