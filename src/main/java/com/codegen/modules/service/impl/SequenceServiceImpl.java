package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.SequenceDao;
import com.codegen.modules.model.Sequence;
import com.codegen.modules.service.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl extends BaseService<SequenceDao, Sequence, Long> implements SequenceService {
}
