package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.service.PatientService;
import com.pm.patient_service.validators.CreatePatientValidationGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@Tag(name = "patient", description = "API for managing Patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/getAllPatient")
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatient() {
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @PostMapping("/create-patient")
    @Operation(summary = "Create a new  Patients")

    public ResponseEntity<PatientResponseDto> createPatient(
            @Validated ({Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok(patientResponseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a   Patients")

    public ResponseEntity<PatientResponseDto> updatePatient(
            @PathVariable Long id,
          @Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patientResponseDto = patientService.updatePatient(id,patientRequestDto);
        return ResponseEntity.ok(patientResponseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a   Patients")

    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
