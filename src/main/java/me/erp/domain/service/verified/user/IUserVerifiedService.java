package me.erp.domain.service.verified.user;

import me.erp.domain.model.verified.user.UserVerified;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.verified.web.user.command.CreateUserCommand;
import me.erp.interfaces.verified.web.user.command.ListCommand;

/**
 * Created by ivan_ on 2015/4/10.
 */
public interface IUserVerifiedService {

    UserVerified findById(String id);

    Pagination<UserVerified> pagination(ListCommand command);

    void create(CreateUserCommand command);

    void delete(String id);

}
