package com.codegen.configuration;

import com.codegen.annotation.FreemarkerComponent;
import freemarker.ext.jsp.TaglibFactory;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION 自定义 FreeMarkerConfigurer 配置类
 * @create 2018-05-31 11:38
 **/
public class CustomizeFreeMarkerConfigurer extends FreeMarkerConfigurer implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(FreemarkerComponent.class);
        Configuration configuration = this.getConfiguration();
        for (String key : map.keySet()) {
            configuration.setSharedVariable(key, map.get(key));
        }

        List<String> tlds = new ArrayList<>();
        tlds.add("/static/security.tld");
        TaglibFactory taglibFactory = getTaglibFactory();
        taglibFactory.setClasspathTlds(tlds);
        if(taglibFactory.getObjectWrapper() == null) {
            taglibFactory.setObjectWrapper(getConfiguration().getObjectWrapper());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
