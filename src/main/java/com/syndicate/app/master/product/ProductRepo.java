package com.syndicate.app.master.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("FROM com.syndicate.app.master.product.Product p WHERE p.product LIKE %:search% ")
	Optional<List<Product>> findAll(String search);

	Optional<Product> findByProduct(String name);
}
