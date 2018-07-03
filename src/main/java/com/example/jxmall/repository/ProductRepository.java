package com.example.jxmall.repository;

import com.example.jxmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDescriptionContains(String name, String description);

}
