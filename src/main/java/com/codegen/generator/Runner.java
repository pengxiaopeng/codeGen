package com.codegen.generator;

import com.codegen.generator.db.Consts;
import com.codegen.generator.freemark.FreemarkerGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dao、service、controller代码生成入口
 *
 * @author xuyb
 */
public class Runner {
    private final static String targetPath = Consts.TARGET_DIR;
    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        List<Map> paramList = new ArrayList<Map>();
        Map params = new HashMap<String, String>();

        String className = "Leave";
        String tableName = "bid_leave";

        // Leave实体名
        params.put("modelName", className);
        // bid_leave 表名
        params.put("model_name_cn", tableName);
        params.put(FreemarkerGenerate.PACKAGE_PATH, FreemarkerGenerate.GENERATOR_PACKAGE_PATH);
        paramList.add(params);
        FreemarkerGenerate.genDao(targetPath, paramList, "dao.ftl", true);
        FreemarkerGenerate.genDaoImpl(targetPath, paramList, "daoImpl.ftl",
                true);
        FreemarkerGenerate.genService(targetPath, paramList, "service.ftl",
                true);
        FreemarkerGenerate.genServiceImpl(targetPath, paramList,
                "serviceImpl.ftl", true);
        FreemarkerGenerate.genController(targetPath, paramList,
                "controller.ftl", true);
        FreemarkerGenerate.getMapper(targetPath, tableName, className, "mapper.ftl");
        logger.info("生成成功。路径={}", Consts.TARGET_DIR);
    }
}
