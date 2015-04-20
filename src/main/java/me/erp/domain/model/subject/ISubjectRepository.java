package me.erp.domain.model.subject;

import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface ISubjectRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
