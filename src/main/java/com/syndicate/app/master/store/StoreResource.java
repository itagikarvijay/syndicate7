package com.syndicate.app.master.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreResource {

	@Autowired
	IStoreService storeService;

	@GetMapping("/findAll")
	public ResponseEntity<List<StoreDTO>> findAll() {
		return new ResponseEntity<List<StoreDTO>>(storeService.getAllStore(), HttpStatus.OK);
	}
}
