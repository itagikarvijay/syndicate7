package com.syndicate.app.master.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoryType")
public class CategoryResource {

	@Autowired
	ICategoryService<CategoryDTO> categoryService;

	@RequestMapping("/party")
	public List<CategoryDTO> partyType(@RequestParam("category") String category) {
		return categoryService.findAll(category, CategoryDTO.class);
	}

	@RequestMapping("/product")
	public ResponseEntity<List<CategoryDTO>> productCategory(@RequestParam("category") String category) {
		return new ResponseEntity<>(categoryService.findAll(category, CategoryDTO.class), HttpStatus.OK);
	}

	@RequestMapping("/uom")
	public ResponseEntity<List<CategoryDTO>> uomCategory(@RequestParam("category") String category) {
		return new ResponseEntity<>(categoryService.findAll(category, CategoryDTO.class), HttpStatus.OK);
	}
	
	@RequestMapping("/department")
	public ResponseEntity<List<CategoryDTO>> departmentTypes(@RequestParam("category") String category) {
		return new ResponseEntity<>(categoryService.findAll(category, CategoryDTO.class), HttpStatus.OK);
	}

}
