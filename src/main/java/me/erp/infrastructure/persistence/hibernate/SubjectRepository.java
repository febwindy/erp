package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.subject.ISubjectRepository;
import me.erp.domain.model.subject.Subject;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("subjectRepository")
public class SubjectRepository extends AbstractHibernateGenericRepository<Subject, String>
        implements ISubjectRepository<Subject, String> {

    @Override
    public Subject findById(String id) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id))
                .setFetchMode("operator", FetchMode.JOIN);

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Subject) obj : null;
    }

    @Override
    public Subject findBySubjectId(String subjectId) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("subjectId", subjectId));

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Subject) obj : null;
    }

    @Override
    public int countBySubjectId(String subjectId) {

        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("subjectId", subjectId));

        int count = criteria.list().size();

        return count;
    }
}
