package me.erp.domain.service.user;

import me.erp.domain.model.role.IRoleRepository;
import me.erp.domain.model.role.Role;
import me.erp.domain.model.user.IUserRepository;
import me.erp.domain.model.user.User;
import me.erp.domain.service.NoFoundException;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.user.web.command.AuthorizationRoleCommand;
import me.erp.interfaces.user.web.command.CreateUserCommand;
import me.erp.interfaces.user.web.command.EditUserCommand;
import me.erp.interfaces.user.web.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UserService implements IUserService{

    @Autowired
    private IUserRepository<User, String> userRepository;

    @Autowired
    private IRoleRepository<Role, String> roleRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.loadByUsername(username);
    }

    @Override
    public User findById(String id) {
        User user = userRepository.getById(id);
        if (null == user) {
            throw new NoFoundException("该用户不存在.");
        }
        return user;
    }

    @Override
    public User findById(String id, Boolean isFetchMode) {
        User user = userRepository.getById(id, true);
        if (null == user) {
            throw new NoFoundException("该用户不存在.");
        }
        return user;
    }

    @Override
    public void create(CreateUserCommand command) {
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        md5.setEncodeHashAsBase64(false);

        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        String pwd = md5.encodePassword(command.getConfirmPassword(), salt);
        Boolean sex;
        if ("0".equals(command.getSex())) {
            sex = false;
        } else {
            sex = true;
        }

        Set<Role> roles = new HashSet<Role>();
        Role role = roleRepository.getByName("user");
        roles.add(role);

        User user = new User();
        user.setUsername(command.getUsername());
        user.setRealName(command.getRealName());
        user.setPassword(pwd);
        user.setEmail(command.getEmail());
        user.setSex(sex);
        user.setTelephone(command.getTelephone());
        user.setIdCard(command.getIdCard());
        user.setOrganization(command.getOrganization());
        user.setSalt(salt);
        user.setRoles(roles);
        user.setCreatedDate(new Date());

        userRepository.save(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Pagination<User> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getUsername() && !StringUtils.isEmpty(command.getUsername())) {
            criterionList.add(Restrictions.like("username", command.getUsername(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return userRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void delete(String id) {
        User user;
        try {
            user = this.findById(id);
        } catch (NoFoundException e) {
            throw new NoFoundException(e);
        }
        userRepository.delete(user);
    }

    @Override
    public void edit(EditUserCommand command) {

        Boolean sex;
        if ("0".equals(command.getSex())) {
            sex = false;
        } else {
            sex = true;
        }

        User user = this.findById(command.getId());
        user.setUsername(command.getUsername());
        user.setRealName(command.getRealName());
        user.setSex(sex);
        user.setEmail(command.getEmail());
        user.setTelephone(command.getTelephone());
        user.setIdCard(command.getIdCard());
        user.setOrganization(command.getOrganization());
        user.setRemark(command.getRemark());
        if (!StringUtils.isEmpty(command.getPassword())) {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            md5.setEncodeHashAsBase64(false);

            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            String pwd = md5.encodePassword(command.getConfirmPassword(), salt);
            user.setPassword(pwd);
            user.setSalt(salt);
        }

        userRepository.update(user);
    }

    @Override
    public void authorization(AuthorizationRoleCommand command) {

        Set<Role> roles = new HashSet<Role>();

        if (null != command.getRoles() && !StringUtils.isEmpty(command.getRoles())) {
            String[] roleIds = command.getRoles().split(",");
            for (String id : roleIds) {
                Role role = roleRepository.getById(id);
                if (null != role) {
                    roles.add(role);
                } else {
                    throw new NoFoundException("角色[" + role.getDescription() + "]没有发现" );
                }
            }
        }

        User user = this.findById(command.getId());
        user.setRoles(roles);

        userRepository.update(user);

    }
}
