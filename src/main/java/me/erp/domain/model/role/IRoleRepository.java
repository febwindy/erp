package me.erp.domain.model.role;

import me.erp.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;
import org.hibernate.FetchMode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by _liwenhe on 2015/3/4.
 */
public interface IRoleRepository<T, TD extends Serializable> extends IHibernateGenericRepository<T, TD> {
    List<T> getAll();

    T getById(String id, Map<String, FetchMode> fetchModeMap);

    T getByName(String name);
}
