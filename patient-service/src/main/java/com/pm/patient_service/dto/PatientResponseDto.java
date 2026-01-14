package com.pm.patient_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
    private String registeredDate;

}
