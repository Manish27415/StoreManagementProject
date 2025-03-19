package com.example.demo.StoreManagement;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.Origin;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class StoreController
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;

    @Autowired
    private StoreServices storeServices;

    @GetMapping("/getAllProductDetails")
    public List<StoreEntity> getAllProducts()
    {
        return storeServices.getAllProductDetails();
    }

    @GetMapping("/getDetailsById/{id}/{quantity}")
    public int getDetailsById(@PathVariable String id, @PathVariable int quantity)
    {

        if(storeServices.findById(id,quantity)==0)
        {
            System.out.println("product out of stock");
            System.out.println("Please refill and enter the required quantity");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            storeServices.orderId(id, n, orderId);
        }
       return storeServices.findById(id,quantity);
    }

    @PostMapping("/addNewProduct")
    public StoreEntity addNewProduct(@RequestBody StoreEntity store)
    {
        return storeServices.newProduct(store);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public void deleteProduct(@PathVariable String id)
    {
        storeServices.deleteProduct(id);
    }

    @GetMapping("/getAllOrders")
    public List<OrderEntity> getAllOrders(){
        return storeServices.getAllOrders();
    }
}
