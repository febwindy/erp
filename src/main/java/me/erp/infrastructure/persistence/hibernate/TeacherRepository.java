package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.teacher.ITeacherRepository;
import me.erp.domain.model.teacher.Teacher;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Repository("teacherRepository")
public class TeacherRepository extends AbstractHibernateGenericRepository<Teacher, String>
        implements ITeacherRepository<Teacher, String> {
}
