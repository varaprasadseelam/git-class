package dev.vara.productservice.services;

import dev.vara.productservice.dtos.GenericProductDto;
import dev.vara.productservice.models.product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
   public  GenericProductDto CreateProduct(GenericProductDto product)
   {
       return null;
   }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
