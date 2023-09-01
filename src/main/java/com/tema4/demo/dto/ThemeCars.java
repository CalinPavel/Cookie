package com.tema4.demo.dto;

import com.tema4.demo.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ThemeCars {
    Boolean darkMode;
    List<Car> currentCars = new ArrayList<>();
}
