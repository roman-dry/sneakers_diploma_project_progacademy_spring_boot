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
    @Transactional
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public List<Order> getOrderByUserId(Integer user_id) {
        return orderRepository.getOrderByUserId(user_id);
    }
    @Transactional
    public void updateOrderByUserId(Integer user_id, String status) {
        orderRepository.updateOrderByUserId(status, user_id);
    }
}
