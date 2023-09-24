package dev.vara.productservice.services;

import dev.vara.productservice.dtos.GenericProductDto;
import dev.vara.productservice.models.product;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);
    GenericProductDto CreateProduct(GenericProductDto product);
   List<GenericProductDto> getAllProducts();
   GenericProductDto deleteProductById(Long id);



}
