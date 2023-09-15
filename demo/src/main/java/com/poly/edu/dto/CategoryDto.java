package com.poly.edu.dto;

import com.poly.edu.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    @NotNull(message = "Category name is required")
    String name;
}