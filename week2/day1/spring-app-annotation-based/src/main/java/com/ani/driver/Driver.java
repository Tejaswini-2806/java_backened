package com.ani.driver;

import com.ani.car.Car;
import org.springframework.beans.factory.annotation.Autowired;

public class Driver {

    // hey spring there is been called car, in a been configuration
    // kindly refer/point to that bean, so we can access it as needed
    @Autowired
    private Car car;
}
