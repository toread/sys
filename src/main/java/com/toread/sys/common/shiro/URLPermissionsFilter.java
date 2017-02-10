package com.toread.sys.common.shiro;

import com.toread.sys.config.APIRout;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component("urlPermissionsFilter")
public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(URLPermissionsFilter.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IResourceService resourceService;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        String url = getRequestUrl(request);
        if (url.equals(getLoginUrl()) || url.equals(APIRout.UserAPI.LOGIN)) {
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject.isPermitted(url)) {
            return true;
        }
        return false;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        saveRequestAndRedirectToLogin(request, response);
        return false;
    }

    /**
     * 获取当前URL+Parameter
     *
     * @param request 拦截请求request
     * @return 返回完整URL
     * @author lance
     * @since 2014年12月18日 下午3:09:26
     */
    private String getRequestUrl(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        String queryString = req.getQueryString();

        queryString = StringUtils.isBlank(queryString) ? "" : "?" + queryString;
        return req.getRequestURI() + queryString;
    }
}
