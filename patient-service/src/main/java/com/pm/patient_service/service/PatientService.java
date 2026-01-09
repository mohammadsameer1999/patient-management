package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {

    public List<PatientResponseDto> getPatients();

}
