package com.syndicate.app.master.product;

import com.syndicate.app.master.categories.Category;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue("UOM_CATEGORY")
public class UomCategory extends Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
