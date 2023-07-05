package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.Order;
import com.example.reactsneakersfinalproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/orders/{user_id}")
    public List<Order> getOrdersByUserId(@PathVariable("user_id") int user_id) {
        return orderService.getOrderByUserId(user_id);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable("id") int id) {
        orderService.deleteOrderById(id);
    }
    @PatchMapping("/orders")
    public void updateOrderByUserId(@RequestParam int user_id,
                                    @RequestParam String status) {
        orderService.updateOrderByUserId(user_id, status);
    }
}