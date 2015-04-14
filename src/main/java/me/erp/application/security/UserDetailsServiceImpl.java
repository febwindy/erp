package me.erp.application.security;

import me.erp.domain.model.role.Role;
import me.erp.domain.model.user.User;
import me.erp.domain.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by _liwenhe on 2015/3/5.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("用户不存在,请重新输入!");
        }

        Set<Role> roles = user.getRoles();
        if (null == roles && roles.isEmpty()) {
            throw new UsernameNotFoundException("权限不足!");
        }

        Iterator<Role> iterator = roles.iterator();
        Collection<GrantedAuthority> gaRoles = new ArrayList<GrantedAuthority>();
        while (iterator.hasNext()) {
            gaRoles.add(new SimpleGrantedAuthority(iterator.next().getRole()));
        }

        SaltUser saltUser = new SaltUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                gaRoles,
                user.getSalt()
        );

        return saltUser;
    }

}
