package com.generator.codegen.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author xuyb
 *
 */
public class FreemarkerGenerate {

	private final static String baseDao = "com.zyfast.dao.BaseDao";
	private final static String baseDaoImpl = "com.zyfast.dao.impl.BaseDaoImpl";
	private final static String baseService = "com.zyfast.service.BaseService";
	private final static String baseServiceImpl = "com.zyfast.service.impl.BaseServiceImpl";

	public final static String PACKAGE_NAME = "package";
	public final static String PACKAGE_PATH = "package_path";
	public final static String GENERATOR_PACKAGE_PATH = "com.zyfast.";// 包路径

	@SuppressWarnings("unchecked")
	public static void createFile(Map data, String path, String fileName,
			String templateName) {
		try {
			String filePath = path + fileName;
			Configuration cfg = FreemarkerManager.getConfiguration();// 初始化状态

			Template template = cfg.getTemplate(templateName);// 获取模板..
			File file = new File(filePath);
			File directory = file.getParentFile();
			if (!directory.exists()) {
				directory.mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 需要设置包名和实体名
	 * 
	 * @param params
	 *            "dao.ftl"
	 */
	@SuppressWarnings("unchecked")
	public static void genDao(String fullPath, List<Map> params,
			String fltPath, boolean isNeedBase) {
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> data = params.get(i);
			if (StringUtils.isEmpty(data.get(FreemarkerGenerate.PACKAGE_PATH))) {// 如果无提供包名.使用实体名
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase() + ".dao");
				data.put("importModel",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".entity.biz");
			} else {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						data.get(FreemarkerGenerate.PACKAGE_PATH) + ".dao");
				data.put("importModel",
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".entity.biz");
			}
			if (isNeedBase)
				data.put("importBaseDAO", baseDao);
			data.put("model", data.get("modelName"));
			createFile(data, fullPath + "\\"
					+ data.get("modelName").toLowerCase() + "\\dao\\",
					data.get("modelName") + "Dao.java", fltPath);
		}

	}

	@SuppressWarnings("unchecked")
	// "daoImpl.ftl"
	public static void genDaoImpl(String fullPath, List<Map> params,
			String fltPath, boolean isNeedBase) {
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> data = params.get(i);
			String modelName = data.get("modelName");
			if (StringUtils.isEmpty(data.get(FreemarkerGenerate.PACKAGE_PATH))) {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".dao.impl");
				data.put("importDao",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase() + ".dao");
				data.put("importModel",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".entity.biz");
			} else {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						data.get(FreemarkerGenerate.PACKAGE_PATH) + ".dao.impl");
				data.put("importDao", data.get(FreemarkerGenerate.PACKAGE_PATH)
						+ ".dao");
				data.put("importModel",
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".entity.biz");
			}
			if (isNeedBase)
				data.put("importAbstractDaoImpl", baseDaoImpl);

			data.put("model", modelName);
			String lowerModelName = modelName.toLowerCase();
			data.put("repository",
					lowerModelName.substring(0, 1) + modelName.substring(1));
			createFile(data, fullPath + "\\"
					+ data.get("modelName").toLowerCase() + "\\dao\\impl\\",
					modelName + "DaoImpl.java", fltPath);
		}
	}

	@SuppressWarnings("unchecked")
	// "service.ftl"
	public static void genService(String fullPath, List<Map> params,
			String fltPath, boolean isNeedBase) {
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> data = params.get(i);
			String modelName = data.get("modelName");
			if (StringUtils.isEmpty(data.get(FreemarkerGenerate.PACKAGE_PATH))) {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".service");
				data.put("importModel",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".entity.biz");
			} else {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						data.get(FreemarkerGenerate.PACKAGE_PATH) + ".service");
				data.put("importModel",
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".entity.biz");
			}
			if (isNeedBase)
				data.put("importBaseService", baseService);
			data.put("model", modelName);
			data.put("upperModel", modelName.toUpperCase());
			createFile(data, fullPath + "\\"
					+ data.get("modelName").toLowerCase() + "\\service\\",
					modelName + "Service.java", fltPath);
		}
	}

	@SuppressWarnings("unchecked")
	// "serviceImpl.ftl"
	public static void genServiceImpl(String fullPath, List<Map> params,
			String fltPath, boolean isNeedBase) {
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> data = params.get(i);
			String modelName = data.get("modelName");
			if (StringUtils.isEmpty(data.get(FreemarkerGenerate.PACKAGE_PATH))) {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".service.impl");
				data.put("importDao",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase() + ".dao");
				data.put("imorptService",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".service");
				data.put("importModel",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".entity.biz");
			} else {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".service.impl");
				data.put("importDao", data.get(FreemarkerGenerate.PACKAGE_PATH)
						+ ".dao");
				data.put("importService",
						data.get(FreemarkerGenerate.PACKAGE_PATH) + ".service");
				data.put("importModel",
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".entity.biz");
			}
			if (isNeedBase)
				data.put("imorptAbstractServiceImpl", baseServiceImpl);
			data.put("model", modelName);
			String lowerModelName = modelName.toLowerCase();
			data.put("lowerModel", lowerModelName);
			data.put("repository",
					lowerModelName.substring(0, 1) + modelName.substring(1));
			createFile(data,
					fullPath + "\\" + data.get("modelName").toLowerCase()
							+ "\\service\\impl\\", modelName
							+ "ServiceImpl.java", fltPath);
		}
	}

	@SuppressWarnings("unchecked")
	public static void genController(String fullPath, List<Map> params,
			String fltPath, boolean isNeedBase) {
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> data = params.get(i);
			String modelName = data.get("modelName");
			if (StringUtils.isEmpty(data.get(FreemarkerGenerate.PACKAGE_PATH))) {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".controller.admin");
				data.put("imorptService",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".service");
				data.put("importModel",
						GENERATOR_PACKAGE_PATH
								+ data.get("modelName").toLowerCase()
								+ ".entity.biz");
			} else {
				data.put(FreemarkerGenerate.PACKAGE_NAME,
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".controller.admin");
				data.put("importService",
						data.get(FreemarkerGenerate.PACKAGE_PATH) + ".service");
				data.put("importModel",
						data.get(FreemarkerGenerate.PACKAGE_PATH)
								+ ".entity.biz");
			}
			if (isNeedBase)
				data.put("model", modelName);
			String lowerModelName = modelName.toLowerCase();
			data.put("lowerModel", lowerModelName);
			data.put("repository",
					lowerModelName.substring(0, 1) + modelName.substring(1));
			createFile(data, fullPath + "\\"
					+ data.get("modelName").toLowerCase()
					+ "\\controller\\admin\\", modelName + "Controller.java",
					fltPath);
		}
	}

	public static String firstLetterUpper(String str) {
		if (str == null)
			return null;
		char[] charArray = str.toCharArray();
		if (charArray.length > 0) {
			charArray[0] = Character.toUpperCase(charArray[0]);
		}
		return new String(charArray);
	}

	public static String firstLetterLower(String str) {
		if (str == null)
			return null;
		char[] charArray = str.toCharArray();
		if (charArray.length > 0) {
			charArray[0] = Character.toLowerCase(charArray[0]);
			if (charArray.length > 1) {
				charArray[1] = Character.toLowerCase(charArray[1]);
			}
		}
		return new String(charArray);
	}
}
