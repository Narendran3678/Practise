package com.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.hbm.EmployeeHbmDao;
import com.utils.HibernateUtils;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.jdbc","com.hbm","com.utils"})
@PropertySources({@PropertySource("classpath:spring.properties")})
public class SpringConfig {
	
	@Bean(name="employeeHdmDao")
	public EmployeeHbmDao getEmployeeHdmDao()
	{
		EmployeeHbmDao employeeHbmDao = new EmployeeHbmDao(gethibernateUtils());
		//employeeHbmDao.setHibernateTemplate(hibernateTemplate());
		return employeeHbmDao;
	}
	@Bean
	public HibernateUtils gethibernateUtils()
	{
		return new HibernateUtils(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan("com.entity");
		try {
			sessionFactory.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory.getObject();
	}
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/devdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");;
		return dataSource;
	}
	@Bean
	public Properties hibernateProperties()
	{
		Properties property = new Properties();
		property.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		//property.put("hibernate.hbm2ddl.auto","create-drop");
		property.put("hibernate.show_sql","true");
		property.put("hibernate.format_sql","true");
		return property;
	}
	
	@Bean 
	public HibernateTransactionManager hibernateTransactionManager()
	{
		return new HibernateTransactionManager(sessionFactory());
	}
	/*
	@Bean  
	public HibernateTemplate hibernateTemplate()
	{
		return new HibernateTemplate(sessionFactory());
	}
	*/
}
