package com.tej.doctor.doctormodule.service;

import com.tej.doctor.doctormodule.domain.Doctor;
import com.tej.doctor.doctormodule.dto.AppResponse;
import com.tej.doctor.doctormodule.dto.DoctorDto;
import com.tej.doctor.doctormodule.exception.NoDoctorsFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface DoctorService {

    List<Doctor> allRegisteredDoctors();

    public DoctorDto createDoctor(DoctorDto dto);

    public DoctorDto updateDocInfo(DoctorDto doctor);

    public void deleteDoctor(Long id);


    public ResponseEntity<AppResponse<List<DoctorDto>>> findVisitingDoctorBySpec(@PathVariable String Specialization);


   public List<DoctorDto> findAll(String spec);

    List<DoctorDto> ListAll(String name) throws NoDoctorsFoundException;

    List<DoctorDto> findVisitingDoctorBySpecialization(String spec);

    List<DoctorDto> findDoctorBySpec(String spec) throws NoDoctorsFoundException;


}
