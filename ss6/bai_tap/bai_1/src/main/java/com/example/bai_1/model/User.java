package com.example.bai_1.model;

import com.example.bai_1.repository.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45, message = "Lenght have to from 5 to 45")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Lenght have to from 5 to 45")
    private String lastName;
    @Size(min = 10, max = 10, message = "The phone number must consist of 10 digits.")
    private String phoneNumber;
    @Pattern(regexp = "^(1[89]|[2-9]\\d|1\\d{2,})$", message = "Age must be a valid number and at least 18")
    private Integer age;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    @UserRepository.ValidEmail
    @Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org|net)$",
            message = "Email must end with .com, .org, or .net"
    )
    private String email;
}
