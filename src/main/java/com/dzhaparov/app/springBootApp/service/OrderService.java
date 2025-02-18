package com.dzhaparov.app.springBootApp.service;

import com.dzhaparov.app.springBootApp.dto.order.OrderDtoRequest;
import com.dzhaparov.app.springBootApp.dto.order.OrderDtoResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService extends BaseService<OrderDtoResponse, OrderDtoRequest> {

    boolean create(OrderDtoRequest req);

    Optional<OrderDtoResponse> getById(Long id);

    List<OrderDtoResponse> fetchAll();

    void delete(Long id);

    Optional<OrderDtoResponse> update(Long id, OrderDtoRequest req);

}
