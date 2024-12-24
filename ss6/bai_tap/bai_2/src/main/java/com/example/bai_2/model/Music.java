package com.example.bai_2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="music")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 1, max = 800, message = "Maximum 800 character")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Only letters, numbers, and spaces are allowed")
    private String name;
    @NotBlank
    @Size(max = 300, message = "Maximum 300 character")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Only letters, numbers, and spaces are allowed")
    private String singer;
    @NotBlank
    @Size(max = 1000, message = "Maximum 1000 character")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]+$", message = "Only letters, numbers, spaces, and commas are allowed")
    private String typeMusic;

}
