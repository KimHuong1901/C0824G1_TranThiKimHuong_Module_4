package com.example.bai_tap.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "INT")
    private Integer id;
    @Column(name="name", columnDefinition = "VARCHAR(30)")
    private String name;

}
