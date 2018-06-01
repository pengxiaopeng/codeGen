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
 * 实体生成工具,生成代码入口
 * 
 * @author xuyb
 *
 */
public class GenerateMain {
	//代码生成目录
	public static String targetDir = Consts.TARGET_DIR;

	public static void main(String[] args) throws IOException,
			TemplateException {

		List<TableMeta> tableList;
		Writer out = null;
		// tableList = AnalysisDB.readDB() ; 传空值则查询所有表，也可以单独传表名
		tableList = AnalysisDB.readDB("bid_leave");
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
		Template tpl = cfg.getTemplate("model.ftl");
		if (tableList != null) {
			for (TableMeta tm : tableList) {
				if (StringUtils.isBlank(tm.getClassName()))
					continue;
				out = new FileWriter(new File(targetDir + tm.getClassName()
						+ ".java"));
				tpl.process(tm, out);
				System.out.println("===文件 " + tm.getClassName() + ".java"
						+ " 生成成功===");
			}
		}

		out.flush();
		out.close();

	}

}