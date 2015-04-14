package me.erp.domain.service.permission;


import me.erp.domain.model.permission.Permission;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.permission.web.command.CreatePermissionCommand;
import me.erp.interfaces.permission.web.command.EditPermissionCommand;
import me.erp.interfaces.permission.web.command.ListCommand;

import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IPermissionService {

    Permission findById(String id);

    Permission findByName(String name);

    List<Permission> findByRoleId(String id);

    List<Permission> findAll();

    List<Permission> findAll(boolean isFetchMode);

    Pagination<Permission> pagination(ListCommand command);

    void create(CreatePermissionCommand command);

    void edit(EditPermissionCommand command);

    void delete(String id);
}
