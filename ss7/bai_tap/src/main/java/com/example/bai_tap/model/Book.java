package com.example.bai_tap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Please enter the name for this book")
    private String name;
    @NotEmpty(message = "Please enter the author name for this book")
    private String author;
    @NotNull(message = "Please enter the description for this book")
    private String description;
    @NotNull (message = "Please enter the quantity for this book")
    private Integer quantity;
    @Min(10000)
    @Max(99999)
    private Integer code;
}
