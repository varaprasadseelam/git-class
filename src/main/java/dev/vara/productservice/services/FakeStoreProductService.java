package dev.vara.productservice.services;

import dev.vara.productservice.dtos.FareStoreProductdto;
import dev.vara.productservice.dtos.GenericProductDto;
import dev.vara.productservice.models.product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

   private  RestTemplateBuilder restTemplateBuilder;
   private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";
   private String CreateProductRequestUrl="https://fakestoreapi.com/products";
   public FakeStoreProductService (RestTemplateBuilder builder)
   {
       this.restTemplateBuilder=builder;
   }
   public GenericProductDto CreateProduct(GenericProductDto product)
   {
       RestTemplate restemplate=restTemplateBuilder.build();
      ResponseEntity<GenericProductDto> response=
              restemplate.postForEntity(CreateProductRequestUrl,product,GenericProductDto.class);

          return response.getBody();
   }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restemplate=restTemplateBuilder.build();
      ResponseEntity<FareStoreProductdto[]> obj= restemplate.getForEntity(CreateProductRequestUrl,FareStoreProductdto[].class);
      List<GenericProductDto> answer =new ArrayList<>();
      for(FareStoreProductdto dto : Arrays.stream(obj.getBody()).toList())
        {
            GenericProductDto product=new GenericProductDto();
            product.setImage(dto.getImage());;
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setCategory(dto.getCategory());
            answer.add(product);
        }
      return  answer;
    }
    public GenericProductDto ConvertfromFaketoGeneric(FareStoreProductdto dto )
    {

        GenericProductDto product=new GenericProductDto();
        product.setId(dto.getId());
        product.setImage(dto.getImage());;
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        return product;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate =restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FareStoreProductdto.class);
        ResponseExtractor<ResponseEntity<FareStoreProductdto>> responseExtractor = restTemplate.responseEntityExtractor(FareStoreProductdto.class);
        ResponseEntity<FareStoreProductdto> response= restTemplate.execute(getProductRequestUrl, HttpMethod.GET, requestCallback, responseExtractor, id);
        return ConvertfromFaketoGeneric(response.getBody());

   }

    @Override
    public GenericProductDto  getProductById(Long id) {
        RestTemplate resttemplate =restTemplateBuilder.build();
        ResponseEntity<FareStoreProductdto> response=
                resttemplate.getForEntity(getProductRequestUrl, FareStoreProductdto.class,id);
        FareStoreProductdto dto= response.getBody();
        GenericProductDto product=new GenericProductDto();
        product.setImage(dto.getImage());;
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        return product;

    }
}
