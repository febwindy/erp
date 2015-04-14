package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.permission.IPermissionRepository;
import me.erp.domain.model.permission.Permission;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Repository("permissionRepository")
public class PermissionRepository extends AbstractHibernateGenericRepository<Permission, String> implements IPermissionRepository<Permission, String> {

    @Override
    public Permission getByName(String name) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("resource", name));

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Permission) obj : null;
    }

    @Override
    public List<Permission> getByRoleId(String id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("roles", "r")
                .add(Restrictions.eq("r.id", id));

        return criteria.list();
    }

    @Override
    public List<Permission> getAll(boolean isFetchMode) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        if (isFetchMode) {
            criteria.setFetchMode("roles", FetchMode.JOIN);
        }

        return criteria.list();
    }
}
