package com.webapp.configuration;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebXml // implements WebApplicationInitializer
{
	
	// @Override
	// public void onStartup(ServletContext servletContext) throws ServletException
	// {
	// AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
	// context.register(SpringWebAppConfig.class);
	// context.setServletContext(servletContext);
	// servletContext.addListener(new ContextLoaderListener(context));
	// context.refresh();
	// //
	// ServletRegistration.Dynamic servlet=servletContext.addServlet("SpringDispatcher",new DispatcherServlet(context));
	// servlet.setLoadOnStartup(1);
	// servlet.setAsyncSupported(true);
	// servlet.addMapping("/");
	// //
	// System.out.println("#########################################");
	// String[] beans=context.getBeanDefinitionNames();
	// Arrays.sort(beans);
	// for(String bean:beans)
	// {
	// if(context.getBean(bean).getClass().getName().startsWith("com.webapp"))
	// {
	// System.out.println(bean+"\t>\t"+context.getBean(bean).getClass().getName()+"\t"+getAnnotationsNames(context.getBean(bean).getClass()));
	// }
	// }
	// }
	//
	// public String getAnnotationsNames(Class c)
	// {
	// String retStr="{";
	// for(Annotation annotation:c.getAnnotations())
	// {
	// retStr+=annotation.annotationType().getSimpleName()+", ";
	// }
	// return retStr+"}";
	// }
}
