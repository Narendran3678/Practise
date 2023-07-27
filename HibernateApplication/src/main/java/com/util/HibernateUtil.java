package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Student;

public class HibernateUtil {
	private static HibernateUtil hibernateUtil = new HibernateUtil();
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	public static HibernateUtil getInstance() {
		return hibernateUtil;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metaSource = new MetadataSources(registry);
				Metadata metadata = metaSource.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public SessionFactory getSessionFactoryJava() {
		ServiceRegistry svcRegistry = null;
		if (sessionFactory == null) {
			try {

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/devdb");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				Configuration configuration = new Configuration();
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);

				svcRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(svcRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (svcRegistry != null) {
					StandardServiceRegistryBuilder.destroy(svcRegistry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
