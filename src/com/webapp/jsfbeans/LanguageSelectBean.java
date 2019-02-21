package com.webapp.jsfbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;
import com.webapp.model.Language;
import com.webapp.service.LanguageSelectService;

@Component
@Scope("singleton")
@ManagedBean
@SessionScoped
public class LanguageSelectBean implements Serializable
{
	
	private static final long serialVersionUID=1L;
	
	@Autowired
	@ManagedProperty("#{languageSelectService}")
	private LanguageSelectService service;
	
	private Language language;
	private List<Language> languages;
	
	@PostConstruct
	public void init()
	{
		languages=service.getLanguages();
	}
	
	public LanguageSelectService getService()
	{
		return service;
	}
	
	public void setService(LanguageSelectService service)
	{
		this.service=service;
	}
	
	public Language getLanguage()
	{
		return language;
	}
	
	public void setLanguage(Language language)
	{
		this.language=language;
	}
	
	public List<Language> getLanguages()
	{
		return languages;
	}
	
	public void setLanguages(List<Language> languages)
	{
		this.languages=languages;
	}
	
	public void localeCodeChanged(ValueChangeEvent e)
	{
		String newLocaleValue=e.getNewValue().toString();
		System.out.println(">>"+newLocaleValue);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(((Language)e.getNewValue()).getLocale());
	}
	
}
