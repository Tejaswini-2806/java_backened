package com.tej.doctor.doctormodule.controller;


import com.tej.doctor.doctormodule.domain.Doctor;
import com.tej.doctor.doctormodule.dto.AppResponse;
import com.tej.doctor.doctormodule.dto.DoctorDto;
import com.tej.doctor.doctormodule.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping //https://localhost:8080/doctor/
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto){

        var svObj  = service.createDoctor(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor saved successfully");
        response.setBody(svObj);


        return ResponseEntity.ok(response);
    }


    @PutMapping("/update")//https://localhost:8080/doctor/update
    public ResponseEntity<AppResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto){

        var svObj = service.updateDocInfo(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor updated successfully");
        response.setBody(svObj);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")//https://localhost:8080/doctor/delete
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id){

        service.deleteDoctor(id);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/{spec}")
    public ResponseEntity<AppResponse<List<Doctor>>> searchOfDoctorBySpec(@PathVariable("spec") String spec) {
        service.findAll(spec);
        var response = new AppResponse<List<Doctor>>();
        response.setMessage("Doctor Specialization");
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reg/{name}")
    public ResponseEntity<AppResponse<List<Doctor>>> listOfDoctorRegistration(@PathVariable("name") String name) {
        service.findAll(name);
        var response = new AppResponse<List<Doctor>>();
        response.setMessage("list of Doctor registration");
        response.setStatus("success");


        return ResponseEntity.ok(response);
    }

    @GetMapping("/spec/{specialization}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findVisitingDoctorBySpec(@PathVariable String specialization){

        var svObj = service.findVisitingDoctorBySpec(specialization);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody((List<DoctorDto>) svObj);
        return ResponseEntity.ok(response);
    }


}

