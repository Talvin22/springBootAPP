package com.dzhaparov.app.springBootApp.repository;

import com.dzhaparov.app.springBootApp.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
