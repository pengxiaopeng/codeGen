package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.OrgDao;
import com.generator.codegen.modules.model.Org;
import com.generator.codegen.modules.service.OrgService;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl extends BaseService<OrgDao, Org, Long> implements OrgService {
}
