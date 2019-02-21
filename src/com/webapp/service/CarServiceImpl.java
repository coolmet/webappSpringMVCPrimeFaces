package com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.webapp.model.Car;

@Service("carServiceImpl")
@Scope("singleton")
@ManagedBean
@SessionScoped
public class CarServiceImpl implements CarService
{
	
	private static final Logger logger=LoggerFactory
	                                                .getLogger(CarServiceImpl.class);
	
	private static final int RANDOM_LIST_SIZE=25;
	
	private static final String[] COLORS=new String[]
	{"Black","White",
	"Green","Red","Blue","Orange","Silver","Yellow","Brown",
	"Maroon"};
	
	private static final String[] BRANDS=new String[]
	{"BMW","Mercedes",
	"Volvo","Audi","Renault","Fiat","Volkswagen","Honda",
	"Jaguar","Ford"};
	
	private List<Car> savedCars;
	
	public CarServiceImpl()
	{
		savedCars=new ArrayList<>();
	}
	
	@Override
	public List<Car> getAllCars()
	{
		if(savedCars.size()==0)
		{
			
			for(int i=0;i<RANDOM_LIST_SIZE;i++)
			{
				Car c=new Car(getRandomId(),getRandomBrand(),getRandomYear(),
				              getRandomColor(),getRandomPrice());
				logger.info("car is created: "+c.id);
				savedCars.add(c);
			}
			System.out.println("carServiceImpl.getAllCars()>"+savedCars.size()
			+":"+savedCars.get(0).id+"/"+savedCars.get(0).year
			+":"+savedCars.get(savedCars.size()-1).id+"/"+savedCars.get(savedCars.size()-1).year);
			logger.info("Returning all the cars with size {}",savedCars.size());
		}
		return savedCars;
	}
	
	@Override
	public void saveCar(Car car)
	{
		car.setId(getRandomId());
		savedCars.add(0,car);
		logger.info("Car is saved: {}",car);
		System.out.println("carServiceImpl.save()>"+car.id+">>"+savedCars.size()+":"+savedCars.get(0).year+":"+savedCars.get(savedCars.size()-1).year);
		
	}
	
	private String getRandomId()
	{
		return UUID.randomUUID().toString().substring(0,8);
	}
	
	private int getRandomYear()
	{
		return (int)(Math.random()*50+1960);
	}
	
	private String getRandomColor()
	{
		return COLORS[(int)(Math.random()*COLORS.length)];
	}
	
	private String getRandomBrand()
	{
		return BRANDS[(int)(Math.random()*BRANDS.length)];
	}
	
	private int getRandomPrice()
	{
		return (int)(Math.random()*100000);
	}
	
}
