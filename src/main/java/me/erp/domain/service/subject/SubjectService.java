package me.erp.domain.service.subject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan_ on 2015/4/20.
 */
@Service("subjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SubjectService implements ISubjectService {
}
