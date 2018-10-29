package test.config;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by wowa on 22.10.2018.

 */
@Configuration
@EnableJpaRepositories("test.dao")
@EnableTransactionManagement
public class DataConfig {
    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:h2:mem:dbtest;DB_CLOSE_DELAY=-1");
      //  dataSource.setUrl("jdbc:h2:mem:bdtest");
        return dataSource;


    }

    @Bean
    public JpaVendorAdapter vendorAdapter(){

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        return adapter;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter());
        factory.setPackagesToScan("test.entity");
        Properties properties = new Properties();
        properties.setProperty("hibernat.hbm2dll.auto","update");

        factory.setJpaProperties(properties);
        return factory;

        }

        @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory){
    return new JpaTransactionManager(factory);

        }


    }


