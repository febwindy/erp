package me.erp.domain.service.teacher;

import me.erp.application.security.SaltUser;
import me.erp.domain.model.subject.Subject;
import me.erp.domain.model.teacher.ITeacherRepository;
import me.erp.domain.model.teacher.Teacher;
import me.erp.domain.model.user.User;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.subject.ISubjectService;
import me.erp.domain.service.user.IUserService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.teacher.web.command.CreateTeacherCommand;
import me.erp.interfaces.teacher.web.command.EditTeacherCommand;
import me.erp.interfaces.teacher.web.command.ListCommand;
import me.erp.interfaces.teacher.web.command.SelectSubjectCommand;
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
import java.util.*;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Service("teacherService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TeacherService implements ITeacherService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITeacherRepository<Teacher, String> teacherRepository;

    @Autowired
    private ISubjectService subjectService;

    @Override
    public Teacher findById(String id) {

        Teacher teacher = teacherRepository.findById(id);

        if (null == teacher) {
            throw new NoFoundException("该记录不存在");
        }

        return teacher;
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        return teacherRepository.findByTeacherId(teacherId);
    }

    @Override
    public Pagination<Teacher> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getTeacherId() && !StringUtils.isEmpty(command.getTeacherId())) {
            criterionList.add(Restrictions.like("teacherId", command.getTeacherId(), MatchMode.ANYWHERE));
        }

        if (null != command.getTeacherName() && !StringUtils.isEmpty(command.getTeacherName())) {
            criterionList.add(Restrictions.like("teacherName", command.getTeacherName(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return teacherRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateTeacherCommand command) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Boolean sex = command.getSex().equals("0") ? false : true;

        Teacher teacher = new Teacher();
        teacher.setTeacherId(command.getTeacherId());
        teacher.setTeacherName(command.getTeacherName());
        teacher.setSex(sex);

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            User user = userService.findById(((SaltUser) obj).getId());
            teacher.setOperator(user);
        }

        try {
            teacher.setBirthDate(sf.parse(command.getBirthDate()));
        } catch (ParseException e) {
            throw new ParseException("出生日期转换出错", 0);
        }

        teacher.setCreatedDate(new Date());
        teacher.setUpdatedDate(new Date());
        teacher.setRemark(command.getRemark());

        teacherRepository.save(teacher);
    }

    @Override
    public void edit(EditTeacherCommand command) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Boolean sex = command.getSex().equals("0") ? false : true;

        Teacher teacher = this.findById(command.getId());
        teacher.setTeacherId(command.getTeacherId());
        teacher.setTeacherName(command.getTeacherName());
        teacher.setSex(sex);

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            User user = userService.findById(((SaltUser) obj).getId());
            teacher.setOperator(user);
        }

        try {
            teacher.setBirthDate(sf.parse(command.getBirthDate()));
        } catch (ParseException e) {
            throw new ParseException("出生日期转换出错", 0);
        }

        teacher.setUpdatedDate(new Date());
        teacher.setRemark(command.getRemark());

        teacherRepository.update(teacher);
    }

    @Override
    public void delete(String id) {
        Teacher teacher = this.findById(id);
        teacherRepository.delete(teacher);
    }

    @Override
    public void select(SelectSubjectCommand command) {

        Set<Subject> subjects = new HashSet<Subject>();

        if (null != command.getSubjects() && !StringUtils.isEmpty(command.getSubjects())) {
            String[] subjectIds = command.getSubjects().split(",");
            for (String id : subjectIds) {
                Subject subject = subjectService.findBySubjectId(id);
                if (null != subject) {
                    subjects.add(subject);
                } else {
                    throw new NoFoundException("课程资源[" + subject.getSubjectId() + "]没有发现" );
                }
            }
        }

        Teacher teacher = this.findById(command.getId());
        teacher.setSubjects(subjects);

        teacherRepository.update(teacher);

    }
}
