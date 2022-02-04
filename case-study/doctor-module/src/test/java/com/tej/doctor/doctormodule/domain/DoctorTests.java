package com.tej.doctor.doctormodule.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DoctorTests {
    @DisplayName("Domain : Checking")
    @Test
    void testObjectCreation() {
        var doc = new Doctor();
        Assertions.assertNotNull(doc);
    }

    @DisplayName("Domain : Checking Getters and Setters")
    @Test
    void testObjectGettersSetters() {

        var doc = new Doctor();
        doc.setId(10L);
        doc.setName("Tejaswini");
        doc.setSpec("General Surgen");
        doc.setHsNm("Chord Road Hospital");
        doc.setHsLoc("Rajaji Nagar");
        doc.setVisit(true);
        Assertions.assertEquals(10,doc.getId());
        Assertions.assertEquals("Tejaswini",doc.getName());
        Assertions.assertEquals("General Surgen",doc.getSpec());
        Assertions.assertEquals("Chord Road Hospital",doc.getHsNm());
        Assertions.assertEquals("Rajaji Nagar",doc.getHsLoc());
        Assertions.assertEquals(true,doc.getVisit());
    }

}


