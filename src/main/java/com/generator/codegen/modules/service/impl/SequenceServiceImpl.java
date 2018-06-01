package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.SequenceDao;
import com.generator.codegen.modules.model.Sequence;
import com.generator.codegen.modules.service.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl extends BaseService<SequenceDao, Sequence, Long> implements SequenceService {
}
