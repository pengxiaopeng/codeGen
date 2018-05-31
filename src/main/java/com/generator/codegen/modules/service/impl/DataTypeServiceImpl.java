package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.DataTypeDao;
import manageSystem.modules.model.DataType;
import manageSystem.modules.service.DataTypeService;
import org.springframework.stereotype.Service;

@Service
public class DataTypeServiceImpl extends BaseService<DataTypeDao, DataType, Long> implements DataTypeService {
}
