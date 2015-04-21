package me.erp.domain.service.student;

import me.erp.domain.model.student.Student;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.student.web.command.CreateStudentCommand;
import me.erp.interfaces.student.web.command.EditStudentCommand;
import me.erp.interfaces.student.web.command.ListCommand;

import java.text.ParseException;

/**
 * Created by ivan_ on 2015/4/20.
 */
public interface IStudentService {

    Student findById(String id);

    Student findByStudentId(String studentId);

    Pagination<Student> pagination(ListCommand command);

    void create(CreateStudentCommand command) throws ParseException;

    void edit(EditStudentCommand command) throws ParseException;

    void delete(String id);

}
