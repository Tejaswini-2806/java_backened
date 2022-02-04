package com.tej.doctor.doctormodule.controller;
import com.tej.doctor.doctormodule.domain.Doctor;
import com.tej.doctor.doctormodule.dto.AppResponse;
import com.tej.doctor.doctormodule.dto.DoctorDto;
import com.tej.doctor.doctormodule.exception.InvalidIdException;
import com.tej.doctor.doctormodule.exception.NoDoctorsFoundException;
import com.tej.doctor.doctormodule.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping //https://localhost:8080/doctor/
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto) {

        var svObj = service.createDoctor(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor Registered successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto) {
        try {
            var svObj = service.updateDocInfo(dto);
            var response = new AppResponse<DoctorDto>();
            response.setStatus("success");
            response.setMessage("Doctor updated successfully");
            response.setBody(svObj);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidIdException e) {
            var response = new AppResponse<DoctorDto>();
            response.setStatus("fail");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")//https://localhost:8080/doctor/delete
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id) {
        service.deleteDoctor(id);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor deleted successfully");
        return ResponseEntity.ok(response);
    }

        @GetMapping("/spec/{spec}")
        public ResponseEntity<AppResponse<List<DoctorDto>>> findDoctorBySpec (@PathVariable() String spec){
            try {
                var svObj = service.findDoctorBySpec(spec);
                var response = new AppResponse<List<DoctorDto>>();
                response.setStatus("success");
                response.setMessage("Doctors fetched successfully for given Specialization");
                response.setBody(svObj);
                return ResponseEntity.ok(response);
            } catch (NoDoctorsFoundException e) {
                var response = new AppResponse<List<DoctorDto>>();
                response.setStatus("failed");
                response.setMessage(e.getMessage());
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }
        }



