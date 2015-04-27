package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.student.IStudentRepository;
import me.erp.domain.model.student.Student;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("studentRepository")
public class StudentRepository extends AbstractHibernateGenericRepository<Student, String>
        implements IStudentRepository<Student, String> {

    @Override
    public Student findById(String id) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("operator", FetchMode.JOIN)
                .setFetchMode("teachers", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Student) obj : null;
    }

    @Override
    public Student findByStudent(String studentId) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("studentId", studentId));

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Student) obj : null;
    }
}
