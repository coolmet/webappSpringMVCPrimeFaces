package com.webapp.model;

import java.util.Locale;

public class Language
{
	private int id;
	private String displayName;
	private String name;
	private Locale locale;
	
	public Language()
	{
	}
	
	public Language(int id,String displayName,String name,Locale locale)
	{
		this.id=id;
		this.displayName=displayName;
		this.name=name;
		this.locale=locale;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public void setDisplayName(String displayName)
	{
		this.displayName=displayName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public Locale getLocale()
	{
		return locale;
	}
	
	public void setLocale(Locale locale)
	{
		this.locale=locale;
	}
	
	@Override
	public String toString()
	{
		return displayName;
	}

}
