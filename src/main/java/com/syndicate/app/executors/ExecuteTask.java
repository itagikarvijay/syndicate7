package com.syndicate.app.executors;

import com.syndicate.app.master.product.IProductService;
import com.syndicate.app.utility.WrapperClz;
import org.springframework.stereotype.Component;

@Component
public class ExecuteTask implements Runnable {

//	@Autowired
	IProductService iProductService;

	public ExecuteTask(IProductService iProductService) {
		this.iProductService = iProductService;
	}
	
	WrapperClz list;

	public WrapperClz getList() {
		return list;
	}

	public void setList(WrapperClz list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
//			iProductService.update(list);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" From ExecuteTask ");
		}
	}

}
