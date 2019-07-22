package com.tampro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.tampro")
@PropertySource(value = { "classpath:db.properties" })
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	Environment envi;

	@Bean
	public ViewResolver viewResolver() {
		/*
		 * InternalResourceViewResolver viewResolver = new
		 * InternalResourceViewResolver(); viewResolver.setViewClass(JstlView.class);
		 * viewResolver.setPrefix("/WEB-INF/views/"); viewResolver.setSuffix(".jsp");
		 */
		TilesViewResolver viewResolver = new TilesViewResolver();

		return viewResolver;
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public TilesConfigurer tileConfigurer() {

		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("classpath:tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasenames("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mysql://localhost:3306/banhang");
		return dataSource;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1); // -1 ko gioi hang
		return commonsMultipartResolver;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public JavaMailSender javaMailSender()
	{
		JavaMailSenderImpl mailSenderImpl  = new JavaMailSenderImpl();
		mailSenderImpl.setHost("smtp.gmail.com"); //host mail sever
		mailSenderImpl.setPort(587); // cong quy dinh mail
		mailSenderImpl.setUsername("xomrayno5@gmail.com");
		mailSenderImpl.setPassword("tam01294428542");
		mailSenderImpl.setDefaultEncoding("utf-8");
		
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.starttls.enable", "true"); // them cai nay ko bi loi smtp @@~
		mailSenderImpl.setJavaMailProperties(properties);
		return mailSenderImpl;
	}

	             
	  
	  
	  
	  
	  
}
