package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.OrgDao;
import com.codegen.modules.model.Org;
import com.codegen.modules.service.OrgService;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl extends BaseService<OrgDao, Org, Long> implements OrgService {
}
