package me.erp.application.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by _liwenhe on 2015/3/7.
 */
public class SaltUser extends User {

    private String id;

    private String salt;

    public SaltUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities, String salt) {
        super(username, password, authorities);
        this.id = id;
        this.salt = salt;
    }

    public SaltUser(String id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                    boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String salt) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.salt = salt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
