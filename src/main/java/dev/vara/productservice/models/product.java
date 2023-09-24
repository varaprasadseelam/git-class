package dev.vara.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product extends BaseModel {

    private String Description;
    private String title;

    private String Image;

    private Category category;

    private double price;
}
