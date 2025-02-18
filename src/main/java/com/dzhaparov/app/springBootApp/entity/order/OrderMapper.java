package com.dzhaparov.app.springBootApp.entity.order;

import com.dzhaparov.app.springBootApp.dto.order.OrderDtoRequest;

import com.dzhaparov.app.springBootApp.dto.order.OrderDtoResponse;
import com.dzhaparov.app.springBootApp.dto.product.ProductDtoRequest;

import com.dzhaparov.app.springBootApp.dto.product.ProductDtoResponse;
import com.dzhaparov.app.springBootApp.entity.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order dtoToEntity(OrderDtoRequest request) {
        Order order = new Order();
        order.setCreationDate(request.creationDate());
        order.setTotalCost(request.totalCost());

        if (request.products() != null) {
            List<Product> products = request.products().stream()
                    .map(this::productDtoToEntity)
                    .peek(product -> product.setOrder(order))
                    .collect(Collectors.toList());
            order.setProducts(products);
        }

        return order;
    }

    public Order updateEntityFromDto(Order order, OrderDtoRequest request) {
        if (request.creationDate() != null) {
            order.setCreationDate(request.creationDate());
        }
        if (request.totalCost() != null) {
            order.setTotalCost(request.totalCost());
        }
        if (request.products() != null) {
            List<Product> products = request.products().stream()
                    .map(this::productDtoToEntity)
                    .peek(product -> product.setOrder(order))
                    .collect(Collectors.toList());
            order.setProducts(products);
        }
        return order;
    }

    public OrderDtoResponse entityToDto(Order order) {
        return new OrderDtoResponse(
                order.getId(),
                order.getCreationDate(),
                order.getTotalCost(),
                order.getProducts() != null ? order.getProducts().stream()
                        .map(this::productEntityToDto)
                        .collect(Collectors.toList()) : List.of()
        );
    }

    private Product productDtoToEntity(ProductDtoRequest dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setCost(dto.cost());
        return product;
    }

    private ProductDtoResponse productEntityToDto(Product product) {
        return new ProductDtoResponse(
                product.getId(),
                product.getName(),
                product.getCost()
        );
    }
}
