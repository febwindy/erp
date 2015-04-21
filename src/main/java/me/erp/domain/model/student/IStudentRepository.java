package me.erp.domain.model.student;

import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface IStudentRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {

    Student findById(String id);

    Student findByStudent(String studentId);

}
