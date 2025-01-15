package com.example.final_module.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @Future(message = "Thời gian bắt đầu phải lớn hơn thời gian hiện tại")
    private LocalDateTime timeStart;

    @Future(message = "Thời gian kết thúc phải lớn hơn thời gian hiện tại")
    private LocalDateTime timeEnd;

    @NotNull(message = "Mức giảm giá không được để trống")
    @DecimalMin(value = "10000", message = "Mức giảm giá phải lớn hơn 10,000 VND")
    private Double priceDiscount;

    @NotBlank(message = "Chi tiết không được để trống")
    private String description;

}
