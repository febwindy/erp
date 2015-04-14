package me.erp.domain.model.permission;

import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IPermissionRepository<T, TD extends Serializable> extends IHibernateGenericRepository<T, TD> {

    T getByName(TD name);

    List<T> getByRoleId(TD id);

    List<T> getAll(boolean isFetchMode);
}
