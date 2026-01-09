package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pateint")
public class PatientController {
    @GetMapping("/getAllPatient")
    public ResponseEntity<PatientResponseDto> getAllPatient()
}
