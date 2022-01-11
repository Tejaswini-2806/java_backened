package com.ani.car;

import com.ani.temp.Temp;
import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    @Autowired
    private Temp temp;
    public void speedUp() {
        System.out.println("Speeding Up the Car");
    }
}
