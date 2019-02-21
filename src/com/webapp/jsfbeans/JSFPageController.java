package com.webapp.jsfbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="jsfPageController")
@SessionScoped
public class JSFPageController implements Serializable
{
	// faces-config.xml-> <navigation-rule>
	private static final long serialVersionUID=1L;
	
	public String processPage1()
	{
		System.out.println("processPage1:success");
		return "success";
	}
	
	public String processPage2()
	{
		System.out.println("processPage2:success");
		return "success";
	}
}
