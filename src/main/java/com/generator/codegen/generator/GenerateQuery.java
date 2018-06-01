package com.generator.codegen.generator;

import com.generator.codegen.generator.db.AnalysisDB;
import com.generator.codegen.generator.db.Consts;
import com.generator.codegen.generator.model.TableMeta;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * 查询XML文件生成代码入口
 * 
 * @author xuyb
 *
 */
public class GenerateQuery {
	public static void main(String[] args) throws IOException,
			TemplateException {

		List<TableMeta> tableList;
		Writer out = null;
		String targetDir = Consts.TARGET_DIR;
		// tableList = AnalysisDB.readDB() ; 传空值则查询所有表，也可以单独传表名
		tableList = AnalysisDB.readDB("biz_pay_plan");
		AnalysisDB.readTables(tableList);
		// 输出到文件
		File dir = new File(targetDir);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(
				"src/com/zyfast/generate/common/templates"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template tpl = cfg.getTemplate("query.ftl");
		if (tableList != null) {
			for (TableMeta tm : tableList) {
				if (StringUtils.isBlank(tm.getClassName()))
					continue;
				out = new FileWriter(new File(targetDir + tm.getClassName()
						+ "-query.xml"));
				tpl.process(tm, out);
				System.out.println("===文件 " + tm.getClassName() + "-query.xml"
						+ " 生成成功===");
			}
		}
		out.flush();
		out.close();
	}

}