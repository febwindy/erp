package me.erp.interfaces.role.web.command;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class AuthorizationPermissionCommand implements Serializable {
    private String id;
    private String role;
    private String permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
