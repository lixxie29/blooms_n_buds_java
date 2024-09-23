package com.lix.java_flower_app.rest.repo;

import com.lix.java_flower_app.rest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
