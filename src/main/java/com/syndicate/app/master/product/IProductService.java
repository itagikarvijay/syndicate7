package com.syndicate.app.master.product;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductService {
	
	String save(ProductDTO product);
	
	Optional<List<ProductDTO>> findAll(Long storeId);
	Map<String,Object> findAll(String search,int pageNo, int pageSize, int totalRecords);
	Optional<List<ProductDTO>> findAll(int pageNo, int pageSize);
	
	Optional<ProductDTO> update(ProductDTO product);
	Long update(UploadProductDTO list);
	
	Optional<ProductRatesDTO> update(ProductRatesDTO productRate);
	Long searchProductCount(String search);

	String uploadImage(MultipartFile file, Long rowNum) throws IOException;
}
