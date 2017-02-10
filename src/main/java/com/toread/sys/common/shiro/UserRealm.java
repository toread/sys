package com.toread.sys.common.shiro;

import com.toread.sys.common.enums.State;
import com.toread.sys.common.validator.Check;
import com.toread.sys.entity.Resource;
import com.toread.sys.entity.Role;
import com.toread.sys.entity.User;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleService;
import com.toread.sys.service.IUserService;
import com.toread.sys.utils.FormatUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 黎志兵
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(null);
        User user = userService.queryEnableUserByUserName(username);
        Check.notNull(user, FormatUtils.format("{0}用户不存在", username));
        List<Role> roles = iRoleService.queryUserRole(user.getUserId(), State.ENABLED);
        List<String> roleIds = new ArrayList<>();
        for (Role role : roles) {
            roleIds.add(role.getRoleId().toString());
        }
        info.addRoles(roleIds);
        Set<Resource> resources = resourceService.queryUserResources(user.getUserId(), State.ENABLED);
        Set<String> hashSet = new HashSet<>(resources.size());
        for (Resource resource : resources) {
            hashSet.add(resource.getResVal());
        }
        info.addStringPermissions(hashSet);
        info.addStringPermission("/user/add");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUserCode(upt.getUsername());
        user.setUserPwd(new String(upt.getPassword()));
        SimpleAuthenticationInfo info = null;
        Check.isTrue(userService.userLogin(user), "用户登录未成功");
        info = new SimpleAuthenticationInfo(user.getUserCode(), user.getUserPwd(), getName());
        return info;
    }
}
