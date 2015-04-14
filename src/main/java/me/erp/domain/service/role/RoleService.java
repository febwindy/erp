package me.erp.domain.service.role;

import me.erp.domain.model.permission.IPermissionRepository;
import me.erp.domain.model.permission.Permission;
import me.erp.domain.model.role.IRoleRepository;
import me.erp.domain.model.role.Role;
import me.erp.domain.service.NoFoundException;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.role.web.command.AuthorizationPermissionCommand;
import me.erp.interfaces.role.web.command.CreateRoleCommand;
import me.erp.interfaces.role.web.command.EditRoleCommand;
import me.erp.interfaces.role.web.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository<Role, String> roleRepository;

    @Autowired
    private IPermissionRepository<Permission, String> permissionRepository;

    @Override
    public Role findByUserId(String id) {
        return null;
    }

    @Override
    public Role findById(String id) {
        Role role = roleRepository.getById(id);
        if (null == role) {
            throw new NoFoundException("该角色不存在");
        }
        return role;
    }

    @Override
    public Role findById(String id, Boolean isFetchModeForUser, Boolean isFetchModeForPermission) {

        Map<String, FetchMode> fetchModeMap = new HashMap<String, FetchMode>();
        if (isFetchModeForUser) {
            fetchModeMap.put("users", FetchMode.JOIN);
        }
        if (isFetchModeForPermission) {
            fetchModeMap.put("permissions", FetchMode.JOIN);
        }

        return roleRepository.getById(id, fetchModeMap);

    }

    @Override
    public Role findByName(String name) {
        return roleRepository.getByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Pagination<Role> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        return roleRepository.pagination(command.getPage(), command.getPageSize(), restrictions, null);
    }

    @Override
    public void create(CreateRoleCommand command) {
        Role role = new Role();
        role.setRole(command.getRole());
        role.setDescription(command.getDescription());

        roleRepository.save(role);
    }

    @Override
    public void edit(EditRoleCommand command) {
        Role role = this.findById(command.getId());
        role.setRole(command.getRole());
        role.setDescription(command.getDescription());

        roleRepository.update(role);
    }

    @Override
    public void delete(String id) {
        Role role = this.findById(id);
        roleRepository.delete(role);
    }

    @Override
    public void authorization(AuthorizationPermissionCommand command) {

        Set<Permission> permissions = new HashSet<Permission>();

        if (null != command.getPermissions() && !StringUtils.isEmpty(command.getPermissions())) {
            String[] permissionIds = command.getPermissions().split(",");
            for (String id : permissionIds) {
                Permission permission = permissionRepository.getById(id);
                if (null != permission) {
                    permissions.add(permission);
                } else {
                    throw new NoFoundException("权限资源[" + permission.getResource() + "]没有发现" );
                }
            }
        }

        Role role = this.findById(command.getId());
        role.setPermissions(permissions);

        roleRepository.update(role);

    }
}
