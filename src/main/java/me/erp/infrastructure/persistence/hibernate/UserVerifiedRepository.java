package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.verified.user.IUserVerifiedRepository;
import me.erp.domain.model.verified.user.UserVerified;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/4/10.
 */
@Repository("userVerifiedRepository")
public class UserVerifiedRepository extends AbstractHibernateGenericRepository<UserVerified, String>
        implements IUserVerifiedRepository<UserVerified, String> {
}
