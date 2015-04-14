package me.erp.application.security;

import me.erp.domain.model.permission.Permission;
import me.erp.domain.model.role.Role;
import me.erp.domain.service.permission.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * Created by _liwenhe on 2015/3/6.
 */
public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private PathMatcher pathMatcher;

    private static Map<String, List<String>> resourceMap = null;

    public void loadResourceDefine() throws Exception {
        this.resourceMap = new HashMap<String, List<String>>();

        List<Permission> permissions = permissionService.findAll(true);
        for (Permission permission : permissions) {
            List<String> roleList = new ArrayList<String>();
            Set<Role> roles = permission.getRoles();
            for (Role role : roles) {
                roleList.add(role.getRole());
            }
            resourceMap.put(permission.getResource(), roleList);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>();
        while (ite.hasNext()) {
            String resourceUrl = ite.next();
            if (pathMatcher.match(resourceUrl, url)) {
                for (String role : resourceMap.get(resourceUrl)) {
                    ConfigAttribute ca = new SecurityConfig(role);
                    returnCollection.add(ca);
                }
            }
        }
        return returnCollection;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    public void flush() throws Exception {
        resourceMap = null;
        this.loadResourceDefine();
    }
}
