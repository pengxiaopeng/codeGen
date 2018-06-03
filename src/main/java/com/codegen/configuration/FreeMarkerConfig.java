package com.codegen.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-04-19 9:51
 **/
@Configuration
public class FreeMarkerConfig extends FreeMarkerAutoConfiguration{
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Value("${spring.freemarker.template-loader-path}")
    private String templateLoaderPath;
    @Value("${spring.freemarker.prefer-file-system-access}")
    private Boolean preferFileSystemAccess;
    @Value("${spring.freemarker.charset}")
    private String charset;
    @Value("${spring.freemarker.suffix}")
    private String suffix;

    public FreeMarkerConfig(ApplicationContext applicationContext, FreeMarkerProperties properties) {
        super(applicationContext, properties);
    }

    @Bean("freeMarkerConfigurer")
    public FreeMarkerConfigurer getFreemarkerConfig() {
        FreeMarkerConfigurer factory = new CustomizeFreeMarkerConfigurer();

        factory.setTemplateLoaderPaths(templateLoaderPath);
        factory.setPreferFileSystemAccess(preferFileSystemAccess);
        factory.setDefaultEncoding(charset);
        return factory;
    }
}
