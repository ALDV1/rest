package com.example.testtask.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    @NotBlank
    private Integer id;

    @NotNull
    @NotBlank
    private String firstName;

    @Email
    @UniqueElements
    private String email;
    private String url;
    private boolean online;
    private Timestamp status;
}
