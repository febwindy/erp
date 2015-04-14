package me.erp.interfaces.permission.web.command;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class CreatePermissionCommand implements Serializable {

    @NotEmpty(message = "{CreatePermissionCommand.resource.NotEmpty}")
    private String resource;

    private String description;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
