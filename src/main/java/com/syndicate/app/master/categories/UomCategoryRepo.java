package com.syndicate.app.master.categories;

import com.syndicate.app.master.product.UomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomCategoryRepo extends JpaRepository<UomCategory, Long> {

}
