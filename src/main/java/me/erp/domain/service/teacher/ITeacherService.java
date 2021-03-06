package me.erp.domain.service.teacher;

import me.erp.domain.model.teacher.Teacher;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.teacher.web.command.CreateTeacherCommand;
import me.erp.interfaces.teacher.web.command.EditTeacherCommand;
import me.erp.interfaces.teacher.web.command.ListCommand;
import me.erp.interfaces.teacher.web.command.SelectSubjectCommand;

import java.text.ParseException;
import java.util.List;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface ITeacherService {

    Teacher findById(String id);

    Teacher findByTeacherId(String teacherId);

    Pagination<Teacher> pagination(ListCommand command);

    List<Teacher> findAllByFetchMode();

    void create(CreateTeacherCommand command) throws ParseException;

    void edit(EditTeacherCommand command) throws ParseException;

    void delete(String id);

    void select(SelectSubjectCommand command);

}
