package me.erp.domain.service.verified.user;

import me.erp.domain.model.verified.VerifiedType;
import me.erp.domain.model.verified.user.IUserVerifiedRepository;
import me.erp.domain.model.verified.user.UserVerified;
import me.erp.domain.service.NoFoundException;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.verified.web.user.command.CreateUserCommand;
import me.erp.interfaces.verified.web.user.command.ListCommand;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan_ on 2015/4/10.
 */
@Service("userVerifiedService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UserVerifiedService implements IUserVerifiedService {

    @Autowired
    private IUserVerifiedRepository<UserVerified, String> userVerifiedRepository;

    @Override
    public UserVerified findById(String id) {
        UserVerified userVerified = userVerifiedRepository.getById(id);
        if (null == userVerified) {
            throw new NoFoundException("没有发现该帐号");
        }
        return userVerified;
    }

    @Override
    public Pagination<UserVerified> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return userVerifiedRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateUserCommand command) {

        Boolean sex;
        if ("0".equals(command.getSex())) {
            sex = false;
        } else {
            sex = true;
        }

        UserVerified user = new UserVerified();
        user.setUsername(command.getUsername());
        user.setRealName(command.getRealName());
        user.setPassword(command.getPassword());
        user.setEmail(command.getEmail());
        user.setSex(sex);
        user.setTelephone(command.getTelephone());
        user.setIdCard(command.getIdCard());
        user.setOrganization(command.getOrganization());
        user.setType(VerifiedType.USER_VERIFIED);
        user.setCreatedDate(new Date());

        userVerifiedRepository.save(user);
    }

    @Override
    public void delete(String id) {
        UserVerified userVerified = this.findById(id);
        userVerifiedRepository.delete(userVerified);
    }
}
