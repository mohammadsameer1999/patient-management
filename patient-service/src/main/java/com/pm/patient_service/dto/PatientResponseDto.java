package com.pm.patient_service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
    private String registeredDate;

}
