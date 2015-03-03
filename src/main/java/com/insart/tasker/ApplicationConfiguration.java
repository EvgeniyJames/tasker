package com.insart.tasker;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static com.insart.tasker.TaskerConstants.*;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 0:51
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = ApplicationConfiguration.class, excludeFilters = @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION))
@EnableJpaRepositories(basePackages = "com.insart.tasker.dao")
@PropertySource("classpath:application.properties")
@Import(MvcConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(TASKER_DB_DRIVER_PROPERTY_NAME));
        dataSource.setUrl(environment.getProperty(TASKER_DB_URL_PROPERTY_NAME));
        dataSource.setUsername(environment.getProperty(TASKER_DB_USERNAME_PROPERTY_NAME));
        dataSource.setPassword(environment.getProperty(TASKER_DB_PASSWORD_PROPERTY_NAME));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(TASKER_HIBERNATE_EM_PACKAGE_PROPERTY_NAME));

        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty(TASKER_HIBERNATE_DIALECT_PROPERTY_NAME));
        properties.put("hibernate.show_sql", environment.getProperty(TASKER_HIBERNATE_SHOW_SQL_PROPERTY_NAME));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty(TASKER_HIBERNATE_TO_DDL_PROPERTY_NAME));
        return properties;
    }


}

