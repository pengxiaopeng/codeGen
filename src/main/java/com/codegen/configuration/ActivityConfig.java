package com.codegen.configuration;

import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-04-20 11:01
 **/
@Configuration
public class ActivityConfig {
    @Autowired
    private DataSource dataSource;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean(name = "processEngineConfiguration")
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setTransactionManager(dataSourceTransactionManager());
        // 若是oracle 则需要配置此项，为oracle用户名
        //springProcessEngineConfiguration.setDatabaseSchema(username);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        springProcessEngineConfiguration.setDataSource(dataSource);
        // 若是mysql 则需要配置此项，为数据库名.若不配置 则无法自动建工作流的表
        String[] urlArray = dbUrl.substring(0, dbUrl.indexOf("?")).split("/");
        springProcessEngineConfiguration.setDatabaseCatalog(urlArray[urlArray.length - 1]);
        springProcessEngineConfiguration.setActivityFontName("宋体");
        springProcessEngineConfiguration.setLabelFontName("宋体");
        return springProcessEngineConfiguration;
    }

    @Bean(name = "processEngine")
    public ProcessEngine processEngineFactoryBean() throws Exception {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration());
        return processEngineFactoryBean.getObject();
    }

    @Bean
    public RepositoryService repositoryService() throws Exception {
        return processEngineFactoryBean().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService() throws Exception {
        return processEngineFactoryBean().getRuntimeService();
    }

    @Bean
    public TaskService taskService() throws Exception {
        return processEngineFactoryBean().getTaskService();
    }

    @Bean
    public HistoryService historyService() throws Exception {
        return processEngineFactoryBean().getHistoryService();
    }

    @Bean
    public ManagementService managementService() throws Exception {
        return processEngineFactoryBean().getManagementService();
    }

}
