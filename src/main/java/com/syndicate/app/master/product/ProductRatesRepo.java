package com.syndicate.app.master.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRatesRepo extends JpaRepository<ProductRates,Long> {
	
	Optional<List<ProductRates>> findAllByProductIdAndStoreIdOrderByWefDesc(Long productId, Long storeId);

}
