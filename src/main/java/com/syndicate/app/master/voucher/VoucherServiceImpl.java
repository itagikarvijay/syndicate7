package com.syndicate.app.master.voucher;

import com.syndicate.app.master.product.ProductRepo;
import com.syndicate.app.utility.ConvertToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class VoucherServiceImpl implements IVoucherService {

	@Autowired
	VoucherRepo voucherRepo;

	@Autowired
	VoucherDetailsRepo voucherDetailsRepo;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ProductStockRepo productStockRepo;

	@Autowired
	ConvertToEntity convertToEntity;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long sale(VoucherDTO voucherDTO) {
		List<ProductStock> lst = new ArrayList<ProductStock>();
		Voucher v = convertToEntity.map(voucherDTO, Voucher.class);
		Stream<VoucherDetails> s = v.getVoucherDetails().stream();
		s.forEach(element -> {
			Long productId = element.getProductId();
			Float ob = getOb(productId);
			if (ob == null || ob == 0) {
				ob = 0 - element.getOutQty();
			} else if (ob < 0) {
				String strValue = "-" + element.getOutQty().floatValue();
				ob = ob + Float.parseFloat(strValue);
			} else if (ob > 0) {
				ob = ob - element.getOutQty();
			} else {
				ob = 0f;
			}
			element.setCbQty(ob);
			ProductStock ps = getProductStock(productId, element.getStoreId());
			ps.setProductId(productId);
			ps.setStoreId(element.getStoreId());
			ps.setCloStock(ob);
			lst.add(ps);
			element.setVoucher(v);
		});
		Voucher voucher = voucherRepo.save(v);
		productStockRepo.saveAll(lst);
		return voucher.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long purchase(VoucherDTO voucherDTO) {
		List<ProductStock> lst = new ArrayList<ProductStock>();
		Voucher v = convertToEntity.map(voucherDTO, Voucher.class);
		Stream<VoucherDetails> s = v.getVoucherDetails().stream();
		s.forEach(element -> {
			Long productId = element.getProductId();
			Float ob = getOb(productId);
			if (ob == null || ob == 0) {
				ob = 0 + element.getOutQty();
			} else if (ob < 0) {
				ob = ob + element.getOutQty().floatValue();
			} else if (ob > 0) {
				ob = ob + element.getOutQty();
			} else {
				ob = 0f;
			}
			element.setCbQty(ob);
			ProductStock ps = getProductStock(productId, element.getStoreId());
			ps.setProductId(productId);
			ps.setStoreId(element.getStoreId());
			ps.setCloStock(ob);
			lst.add(ps);
			element.setVoucher(v);
		});
		Voucher voucher = voucherRepo.save(v);
		productStockRepo.saveAll(lst);
		return voucher.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long transfer(VoucherDTO voucherDTO) {
		List<ProductStock> lst = new ArrayList<ProductStock>();
		Voucher v = convertToEntity.map(voucherDTO, Voucher.class);
		Stream<VoucherDetails> s = v.getVoucherDetails().stream();
		s.forEach(element -> {
			Long productId = element.getProductId();
			Float ob = getOb(productId);
			if (ob == null || ob == 0) {
				ob = 0 - element.getOutQty();
			} else if (ob < 0) {
				String strValue = "-" + element.getOutQty().floatValue();
				ob = ob + Float.parseFloat(strValue);
			} else if (ob > 0) {
				ob = ob - element.getOutQty();
			} else {
				ob = 0f;
			}
			element.setCbQty(ob);
			ProductStock ps = getProductStock(productId, element.getStoreId());
			ps.setProductId(productId);
			ps.setStoreId(element.getStoreId());
			ps.setCloStock(ob);
			lst.add(ps);
			element.setVoucher(v);
		});
		Voucher voucher = voucherRepo.save(v);
		productStockRepo.saveAll(lst);
		return voucher.getId();
	}

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public Long salesReturn(VoucherDTO voucherDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long purchaseReturn(VoucherDTO voucherDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public Long issues(VoucherDTO voucherDTO) {
		List<ProductStock> lst = new ArrayList<ProductStock>();
		Voucher v = convertToEntity.map(voucherDTO, Voucher.class);
		Stream<VoucherDetails> s = v.getVoucherDetails().stream();
		s.forEach(element -> {
			Long productId = element.getProductId();
			Float ob = getOb(productId);
			if (ob == null || ob == 0) {
				ob = 0 - element.getOutQty();
			} else if (ob < 0) {
				String strValue = "-" + element.getOutQty().floatValue();
				ob = ob + Float.parseFloat(strValue);
			} else if (ob > 0) {
				ob = ob - element.getOutQty();
			} else {
				ob = 0f;
			}
			element.setCbQty(ob);
			ProductStock ps = getProductStock(productId, element.getStoreId());
			ps.setProductId(productId);
			ps.setStoreId(element.getStoreId());
			ps.setCloStock(ob);
			lst.add(ps);
			element.setVoucher(v);
		});
		Voucher voucher = voucherRepo.save(v);
		productStockRepo.saveAll(lst);
		return voucher.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long scrap(VoucherDTO voucherDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	private ProductStock getProductStock(Long productId, Long storeId) {
		ProductStock p = productStockRepo.findByProductIdAndStoreId(productId, storeId); // productRepo.findById(productId).get();
		return p == null ? new ProductStock() : p;
	}

	private Float getOb(Long productId) {
		return voucherDetailsRepo.getOb(productId);
	}

}
