package com.tej.doctor.doctormodule.service;

import com.tej.doctor.doctormodule.domain.Doctor;
import com.tej.doctor.doctormodule.dto.AppResponse;
import com.tej.doctor.doctormodule.dto.DoctorDto;
import com.tej.doctor.doctormodule.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl  implements DoctorService{

@Autowired
    public DoctorRepository repository;

    @Override
    public List<Doctor> allRegisteredDoctors() {
       var doc =  repository.findAll();
        return doc;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctor) {

        var doc = new Doctor();
        doc.setId(doctor.getId());
        doc.setName(doctor.getName());
        doc.setSpec(doctor.getSpec());
        doc.setHsNm(doctor.getHsNm());
        doc.setHsLoc(doctor.getHsLoc());
        doc.setVisit(doctor.getVisit());
        repository.save(doc);
        return doctor;
    }

    @Override
    public DoctorDto updateDocInfo(DoctorDto doctor) {
        Doctor doc = repository.findById(doctor.getId()).orElse(null);
        var doc1 = new Doctor();
        doc1.setId(doctor.getId());
        doc1.setName(doctor.getName());
        doc1.setSpec(doctor.getSpec());
        doc1.setHsNm(doctor.getHsNm());
        doc1.setHsLoc(doctor.getHsLoc());
        doc1.setVisit(doctor.getVisit());
        repository.save(doc1);
        return doctor;
    }

    @Override
    public void deleteDoctor(Long id) {

        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<AppResponse<List<DoctorDto>>> findVisitingDoctorBySpec(String Specialization) {
        return null;
    }



    @Override
    public List<DoctorDto> findAll(String spec) {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDto> dtos = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor = doctors.get(i); // you are getting ith element
            DoctorDto dto = new DoctorDto(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpec(),
                    doctor.getHsNm(),
                    doctor.getHsLoc(),
                    doctor.getVisit()
            );
            dtos.add(dto);
        }
        return dtos;


    }

    @Override
    public List<DoctorDto> ListAll(String name) {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDto> dtos = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor = doctors.get(i); // you are getting ith element
            DoctorDto dto = new DoctorDto(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpec(),
                    doctor.getHsNm(),
                    doctor.getHsLoc(),
                    doctor.getVisit()
            );
            dtos.add(dto);
        }
        return dtos;


    }
    @Override
    public List<DoctorDto> findVisitingDoctorBySpecialization(String spec) {

        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.getVisit()== true  && n.getSpec().equals(spec))
                .map (doc -> new DoctorDto(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpec(),
                        doc.getHsNm(),
                        doc.getHsLoc(),
                        doc.getVisit()
                ))
                .collect(Collectors.toList());
        return dto1;
    }


}