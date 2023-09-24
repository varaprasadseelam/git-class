package dev.vara.productservice.controllers;

import dev.vara.productservice.dtos.GenericProductDto;
import dev.vara.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController
{
private ProductService productservice;
public ProductController(@Qualifier("fakeStoreProductService")ProductService service)
{
    this.productservice=service;
}
    @GetMapping()
    public List<GenericProductDto> getAllProducts()
    {
          return productservice.getAllProducts();
    }

   /* @AutoWired
   public void setProductService(ProductService service)
    {///not Recommenrded

        this.productservice=service;
    }*/
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id)
    {
        return productservice.getProductById(id);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductsById(@PathVariable("id")Long id)
    {
        ResponseEntity<GenericProductDto> response=new ResponseEntity<>(
                productservice.deleteProductById(id),
                HttpStatus.OK
        );

        return response;
    }


    @PostMapping
    public GenericProductDto  CreateProduct(@RequestBody GenericProductDto product)
    {
      // return "Created new  product  with title "+ product.getTitle();
        return  productservice.CreateProduct(product);
    }

    @PutMapping("{id}")
    public void UpdateProductById()
    {

    }
}
