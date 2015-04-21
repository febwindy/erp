package me.erp.domain.service.subject;

import me.erp.application.security.SaltUser;
import me.erp.domain.model.subject.ISubjectRepository;
import me.erp.domain.model.subject.Subject;
import me.erp.domain.model.user.User;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.user.IUserService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.subject.web.command.CreateSubjectCommand;
import me.erp.interfaces.subject.web.command.EditSubjectCommand;
import me.erp.interfaces.subject.web.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Service("subjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository<Subject, String> subjectRepository;

    @Autowired
    private IUserService userService;

    @Override
    public Subject findById(String id) {

        Subject subject = subjectRepository.findById(id);

        if (null == subject) {
            throw new NoFoundException("没有发现该课程号");
        }

        return subject;
    }

    @Override
    public Subject findBySubjectId(String subjectId) {
        return subjectRepository.findBySubjectId(subjectId);
    }

    @Override
    public Pagination<Subject> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getSubjectId() && !StringUtils.isEmpty(command.getSubjectId())) {
            criterionList.add(Restrictions.eq("subjectId", command.getSubjectId()));
        }

        if (null != command.getSubjectName() && !StringUtils.isEmpty(command.getSubjectName())) {
            criterionList.add(Restrictions.eq("subjectName", command.getSubjectName()));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return subjectRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public int countBySubjectId(String subjectId) {
        return subjectRepository.countBySubjectId(subjectId);
    }

    @Override
    public void create(CreateSubjectCommand command) {

        Subject subject = new Subject();
        subject.setSubjectId(command.getSubjectId());
        subject.setSubjectName(command.getSubjectName());
        subject.setCreatedDate(new Date());
        subject.setUpdatedDate(new Date());

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {

            User user = userService.findById(((SaltUser) obj).getId());

            subject.setOperator(user);
        }

        subject.setRemark(command.getRemark());

        subjectRepository.save(subject);
    }

    @Override
    public void edit(EditSubjectCommand command) {

        Subject subject = this.findById(command.getId());
        subject.setSubjectId(command.getSubjectId());
        subject.setSubjectName(command.getSubjectName());
        subject.setUpdatedDate(new Date());

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {

            User user = userService.findById(((SaltUser) obj).getId());

            subject.setOperator(user);
        }

        subject.setRemark(command.getRemark());

        subjectRepository.update(subject);
    }

    @Override
    public void delete(String id) {
        Subject subject = this.findById(id);
        subjectRepository.delete(subject);
    }
}
