package me.erp.domain.service.role;

import me.erp.domain.model.role.Role;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.role.web.command.AuthorizationPermissionCommand;
import me.erp.interfaces.role.web.command.CreateRoleCommand;
import me.erp.interfaces.role.web.command.EditRoleCommand;
import me.erp.interfaces.role.web.command.ListCommand;

import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IRoleService {

    Role findByUserId(String id);

    Role findById(String id);

    Role findById(String id, Boolean isFetchModeForUser, Boolean isFetchModeForPermission);

    Role findByName(String name);

    List<Role> findAll();

    Pagination<Role> pagination(ListCommand command);

    void create(CreateRoleCommand command);

    void edit(EditRoleCommand command);

    void delete(String id);

    void authorization(AuthorizationPermissionCommand command);

}
