package com.syndicate.app.master.product;

import com.syndicate.app.master.categories.Category;
import com.syndicate.app.master.voucher.ProductStock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	@Column(name = "product_name", nullable = false, unique = true)
	private String product;
	@Column(name = "prod_category_id")
	private Long categoryType;
	@Column(name = "HSNCode")
	private String hsnCode;
	@Column(name = "service", nullable = false)
	private Boolean service;
//	@Column(name = "gst_percent", nullable = false)
//	private float gstPercentage;
//	@Column(name = "cgst_percent", nullable = false)
//	private float cgstPercentage;
//	@Column(name = "sgst_percent", nullable = false)
//	private float sgstPercentage;
	@Column(name = "inactive", nullable = false)
	private Boolean inactive;
	@Column(name = "isDeleted")
	private Boolean isDeleted;
	@Column(name = "uom")
	private Long uom;
	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private String image;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
//	@JoinColumn(name = "product_id",  referencedColumnName = "product_id")
	private List<ProductRates> productRates;

	@OneToOne
	@JoinColumn(name = "prod_category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Category productCategory;

	@OneToOne
	@JoinColumn(name = "uom", referencedColumnName = "id", insertable = false, updatable = false)
	private Category uomCategory;

//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private List<ProductStock> productStock;
}
