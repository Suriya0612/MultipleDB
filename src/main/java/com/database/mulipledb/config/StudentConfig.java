package com.database.mulipledb.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages ="com.database.mulipledb.first.repository",
		entityManagerFactoryRef="studentEntityManagerFactory",
		transactionManagerRef="studentTransactionManager")

public class StudentConfig {

	@Autowired Environment env;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory()
	{
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setDataSource(studentDataSource());
	    factory.setPackagesToScan(new String[]{"com.database.mulipledb.first.entity"});
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    
	    factory.setJpaVendorAdapter(vendorAdapter);
	    
	    HashMap<String, Object> jpaProperties = new HashMap<>();
	    jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	    jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    factory.setJpaPropertyMap(jpaProperties);
	 
	    return factory;
	}
	
@Bean
@Primary
public DataSource studentDataSource() {
	
	DriverManagerDataSource dataSource
    = new DriverManagerDataSource();
  dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
  dataSource.setUrl(env.getProperty("spring.datasource.url"));
  dataSource.setUsername(env.getProperty("spring.datasource.username"));
  dataSource.setPassword(env.getProperty("spring.datasource.password"));

  return dataSource;
}

@Bean
@Primary
public PlatformTransactionManager studentTransactionManager(){
	
	JpaTransactionManager transactionManager= new JpaTransactionManager();
  transactionManager.setEntityManagerFactory(studentEntityManagerFactory().getObject());
  return transactionManager;
}

}
