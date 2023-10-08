package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Order;
import com.example.reactsneakersfinalproject.repositories.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrderByUserId(int user_id) {
        return orderRepository.getOrderByUserId(user_id);
    }
    @Transactional
    public void updateOrderByUserId(int user_id, String status) {
        orderRepository.updateOrderByUserId(status, user_id);
    }
}
