package com.syndicate.app.master.voucher;

import com.syndicate.app.master.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "voucher")
@NoArgsConstructor
@Entity
@Table(name = "voucher_details")
public class VoucherDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voucher_details_id")
	private Long id;
//	@Column(name = "voucher_id")
//	private Long voucherId;
	@Column(name = "store_id")
	private Long storeId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "hsncode")
	private String hsnCode;
	@Column(name = "gst_percent")
	private Float gstPercent;
	@Column(name = "rate")
	private Float rate;
	@Column(name = "in_qty")
	private Float inQty;
	@Column(name = "out_qty")
	private Float outQty;
	@Column(name = "netamount")
	private Float netAmount;
	@Column(name = "taxable_amount")
	private Float taxableAmount;
	@Column(name = "cgst_percent")
	private Float cgstPercent;
	@Column(name = "cgst_amount")
	private Float cgstAmount;
	@Column(name = "sgst_percent")
	private Float sgstPercent;
	@Column(name = "sgst_amount")
	private Float sgstAmount;
	@Column(name = "igst_percent")
	private Float igstPercent;
	@Column(name = "igst_amount")
	private Float igstAmount;
	@Column(name = "cb_qty")
	private Float cbQty;

	@ManyToOne
	@JoinColumn(name = "voucher_id",nullable = false)
	private Voucher voucher;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private Product product;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "product_stock", joinColumns =
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "product_id"),
	inverseJoinColumns = @JoinColumn(name = "STORE_ID", referencedColumnName = "ID"))
	private List<ProductStock> store;

}
