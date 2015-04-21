package me.erp.domain.service.subject;

import me.erp.domain.model.subject.Subject;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.subject.web.command.CreateSubjectCommand;
import me.erp.interfaces.subject.web.command.EditSubjectCommand;
import me.erp.interfaces.subject.web.command.ListCommand;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface ISubjectService {

    Subject findById(String id);

    Subject findBySubjectId(String id);

    Pagination<Subject> pagination(ListCommand command);

    int countBySubjectId(String subjectId);

    void create(CreateSubjectCommand command);

    void edit(EditSubjectCommand command);

    void delete(String id);
}
