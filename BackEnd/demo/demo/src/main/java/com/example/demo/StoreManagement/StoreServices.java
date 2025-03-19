package com.example.demo.StoreManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServices
{
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private OrderRepo orderRepo;

    public List<StoreEntity> getAllProductDetails()
    {
        return storeRepository.findAll();
    }

    public int findById(String id, int quantity)
    {
        return storeRepository.findByProductIdAndProductQuantity(id,quantity);
    }

    public int orderId(String id, int quantity, int orderId)
    {
        return storeRepository.orderId(id,quantity,orderId);
    }

    public StoreEntity newProduct(StoreEntity store)
    {
        return storeRepository.save(store);
    }

    public void deleteProduct(String id)
    {
        storeRepository.deleteById(id);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }
}
