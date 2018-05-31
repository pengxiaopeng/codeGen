package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.DataDictionaryDao;
import manageSystem.modules.model.DataDictionary;
import manageSystem.modules.service.DataDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl extends BaseService<DataDictionaryDao, DataDictionary, Long> implements DataDictionaryService {
}
