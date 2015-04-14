package me.erp.interfaces.role.web.command;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class EditRoleCommand implements Serializable {

    private String id;

    @NotEmpty(message = "{EditRoleCommand.role.NotEmpty}")
    private String role;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
