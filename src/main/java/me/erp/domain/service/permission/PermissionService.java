package me.erp.domain.service.permission;

import me.erp.domain.model.permission.IPermissionRepository;
import me.erp.domain.model.permission.Permission;
import me.erp.domain.service.NoFoundException;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.permission.web.command.CreatePermissionCommand;
import me.erp.interfaces.permission.web.command.EditPermissionCommand;
import me.erp.interfaces.permission.web.command.ListCommand;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Service("permissionService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionRepository<Permission, String> permissionRepository;

    @Override
    public Permission findById(String id) {
        Permission permission = permissionRepository.getById(id);
        if (null == permission) {
            throw new NoFoundException("该资源不存在");
        }
        return permission;
    }

    @Override
    public Permission findByName(String name) {
        return permissionRepository.getByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Permission> findByRoleId(String id) {
        return permissionRepository.getByRoleId(id);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> findAll(boolean isFetchMode) {
        return permissionRepository.getAll(isFetchMode);
    }

    @Override
    public Pagination<Permission> pagination(ListCommand command) {
        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        return permissionRepository.pagination(command.getPage(), command.getPageSize(), restrictions, null);
    }

    @Override
    public void create(CreatePermissionCommand command) {
        Permission permission = new Permission();
        permission.setResource(command.getResource());
        permission.setDescription(command.getDescription());

        permissionRepository.save(permission);
    }

    @Override
    public void edit(EditPermissionCommand command) {
        Permission permission = this.findById(command.getId());
        permission.setResource(command.getResource());
        permission.setDescription(command.getDescription());

        permissionRepository.update(permission);
    }

    @Override
    public void delete(String id) {
        Permission permission = this.findById(id);
        permissionRepository.delete(permission);
    }
}
