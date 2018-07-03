package com.example.jxmall.repository;

import com.example.jxmall.entity.Order_Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order_Items, Integer> {

    List<Order_Items> findByUserId(int userId);
}

