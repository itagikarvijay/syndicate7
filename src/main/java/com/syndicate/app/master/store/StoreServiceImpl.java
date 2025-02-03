package com.syndicate.app.master.store;

import com.syndicate.app.utility.ConvertToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	StoreRepo storeRepo;
	
	@Autowired
	ConvertToDto convertToDto;
	
	@Override
	public List<StoreDTO> getAllStore() {
		return convertToDto.mapList(storeRepo.findAll(), StoreDTO.class);
	}

}
