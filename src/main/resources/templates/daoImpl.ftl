package ${package};

import org.springframework.stereotype.Repository;
import ${importAbstractDaoImpl};
import ${importDao}.${model}Dao;
import ${importModel}.${model};

/**
 * Dao - ${model_name_cn}
 * @author	xuyb
 * @version 2.0
 * @date 	${.now?string("yyyy-MM-dd")}
 */
@Repository("${repository}DaoImpl")
public class ${model}DaoImpl extends BaseDaoImpl<${model}, Long> implements ${model}Dao {

	

}
