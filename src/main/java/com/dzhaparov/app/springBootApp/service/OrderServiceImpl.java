package com.dzhaparov.app.springBootApp.service;

import com.dzhaparov.app.springBootApp.dto.order.OrderDtoRequest;
import com.dzhaparov.app.springBootApp.dto.order.OrderDtoResponse;
import com.dzhaparov.app.springBootApp.entity.order.Order;
import com.dzhaparov.app.springBootApp.entity.order.OrderMapper;
import com.dzhaparov.app.springBootApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean create(OrderDtoRequest req) {
        Order order = orderMapper.dtoToEntity(req);
        orderRepository.save(order);
        return true;
    }

    @Override
    public Optional<OrderDtoResponse> getById(Long id) {
        return orderRepository.findById(id)
                .map(order -> orderMapper.entityToDto(order));
    }

    @Override
    public List<OrderDtoResponse> fetchAll() {
        return orderRepository.findAll()
                .stream().map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");

        }
        orderRepository.deleteById(id);

    }

    @Override
    public Optional<OrderDtoResponse> update(Long id, OrderDtoRequest req) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    Order updatedOrder = orderMapper.updateEntityFromDto(existingOrder, req);
                    orderRepository.save(updatedOrder);
                    return orderMapper.entityToDto(updatedOrder);
                });
    }
}
