package me.erp.domain.model.teacher;

import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface ITeacherRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {

    Teacher findById(String id);

    Teacher findByTeacherId(String teacherId);

}
