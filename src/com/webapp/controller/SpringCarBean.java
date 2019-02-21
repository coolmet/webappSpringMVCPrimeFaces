package com.webapp.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.webapp.model.Car;
import com.webapp.service.CarService;

@Component
@Scope("singleton")
@ManagedBean
@SessionScoped
public class SpringCarBean implements Serializable
{
	
	private static final long serialVersionUID=1L;
	private static final Logger logger=LoggerFactory.getLogger(SpringCarBean.class);
	
	@Autowired
	@ManagedProperty("#{carServiceImpl}")
	public CarService carService;
	
	public Car car;
	public List<Car> cars;
	
	public SpringCarBean()
	{
		super();
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("________________________________");
		System.out.println("springCarBean init has started");
		logger.info("springCarBean init");
		this.car=new Car();
		this.cars=carService.getAllCars();
		System.out.println("springCarBean init has finished, size:"+cars.size()
		+":"+cars.get(0).id+"/"+cars.get(0).year
		+":"+cars.get(cars.size()-1).id+"/"+cars.get(cars.size()-1).year);
		System.out.println("________________________________");
	}
	
	public void save()
	{
		System.out.println("________________________________");
		System.out.println("new car is going to be saved: {} ");
		logger.info("new car is going to be saved: {} ",this.car);
		System.out.println("springCarBean init has finished, size:"+cars.size());
		this.carService.saveCar(car);
		this.init();
		System.out.println("________________________________");
	}
	
	public String save2()
	{
		System.out.println("________________________________");
		System.out.println("new car is going to be saved: {} ");
		logger.info("new car is going to be saved: {} ",this.car);
		System.out.println("springCarBean init has finished, size:"+cars.size());
		this.carService.saveCar(car);
		this.init();
		System.out.println("________________________________");
		return "/carPage";
	}
	
	public Car getCar()
	{
		return car;
	}
	
	public void setCar(Car car)
	{
		this.car=car;
	}
	
	public CarService getCarService()
	{
		return carService;
	}
	
	public void setCarService(CarService carService)
	{
		this.carService=carService;
	}
	
	public List<Car> getCars()
	{
		return cars;
	}
	
	public void setCars(List<Car> cars)
	{
		this.cars=cars;
	}
	
}
