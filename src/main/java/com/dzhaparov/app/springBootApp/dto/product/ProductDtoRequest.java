package com.dzhaparov.app.springBootApp.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDtoRequest(Long id,
                               String name,
                               Double cost) {
}
