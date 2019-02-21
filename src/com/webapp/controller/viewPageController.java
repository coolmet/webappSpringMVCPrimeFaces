package com.webapp.controller;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class viewPageController
{
	private static final Logger logger=LoggerFactory.getLogger(viewPageController.class);
	
	@RequestMapping("/mainPage")
	public ModelAndView mainPage()
	{
		logger.info("mainPage  >> viewMainPage");
		System.out.println("mainPage >> viewMainPage.jsf");
		String message="<br><div style='text-align:center;'>"
		+"<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from viewPageController.java **********</div><br><br>";
		return new ModelAndView("viewMainPage","message",message);
	}
	
	@RequestMapping("/partialPage")
	public ModelAndView partialPage()
	{
		logger.info("partialPage >> viewPartialPage.jsf");
		System.out.println("partialPage >> viewPartialPage.jsf");
		return new ModelAndView("viewPartialPage");
	}
	
	@RequestMapping("/carPage")
	public ModelAndView carPage()
	{
		logger.info("carPage >> viewCarPage.jsf");
		System.out.println("carPage >> viewCarPage.jsf");
		return new ModelAndView("viewCarPage");
	}
	
	@RequestMapping("/loginPage")
	public ModelAndView loginPage()
	{
		logger.info("loginPage >> viewLoginPage.jsf");
		System.out.println("loginPage >> viewLoginPage.jsf");
		return new ModelAndView("viewLoginPage");
	}
	
}
