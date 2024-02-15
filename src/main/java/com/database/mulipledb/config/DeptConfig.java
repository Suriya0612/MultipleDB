package com.database.mulipledb.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableJpaRepositories(
		basePackages ="com.database.mulipledb.second.repository",
		entityManagerFactoryRef="deptEntityManagerFactory",
		transactionManagerRef="deptTransactionManager")

public class DeptConfig {

@Autowired Environment env;
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean deptEntityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setDataSource(deptDataSource());
	        factory.setPackagesToScan(new String[] {"com.database.mulipledb.second.entity"});
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        factory.setJpaVendorAdapter(vendorAdapter);
	        
	        HashMap<String, Object> jpaProperties = new HashMap<>();
	        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	        jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        factory.setJpaPropertyMap(jpaProperties);

	        return factory;

	    }
	
	 @Bean
	    public DataSource deptDataSource() {
		 DriverManagerDataSource dataSource= new DriverManagerDataSource();
		 dataSource.setDriverClassName(env.getProperty("spring.second-datasource.driver-class-name"));
		 dataSource.setUrl(env.getProperty("spring.second-datasource.url"));
		 dataSource.setUsername(env.getProperty("spring.second-datasource.username"));
		 dataSource.setPassword(env.getProperty("spring.second-datasource.password"));

		 return dataSource;
	    }
	 
	 
	 @Bean
	    public PlatformTransactionManager deptTransactionManager() {
		  JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(deptEntityManagerFactory().getObject());
        return transactionManager;
	    }
	 
	 

	
}