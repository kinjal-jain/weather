package io.egen.weather;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("io.egen.weather.persistence.entity");
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/weather-db");
		ds.setUsername("root");
		ds.setPassword("haveconfidence");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager tranMgr(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	
	private Properties jpaProperties(){
		Properties pro = new Properties();
		pro.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pro.setProperty("hibernate.hbm2ddl.auto", "create");
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("hibernate.format_sql", "true");
		return pro;
		
	}
	
}

