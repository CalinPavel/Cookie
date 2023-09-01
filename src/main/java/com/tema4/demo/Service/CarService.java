package com.tema4.demo.Service;

import com.tema4.demo.dto.ThemeCars;
import com.tema4.demo.model.Car;
import com.tema4.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car addCar(Car c){
        return carRepository.save(c);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public ThemeCars getAllCarsTheme(Boolean cookieValue){
        ThemeCars dto = new ThemeCars();
        dto.setCurrentCars(carRepository.findAll());
        dto.setDarkMode(cookieValue);
        return  dto;
    }

}
