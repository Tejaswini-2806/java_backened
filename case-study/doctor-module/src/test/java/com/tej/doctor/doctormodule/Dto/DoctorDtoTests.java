package com.tej.doctor.doctormodule.Dto;

import com.tej.doctor.doctormodule.domain.Doctor;
import com.tej.doctor.doctormodule.dto.DoctorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorDtoTests {

    @DisplayName("DTO : Checking")
    @Test
    void testObjectCreation() {

        Long id = 10l;
        String name = "shruthi";
        String spiel= "neurologist";
        String hsName = "megan";
        String hsLoc = "shimoga";
        boolean visiting = true;
        DoctorDto doc = new DoctorDto(id,name,spiel,hsName,hsLoc,visiting);
        long result = doc.getId();
        assertEquals(id, result);
        String result2 = doc.getName();
        assertEquals(name, result2);
        String result3 = doc.getSpec();
        assertEquals(spiel, result3);
        String result4 = doc.getHsLoc();
        assertEquals(hsLoc, result4);
        String result5 = doc.getHsNm();
        assertEquals(hsName, result5);
        boolean result6 = doc.getVisit();
        assertEquals(result6, visiting);
        Assertions.assertNotNull(doc);
    }

    @DisplayName("DTO : Checking Getters")
    @Test
    void testObjectGetters() {

        var doc = new Doctor();
        doc.setId(10L);
        doc.setName("shruthi");
        doc.setSpec("neurologist");
        doc.setHsNm("megan");
        doc.setHsLoc("shimoga");
        doc.setVisit(true);
        assertEquals(10,doc.getId());
        assertEquals("shruthi",doc.getName());
        assertEquals("neurologist",doc.getSpec());
        assertEquals("megan",doc.getHsNm());
        assertEquals("shimoga",doc.getHsLoc());
        assertEquals(true,doc.getVisit());

    }

}
