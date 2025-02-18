package com.dzhaparov.app.springBootApp.dto.order;


import com.dzhaparov.app.springBootApp.dto.product.ProductDtoRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderDtoRequest(Long id,
                              Date creationDate,
                              Double totalCost,
                              List<ProductDtoRequest> products) {
}
