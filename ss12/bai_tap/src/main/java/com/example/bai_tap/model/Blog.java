package com.example.bai_tap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", columnDefinition = "INT")
    private Integer id;
    @Column(name= "title", columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(name= "content", columnDefinition = "TEXT")
    private String content;
    @Column(name= "author", columnDefinition = "VARCHAR(30)")
    private String author;
    @Column(name="time_setup", columnDefinition = "DATE")
    private Date time;
    @ManyToOne
    @JoinColumn(name="id_category", referencedColumnName = "id")
    private Category category;
}
