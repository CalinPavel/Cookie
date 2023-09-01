package com.tema4.demo.controller;

import com.tema4.demo.Service.CarService;
import com.tema4.demo.dto.DarkMode;
import com.tema4.demo.dto.ThemeCars;
import com.tema4.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping(value = "/addCar")
    public Car CreateCustomer(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars(@CookieValue(name = "theme") Boolean cookieValue){

        ResponseCookie springCookie = ResponseCookie.from("theme", cookieValue.toString())
                .path("/")
                .build();


        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE , springCookie.toString())
                .body(carService.getAllCarsTheme(cookieValue));
    }

    @PutMapping(value = "/dark-mode")
    public ResponseEntity<?> setTheme(@RequestBody DarkMode darkMode){

        String var = "false";

        if(darkMode.getDarkMode()){
            var = "true";
        }

        ResponseCookie springCookie = ResponseCookie.from("theme", var)
                .path("/")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE , springCookie.toString())
                .build();
    }

}
