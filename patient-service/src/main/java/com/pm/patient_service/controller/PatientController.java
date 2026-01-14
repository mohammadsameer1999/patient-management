package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pateint")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/getAllPatient")
    public ResponseEntity<List<PatientResponseDto>> getAllPatient() {
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @PostMapping("/create-patient")
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok(patientResponseDto);
    }

    @PostMapping("/update-patient")
    public ResponseEntity<PatientResponseDto> updatePatient(@Valid @RequestBody)
}
