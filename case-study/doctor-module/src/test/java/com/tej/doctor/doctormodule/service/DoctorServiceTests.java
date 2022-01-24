package com.tej.doctor.doctormodule.service;

import com.tej.doctor.doctormodule.domain.Doctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class DoctorServiceTests {
    @Autowired
    private DoctorServiceImpl service; // I want to create fake behaviour, I can use mocking

    @DisplayName("Service : Doctor Not Null")
    @Test
    public void testDoctorSave() {

        Doctor doctor = new Doctor();
        doctor.setSpec("E&T");
        doctor.setHsLoc("Rajaji Nagar");
        doctor.setName("Tejaswini");


    }

    @DisplayName("Service : Car Equality")
    @Test
    public void testCarEquality() {
        Doctor doctor = new Doctor();
        doctor.setName("Tejaswini");
        doctor.setHsNm("Chord Road Hospital");
        doctor.setSpec("General surgen");


    }


}
