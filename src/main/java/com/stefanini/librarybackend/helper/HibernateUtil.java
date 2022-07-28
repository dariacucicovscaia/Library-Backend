package com.stefanini.librarybackend.helper;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.stefanini.librarybackend.service","com.stefanini.librarybackend.dao"})
public class HibernateUtil {


    private Environment enviroment;

    public HibernateUtil(Environment enviroment) {
        this.enviroment = enviroment;
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        //dataSource.setPassword(enviroment.getProperty("db.driver"));
        dataSource.setPassword(enviroment.getProperty("jdbc.password"));
        dataSource.setUser(enviroment.getProperty("jdbc.root"));
        dataSource.setUrl(enviroment.getProperty("jdbc.url"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.stefanini.librarybackend.domain");
        entityManagerFactoryBean.setDataSource(dataSource());
        Properties jpaProperties = new Properties();


        jpaProperties.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));


        jpaProperties.put("hibernate.hbm2ddl.auto",
                enviroment.getRequiredProperty("spring.jpa.hibernate.ddl-auto")
        );

        jpaProperties.put("hibernate.ejb.naming_strategy",
                enviroment.getRequiredProperty("hibernate.ejb.naming_strategy")
        );

        jpaProperties.put("hibernate.show_sql",
                enviroment.getRequiredProperty("hibernate.show_sql")
        );

        jpaProperties.put("hibernate.format_sql",
                enviroment.getRequiredProperty("hibernate.format_sql")
        );

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

}