package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.Shipping;
import com.example.reactsneakersfinalproject.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ShippingController {
    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping("/shippings")
    public Shipping create(@RequestBody Shipping shipping) {

        return shippingService.save(shipping);
    }

    @GetMapping("/shippings/{user_id}")
    public List<Shipping> getShippingsByUserId(@PathVariable("user_id") Integer user_id) {
        return shippingService.getShippingByUserId(user_id);
    }
    @DeleteMapping("/shippings/{id}")
    public void deleteShippingById(@PathVariable("id") Integer id) {
        shippingService.deleteShippingById(id);
    }
}
