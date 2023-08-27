package com.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hbm.EmployeeJpaDao;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.jdbc","com.hbm","com.utils"})
@PropertySources({@PropertySource("classpath:spring.properties")})
public class SpringJPAConfig {
	
	@Bean(name="employeeJpaDao")
	public EmployeeJpaDao employeeJpaDao()
	{
		EmployeeJpaDao employeeJpaDao = new EmployeeJpaDao();
		employeeJpaDao.setEntityManagerFactory(entityManagerFactory());
		return employeeJpaDao;
	}
	@Bean
	public EntityManagerFactory entityManagerFactory()
	{	
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(hibernateAdapterProperties());
		entityManagerFactory.setPackagesToScan(new String[] {"com.entity"});
		entityManagerFactory.afterPropertiesSet();
		return entityManagerFactory.getObject();
	}
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/devdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");;
		return dataSource;
	}
	@Bean
	public JpaVendorAdapter hibernateAdapterProperties()
	{
		HibernateJpaVendorAdapter hibAdapter = new HibernateJpaVendorAdapter();
		hibAdapter.setShowSql(true);
		hibAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");	
		//hibAdapter.setGenerateDdl(true);
		return hibAdapter;
	}
	@Bean
	public JpaTransactionManager jpaTransactionManager()
	{
		return new JpaTransactionManager(entityManagerFactory());
		
	}
	
}
