package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.SequenceDao;
import manageSystem.modules.model.Sequence;
import manageSystem.modules.service.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl extends BaseService<SequenceDao, Sequence, Long> implements SequenceService {
}
