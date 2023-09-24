package dev.vara.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FareStoreProductdto {

    private Long id;
    private String title;
    private String description;
    private double price;

    private String category;

    private String image;

}
