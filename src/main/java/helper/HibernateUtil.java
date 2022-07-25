package helper;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class HibernateUtil {

    Helper propertiesReader = new Helper("hibernate.properties");

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("domain");
        sessionFactory.setHibernateProperties(propertiesReader.getProperties());
        return sessionFactory;
    }

    @Bean
    private DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(propertiesReader.readProperty("DRIVER_CLASS_NAME"));
        dataSource.setUrl(propertiesReader.readProperty("URL"));
        dataSource.setUsername(propertiesReader.readProperty("USERNAME"));
        dataSource.setPassword(propertiesReader.readProperty("PASSWORD"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
