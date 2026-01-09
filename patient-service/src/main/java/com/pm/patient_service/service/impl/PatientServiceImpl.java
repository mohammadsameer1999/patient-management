package com.pm.patient_service.service.impl;

import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import com.pm.patient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper mapper;

    @Override
    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
      List<PatientResponseDto> patientResponseDtos =   patients.stream().map(x -> PatientMapper.toDto(patients)).toList();
        return patientResponseDtos;
    }
}
