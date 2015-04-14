package me.erp.infrastructure.persistence.hibernate;

import me.erp.domain.model.role.IRoleRepository;
import me.erp.domain.model.role.Role;
import me.erp.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Repository("roleRepository")
public class RoleRepository extends AbstractHibernateGenericRepository<Role, String> implements IRoleRepository<Role, String> {
    @Override
    public List<Role> getAll() {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.setFetchMode("permissions", FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    public Role getById(String id, Map<String, FetchMode> fetchModeMap) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("id", id));

        if (null != fetchModeMap) {
            for (Map.Entry entry : fetchModeMap.entrySet()) {
                String key = (String) entry.getKey();
                FetchMode value = (FetchMode) entry.getValue();
                criteria.setFetchMode(key, value);
            }
        }

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Role) obj : null;
    }

    @Override
    public Role getByName(String name) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("role", name));

        Object obj = criteria.uniqueResult();

        return (null != obj) ? (Role) obj : null;
    }
}
