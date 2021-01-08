package com.ltfs.configurations;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
/**
 * @author Sandip Shinde
 * @email sandip.shinde@cmss.in
 * @created 
 * @purpose Local databse configuration
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
basePackages = "com.ltfs.repository")

public class DcdDBConfiguration {

	@Value("${dcd.datasource.username}")
	private String username;

	@Value("${dcd.datasource.password}")
	private String password;

	@Value("${dcd.datasource.url}")
	private String url;

	@Value("${dcd.datasource.driverClassName}")
	private String className;
	
	
	@Primary
	@Bean(name = "localSource")
	public DataSource localSource() {
			return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(password)
				.driverClassName(className).build();
		 
	}
	  @Primary
	 @Bean(name="entityManagerFactory")
	    LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("localSource")DataSource localSource, 
	                                                                Environment env) {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(localSource);
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("dcd.repository.model.package"));///repository path
	 
	        Properties jpaProperties = new Properties();
	     
	        //Configures the used database dialect. This allows Hibernate to create SQL
	        //that is optimized for the used database.
	        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("dcd.hibernate.dialect"));
	 
	        //Specifies the action that is invoked to the database when the Hibernate
	        //SessionFactory is created or closed.
	        jpaProperties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("dcd.hibernate.hbm2ddl.auto")
	        );
	 
	        //Configures the naming strategy that is used when Hibernate creates
	        //new database objects and schema elements
	        jpaProperties.put("hibernate.ejb.naming_strategy",env.getRequiredProperty("dcd.hibernate.ejb.naming_strategy")
	        );
	 
	        //If the value of this property is true, Hibernate writes all SQL
	        //statements to the console.
	        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("dcd.hibernate.show_sql")
	        );
	 
	        //If the value of this property is true, Hibernate will format the SQL
	        //that is written to the console.
	        jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("dcd.hibernate.format_sql")
	        );
	 
	        entityManagerFactoryBean.setJpaProperties(jpaProperties);
	 
	        return entityManagerFactoryBean;
	    }
	
}
