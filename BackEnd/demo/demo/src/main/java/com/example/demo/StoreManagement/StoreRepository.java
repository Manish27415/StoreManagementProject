package com.example.demo.StoreManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, String>
{
    @Modifying
    @Transactional
    @Query("UPDATE StoreEntity s SET s.productQuantity = s.productQuantity - :quantity WHERE s.productId = :id AND s.productQuantity >= :quantity")
    int findByProductIdAndProductQuantity(@Param("id") String productId, @Param("quantity") int quantity);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orders (order_id, product_id, order_quantity) VALUES (:orderId, :id, :quantity)", nativeQuery = true)
    int orderId(@Param("id") String id,@Param("quantity") int quantity,@Param("orderId") int orderId);

}
