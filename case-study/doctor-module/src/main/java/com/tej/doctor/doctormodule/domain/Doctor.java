package com.tej.doctor.doctormodule.domain;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(unique =false, nullable = false)
    private String spec;


    @Column(nullable = true)
    private String hsNm;

    @Column( nullable = false, unique = false)
    private String hsLoc;

    @NotNull
    @Column( nullable = false)
    private Boolean visit;
}
