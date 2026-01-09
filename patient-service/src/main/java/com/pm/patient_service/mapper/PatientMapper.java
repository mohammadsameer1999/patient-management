package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

import java.util.List;

public class PatientMapper {
    public static PatientResponseDto toDto(List<Patient> patient) {
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth().toString());
        patientResponseDto.setRegisterDate(patient.getRegisterDate().toString());

        return patientResponseDto;
    }
}
