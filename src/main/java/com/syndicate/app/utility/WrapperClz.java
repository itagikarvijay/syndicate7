package com.syndicate.app.utility;

import com.syndicate.app.master.product.UploadProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class WrapperClz {
	private Long storeId;
	private List<UploadProductDTO> successList;
}
