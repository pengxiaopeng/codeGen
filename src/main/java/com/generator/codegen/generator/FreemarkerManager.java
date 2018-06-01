package com.generator.codegen.generator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.net.URL;

public class FreemarkerManager {
	private static Configuration cfg = new Configuration();

	static {

		URL uri = FreemarkerManager.class.getClassLoader().getResource("templates");
		String ftlPath = uri.getPath();
		try {
			cfg.setDirectoryForTemplateLoading(new File(ftlPath));
		} catch (Exception e) {

		}
		// 设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		// 设置异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

		cfg.setDefaultEncoding("UTF-8");

		cfg.setNumberFormat("#");
	}

	public static Configuration getConfiguration() {
		return cfg;
	}
}
