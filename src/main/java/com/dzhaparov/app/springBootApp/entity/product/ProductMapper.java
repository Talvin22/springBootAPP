package com.dzhaparov.app.springBootApp.entity.product;

import com.dzhaparov.app.springBootApp.dto.product.ProductDtoRequest;
import com.dzhaparov.app.springBootApp.dto.product.ProductDtoResponse;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product dtoToEntity(ProductDtoRequest dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setCost(dto.cost());
        return product;
    }

    public ProductDtoResponse entityToDto(Product product) {
        return new ProductDtoResponse(
                product.getId(),
                product.getName(),
                product.getCost()
        );
    }
}