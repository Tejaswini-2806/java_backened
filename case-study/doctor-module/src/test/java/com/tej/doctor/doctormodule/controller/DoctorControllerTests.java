package com.tej.doctor.doctormodule.controller;
import com.tej.doctor.doctormodule.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class DoctorControllerTests {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;


    @DisplayName("Testing Post method for saving")
    @Test
    public void testPostMethod(){
        String url = "http://"+"localhost"+":"+port+"/doctor";
        var doctor = new Doctor();
        doctor.setId(10L);
        doctor.setName("vinay");
        doctor.setSpec("cardiologist");
        doctor.setHsNm("govt hospital");
        doctor.setHsLoc("bellary");
        doctor.setVisit(true);

        var re =template.postForEntity(url,doctor,Doctor.class);
        Assertions.assertEquals(HttpStatus.CREATED , re.getStatusCode());
    }


    @DisplayName("Get - Doctor - Checking Object Is non null")
    @Test
    public void testGetMethod(){

        String url = "http://"+"localhost"+":"+port+"/doctor";

        Doctor doctor = template.getForObject(url,Doctor.class);

        Assertions.assertNotNull(doctor);
    }


}


