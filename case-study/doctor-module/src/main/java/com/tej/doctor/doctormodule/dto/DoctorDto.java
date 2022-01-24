package com.tej.doctor.doctormodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@AllArgsConstructor
@Setter
@Getter

public class DoctorDto {
    private Long id;
    private String name;
    private String spec;
    private String hsNm;
    private String hsLoc;
    private Boolean visit;
}
