package com.webapp.admin;

import java.util.HashMap;
import java.util.Map;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@ManagedBean
@RequestScoped
public class PrintAllBeans implements ApplicationContextAware
{
	
	private Map<String,Integer> beanReferenceCounter=new HashMap<String,Integer>();
	private StringBuilder outputMessage;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		outputMessage=new StringBuilder();
		beanReferenceCounter.clear();
		outputMessage.append("--- PrintBeans begin ---\n");
		dumpApplicationContext(context);
		dumpBeansWithoutReference();
		dumpFacesBeans();
		outputMessage.append("--- PrintBeans end ---\n");
		System.out.print(outputMessage);
	}
	
	private void dumpFacesBeans()
	{
		ExternalContext externalContext=FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap=externalContext.getRequestMap();
		
		for(String key:requestMap.keySet())
		{
			System.out.println("FacesBean:\t"+key+"\t:\t"+requestMap.get(key));
		}
		
	}
	
	private void dumpBeansWithoutReference()
	{
		outputMessage.append("Beans without reference:\n");
		for(String bean:beanReferenceCounter.keySet())
		{
			if(beanReferenceCounter.get(bean)==0)
			{
				outputMessage.append("  ").append(bean).append('\n');
			}
		}
	}
	
	private void initBeanReferenceIfNotExist(String beanName)
	{
		Integer count=beanReferenceCounter.get(beanName);
		if(count==null)
		{
			beanReferenceCounter.put(beanName,0);
		}
	}
	
	private void increaseBeanReference(String beanName)
	{
		Integer count=beanReferenceCounter.get(beanName);
		if(count==null)
		{
			count=new Integer(0);
		}
		beanReferenceCounter.put(beanName,++count);
	}
	
	private void dumpApplicationContext(ApplicationContext context)
	{
		// Read context id isn't available. https://jira.springsource.org/browse/SPR-8816
		String appContextInfo=String.format("ApplicationContext %s : %s",context.getId(),context.getClass()
		                                                                                        .getName());
		ApplicationContext parent=context.getParent();
		if(parent!=null)
		{
			appContextInfo+=String.format(" -> %s",parent.getId());
		}
		outputMessage.append(appContextInfo).append('\n');
		
		ConfigurableListableBeanFactory factory=((AbstractRefreshableApplicationContext)context).getBeanFactory();
		for(String beanName:factory.getBeanDefinitionNames())
		{
			if(factory.getBeanDefinition(beanName).isAbstract())
			{
				continue;
			}
			initBeanReferenceIfNotExist(beanName);
			Object bean=factory.getBean(beanName);
			outputMessage.append(String.format("  %s : %s\n",beanName,bean.getClass().getName()));
			for(String dependency:factory.getDependenciesForBean(beanName))
			{
				outputMessage.append(String.format("    -> %s\n",dependency));
				increaseBeanReference(dependency);
			}
		}
		
		if(parent!=null)
		{
			outputMessage.append("Parent:\n");
			dumpApplicationContext(parent);
		}
	}
	
}
