package me.erp.domain.service.student;

import me.erp.application.security.SaltUser;
import me.erp.domain.model.student.IStudentRepository;
import me.erp.domain.model.student.Student;
import me.erp.domain.model.user.User;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.user.IUserService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.student.web.command.CreateStudentCommand;
import me.erp.interfaces.student.web.command.EditStudentCommand;
import me.erp.interfaces.student.web.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Service("studentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class StudentService implements IStudentService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IStudentRepository<Student, String> studentRepository;

    @Override
    public Student findById(String id) {

        Student student = studentRepository.findById(id);

        if (null == student) {
            throw new NoFoundException("该记录不存在");
        }

        return student;
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudent(studentId);
    }

    @Override
    public Pagination<Student> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getStudentId() && !StringUtils.isEmpty(command.getStudentId())) {
            criterionList.add(Restrictions.like("studentId", command.getStudentId(), MatchMode.ANYWHERE));
        }

        if (null != command.getStudentName() && !StringUtils.isEmpty(command.getStudentName())) {
            criterionList.add(Restrictions.like("studentName", command.getStudentName(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return studentRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateStudentCommand command) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Boolean sex = command.getSex().equals("0") ? false : true;

        Student student = new Student();
        student.setStudentId(command.getStudentId());
        student.setStudentName(command.getStudentName());
        student.setSex(sex);

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            User user = userService.findById(((SaltUser) obj).getId());
            student.setOperator(user);
        }

        try {
            student.setBirthDate(sf.parse(command.getBirthDate()));
        } catch (ParseException e) {
            throw new ParseException("出生日期转换出错", 0);
        }

        student.setCreatedDate(new Date());
        student.setUpdatedDate(new Date());
        student.setRemark(command.getRemark());

        studentRepository.save(student);
    }

    @Override
    public void edit(EditStudentCommand command) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Boolean sex = command.getSex().equals("0") ? false : true;

        Student student = studentRepository.findById(command.getId());
        student.setStudentId(command.getStudentId());
        student.setStudentName(command.getStudentName());
        student.setSex(sex);

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            User user = userService.findById(((SaltUser) obj).getId());
            student.setOperator(user);
        }

        try {
            student.setBirthDate(sf.parse(command.getBirthDate()));
        } catch (ParseException e) {
            throw new ParseException("出生日期转换出错", 0);
        }

        student.setUpdatedDate(new Date());
        student.setRemark(command.getRemark());

        studentRepository.update(student);
    }

    @Override
    public void delete(String id) {
        Student student = this.findById(id);
        studentRepository.delete(student);
    }
}
