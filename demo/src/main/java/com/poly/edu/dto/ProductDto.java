package com.poly.edu.dto;

import com.poly.edu.model.Product;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Product}
 */
@Value
public class ProductDto implements Serializable {
    Long id;
    String name;
    String quantity;
    String unitPrice;
    MultipartFile image;
    String description;
    Float discount;
    LocalDate date;
    Integer status;
    Long categoryId;
}