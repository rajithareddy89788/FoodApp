package com.mouritech.onlinefoodorderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.OrderItem;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {

}
