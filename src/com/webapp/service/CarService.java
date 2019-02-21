package com.webapp.service;

import java.util.List;
import com.webapp.model.Car;

public interface CarService
{
	List<Car> getAllCars();
		
	void saveCar(final Car car);
}
