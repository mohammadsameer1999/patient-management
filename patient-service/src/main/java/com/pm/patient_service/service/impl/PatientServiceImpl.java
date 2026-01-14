package com.pm.patient_service.service.impl;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import com.pm.patient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        System.out.println("get All Patient us Here-----<><><><> " + patients);
        return patients.stream().map(PatientMapper::toDto).toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email "
                    + "already exists " + patientRequestDto.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDto));
        System.out.println("Patient data save in db----<><><><><> " + newPatient.getEmail());
        log.info("Patient data save in db----<><><><><>", newPatient);
        return PatientMapper.toDto(newPatient);
    }

    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found with ID: "+ id));
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email "
                    + "already exists " + patientRequestDto.getEmail());
        }
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDto.getRegisteredDate()));
        Patient updatePatient = patientRepository.save(patient);
        System.out.println("Update PAtient---<><><><> " + updatePatient);
        return PatientMapper.toDto(updatePatient);

    }
}