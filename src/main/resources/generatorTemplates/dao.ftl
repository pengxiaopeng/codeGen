package ${package};
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import ${importModel}.${model};

/**
 * Dao - ${model_name_cn}
 * @author	pengxiaopeng
 * @version 2.0
 * @date 	${.now?string("yyyy-MM-dd")}
 */
public interface ${model}Dao extends BaseDao<${model}, Long>{

}