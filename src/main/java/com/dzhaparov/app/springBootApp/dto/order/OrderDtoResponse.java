package com.dzhaparov.app.springBootApp.dto.order;

import com.dzhaparov.app.springBootApp.dto.product.ProductDtoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderDtoResponse(Long id,
                               Date creationDate,
                               Double totalCost,
                               List<ProductDtoResponse> products) {
}