package com.pm.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String address;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private LocalDate registeredDate;

//    @CreationTimestamp
//    private LocalDateTime createdAt;
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;



}
