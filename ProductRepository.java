package com.example.billing.repository;
import com.example.billing.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query(value = "{}", fields = "{'category': 1}")
    List<Product> findAllCategories();

    List<Product> findByCategory(String category);

}
