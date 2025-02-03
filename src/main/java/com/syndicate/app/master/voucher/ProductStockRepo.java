package com.syndicate.app.master.voucher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepo extends JpaRepository<ProductStock, Long> {

	ProductStock findByProductIdAndStoreId(Long prodId,Long storeId);
}
