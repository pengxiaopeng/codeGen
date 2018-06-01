package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.CollegeInfoDao;
import com.generator.codegen.modules.model.CollegeInfo;
import com.generator.codegen.modules.service.CollegeInfoService;
import org.springframework.stereotype.Service;

@Service
public class CollegeInfoServiceImpl extends BaseService<CollegeInfoDao, CollegeInfo, Long> implements CollegeInfoService {
}
