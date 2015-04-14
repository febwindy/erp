package me.erp.interfaces.user.web.command;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class AuthorizationRoleCommand implements Serializable {

    private String id;

    private String username;

    private String roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
