package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.student.IStudentRepository;
import me.erp.domain.model.student.Student;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("studentRepository")
public class StudentRepository extends AbstractHibernateGenericRepository<Student, String>
        implements IStudentRepository<Student, String> {
}
