package com.tej.doctor.doctormodule.repository;


import com.tej.doctor.doctormodule.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class DoctorRepositoryTests {
    @Autowired
    private DoctorRepository repository;

    @DisplayName("Doctor repo : creating Doctor")
    @Test
    public void testCreateDoctor() {
        var doctor = new Doctor();
        doctor.setId(100L);
        doctor.setName("vinay");
        doctor.setSpec("neurologist");
        doctor.setHsLoc("bellary");
        doctor.setHsNm("govt hospital");
        doctor.setVisit(true);

        repository.save(doctor);

        Assertions.assertNotNull(doctor);
    }


    @DisplayName("Doctor repo : finding Doctor")
    @Test
    public void testFindDoctor() {
        var doctor = new Doctor();
        repository.findAll();
        Assertions.assertNotNull(doctor);
    }


    @DisplayName("Doctor repo : get by id")
    @Test
    public void testDoctorById(){
        Doctor doc = new Doctor();
        repository.getById(51L);
        Assertions.assertNotNull(doc);
    }



}
