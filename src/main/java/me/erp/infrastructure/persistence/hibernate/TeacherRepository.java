package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.teacher.ITeacherRepository;
import me.erp.domain.model.teacher.Teacher;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("teacherRepository")
public class TeacherRepository extends AbstractHibernateGenericRepository<Teacher, String>
        implements ITeacherRepository<Teacher, String> {

    @Override
    public Teacher findById(String id) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("operator", FetchMode.JOIN)
                .setFetchMode("subjects", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Teacher) obj : null;
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("teacherId", teacherId));

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Teacher) obj : null;
    }

    @Override
    public List<Teacher> findAllByFetchMode() {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.setFetchMode("subjects", FetchMode.JOIN);

        return criteria.list();
    }
}
