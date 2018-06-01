package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.CollegeInfoDao;
import com.codegen.modules.model.CollegeInfo;
import com.codegen.modules.service.CollegeInfoService;
import org.springframework.stereotype.Service;

@Service
public class CollegeInfoServiceImpl extends BaseService<CollegeInfoDao, CollegeInfo, Long> implements CollegeInfoService {
}
