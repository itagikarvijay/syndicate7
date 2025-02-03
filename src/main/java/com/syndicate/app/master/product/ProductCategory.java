package com.syndicate.app.master.product;

import com.syndicate.app.master.categories.Category;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue("PRODUCT_CATEGORY")
public class ProductCategory extends Category implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

}
