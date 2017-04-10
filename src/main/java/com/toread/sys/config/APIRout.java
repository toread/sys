package com.toread.sys.config;

/**
 * @author 黎志兵
 */
public class APIRout {
  public static class COMMON {
    public static final String LOGIN_PAGE = "/login";
  }

  //机构模块
  public static class DeptAPI {
    public static final String DELETE = "/depart/delete";      //删除机构
    public static final String ADD = "/depart/add";            //更新机构
    public static final String UPDATE = "/depart/update";      //增加机构
    public static final String CHILDES = "/depart/childes";    //获取子节点
    public static final String BIND_USER_DEPART = "/depart/bindUserDepart";    //绑定机构
    public static final String UN_BIND_USER_DEPART = "/depart/unBindUserDepart";    //取消绑定机构
  }

  //用户模块
  public static class UserAPI {
    public static final String DELETE = "/user/delete";      //删除用户
    public static final String ADD = "/user/add";            //更新用户
    public static final String UPDATE = "/user/update";      //增加用户
    public static final String QUERY = "/user/query";        //查询用户
    public static final String LOGIN = "/user/login";        //用户登录
    public static final String LOGOUT = "/user/logout";      //用户退出
  }

  /**
   * 角色模块
   */
  public static class RoleAPI {
    public static final String DELETE = "/role/delete";      //删除资源
    public static final String ADD = "/role/add";            //更新资源
    public static final String UPDATE = "/role/update";      //增加资源
    public static final String QUERY = "/role/query";       //查询资源
    public static final String BIND_USER_ROLE = "/role/bindUserRole";       //用户绑定角色
    public static final String UN_BIND_USER_ROLE = "/role/unBindUserRole";  //用户解绑角色
  }

  /**
   * 资源模块
   */
  public static class ResourceAPI {
    public static final String DELETE = "/resource/delete";      //删除资源
    public static final String ADD = "/resource/add";            //更新资源
    public static final String UPDATE = "/resource/update";      //增加资源
    public static final String QUERY = "/resource/query";       //查询资源
    public static final String UN_BIND_ROLE_RESOURCE = "/resource/unBindRoleResource";   //解绑
    public static final String BIND_ROLE_RESOURCE = "/resource/bindRoleResource";       //查询资源
  }

  /**
   * 菜单模块
   */
  public static class MenuAPI {
    public static final String ADD = "/menu/add";           //增加菜单
    public static final String DELETE = "/menu/delete";     //删除菜单
    public static final String UPDATE = "/menu/update";        //更新菜单
    public static final String GET_CHILDES = "/menu/getChildes";    //获取子菜单
  }


}
