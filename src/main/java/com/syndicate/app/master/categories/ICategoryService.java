package com.syndicate.app.master.categories;

import java.util.List;

public interface ICategoryService<T> {

	List<T> findAll(String name, Class<?> T);
	

	Long save(Category c);

}
