package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Shipping;
import com.example.reactsneakersfinalproject.repositories.ShippingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ShippingService {
    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public List<Shipping> getShippingByUserId(int user_id) {
        return shippingRepository.getShippingsByUserId(user_id);
    }
    public void deleteShippingById(int id) {
        shippingRepository.deleteById(id);
    }
}
