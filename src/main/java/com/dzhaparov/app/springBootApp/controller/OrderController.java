package com.dzhaparov.app.springBootApp.controller;

import com.dzhaparov.app.springBootApp.dto.order.OrderDtoRequest;
import com.dzhaparov.app.springBootApp.dto.order.OrderDtoResponse;
import com.dzhaparov.app.springBootApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDtoRequest request) {
        boolean created = orderService.create(request);
        return created ? ResponseEntity.ok("Order created successfully") :
                ResponseEntity.badRequest().body("Failed to create order");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDtoResponse> getOrderById(@PathVariable Long id) {
        Optional<OrderDtoResponse> order = orderService.getById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderDtoResponse>> getAllOrders() {
        List<OrderDtoResponse> orders = orderService.fetchAll();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDtoResponse> updateOrder(@PathVariable Long id, @RequestBody OrderDtoRequest request) {
        Optional<OrderDtoResponse> updatedOrder = orderService.update(id, request);
        return updatedOrder.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
