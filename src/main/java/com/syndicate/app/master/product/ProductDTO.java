package com.syndicate.app.master.product;


import com.syndicate.app.BaseDTO;
import com.syndicate.app.master.categories.CategoryDTO;
import com.syndicate.app.master.voucher.ProductStock;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDTO extends BaseDTO {

	private Long id;
	private String product;
	private Long categoryType;
	private String hsnCode;
	private Boolean service;
	private float stock;
	private float gstPercentage;
	private float cgstPercentage;
	private float sgstPercentage;
	private float rate;
	private Boolean inactive;
	private Boolean isDeleted;
	private Long uom;
	private String image;
	private CategoryDTO productCategory;
	private CategoryDTO uomCategory;
	private List<ProductRatesDTO> productRates;
	private List<ProductStock> productStock;
//	private String strUom;
//	private String category;

//	public ProductDTO(String name, String strUom, String category, String hsnCode, float stock, float rate,
//			float gstPercentage, float cgstPercentage, float sgstPercentage) {
//		this.name = name;
//		this.strUom = strUom;
//		this.category = category;
//		this.hsnCode = hsnCode;
//		this.stock = stock;
//		this.rate = rate;
//		this.gstPercentage = gstPercentage;
//		this.cgstPercentage = cgstPercentage;
//		this.sgstPercentage = sgstPercentage;
//	}
//
//	public ProductDTO(String name, String strUom, String category, String hsnCode, String strStock, String strRate,
//			String strGstPercentage, String cgstPercentage, String sgstPercentage) {
//
//	}

}
