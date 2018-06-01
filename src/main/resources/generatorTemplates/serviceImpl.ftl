package ${package};

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${imorptAbstractServiceImpl};
import ${importDao}.${model}Dao;
import ${importService}.${model}Service;
import ${importModel}.${model};

/**
 * Service - ${model_name_cn}
 * @author	xuyb
 * @version 2.0
 * @date 	${.now?string("yyyy-MM-dd")}
 */
@Service("${repository}ServiceImpl")
public class ${model}ServiceImpl extends BaseServiceImpl<${model}, Long> implements ${model}Service{
	@Resource
	private ${model}Dao ${repository}Dao;

	@Resource
	public void setBaseDao(${model}Dao ${repository}Dao) {
		super.setBaseDao(${repository}Dao);
	}
}
