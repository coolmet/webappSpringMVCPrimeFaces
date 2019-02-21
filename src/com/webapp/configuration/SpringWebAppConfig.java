package com.webapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.webapp.controller, com.webapp.service")
@EnableTransactionManagement
public class SpringWebAppConfig implements WebMvcConfigurer// extends WebMvcConfigurerAdapter
{
	@Bean(name="viewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		// web.xml->servlet-context.xml
		// <beans:bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		// <beans:property name="prefix" value="/WEB-INF/views/" />
		// <beans:property name="suffix" value=".jsp" />
		// </beans:bean>
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsf");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		// web.xml->servlet-context.xml
		// <mvc:annotation-driven />
		// <mvc:default-servlet-handler />
		// <mvc:resources mapping="/resources/**" location="/resources/" />
		// <resources mapping="/resources/**" location="/resources/" />
		registry
		        .addResourceHandler("/resources/**").addResourceLocations("/resources/","classpath:/other-resources/")
		        .setCachePeriod(31556926)
		        .resourceChain(true)
		        .addResolver(new GzipResourceResolver())
		        .addResolver(new PathResourceResolver());
		// registry.addResourceHandler("/static/**").addResourceLocations("/resources/static/");
		
	}
}
