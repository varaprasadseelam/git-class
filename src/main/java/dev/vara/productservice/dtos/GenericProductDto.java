package dev.vara.productservice.dtos;

import dev.vara.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String Description;
    private String title;

    private String Image;

    private String  category;

    private double price;
}
