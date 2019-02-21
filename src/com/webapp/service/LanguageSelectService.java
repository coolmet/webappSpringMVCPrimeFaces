package com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import com.webapp.model.Language;

@ManagedBean(name="languageSelectService",eager=true)
@ApplicationScoped
public class LanguageSelectService
{
	private List<Language> languages;
	
	@PostConstruct
	public void init()
	{
		languages=new ArrayList<>();
		languages.add(new Language(0,"TR","tr_TR",new Locale("tr_TR")));
		languages.add(new Language(1,"EN","en_EN",new Locale("en_EN")));
		languages.add(new Language(2,"DE","de_DE",new Locale("de_DE")));
	}
	
	public List<Language> getLanguages()
	{
		return languages;
	}
	
}
