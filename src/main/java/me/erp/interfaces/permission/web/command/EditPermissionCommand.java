package me.erp.interfaces.permission.web.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivan_ on 2015/3/31.
 */
public class EditPermissionCommand {

    private String id;

    @NotEmpty(message = "{EditPermissionCommand.resource.NotEmpty}")
    private String resource;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
