package com.generator.codegen.generator;

import com.generator.codegen.generator.db.Consts;
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
        // Leave实体名
        params.put("modelName", "Leave");
        // bid_leave 表名
        params.put("model_name_cn", "bid_leave");
        params.put(FreemarkerGenerate.PACKAGE_PATH, "com.zyfast");
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
        logger.info("生成成功。路径={}", Consts.TARGET_DIR);
    }
}
