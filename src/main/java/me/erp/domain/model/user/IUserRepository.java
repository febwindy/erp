package me.erp.domain.model.user;


import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IUserRepository<T, TD extends Serializable> extends IHibernateGenericRepository<T, TD> {

    T loadByUsername(String username);

    T getById(String id, Boolean isFetchMode);

}
