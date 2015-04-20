package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.subject.ISubjectRepository;
import me.erp.domain.model.subject.Subject;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("subjectRepository")
public class SubjectRepository extends AbstractHibernateGenericRepository<Subject, String>
        implements ISubjectRepository<Subject, String> {
}
