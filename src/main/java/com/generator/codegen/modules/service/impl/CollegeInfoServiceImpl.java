package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.CollegeInfoDao;
import manageSystem.modules.model.CollegeInfo;
import manageSystem.modules.service.CollegeInfoService;
import org.springframework.stereotype.Service;

@Service
public class CollegeInfoServiceImpl extends BaseService<CollegeInfoDao, CollegeInfo, Long> implements CollegeInfoService {
}
