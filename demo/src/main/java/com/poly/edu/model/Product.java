package com.poly.edu.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "unit_price", nullable = false)
    private String unitPrice;

    @Column(name = "image", nullable = false, length = 100000)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "discount", nullable = false)
    private Float discount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

}