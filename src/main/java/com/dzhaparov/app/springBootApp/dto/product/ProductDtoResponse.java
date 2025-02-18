package com.dzhaparov.app.springBootApp.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDtoResponse(Long id,
                                 String name,
                                 Double cost) {
}