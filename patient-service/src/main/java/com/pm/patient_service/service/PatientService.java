package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    public List<PatientResponseDto> getPatients();
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto);
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto);

}
