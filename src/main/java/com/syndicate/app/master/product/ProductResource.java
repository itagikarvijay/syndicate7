package com.syndicate.app.master.product;

import com.syndicate.app.executors.ExecutorClzz;
import com.syndicate.app.utility.CsvReader;
import com.syndicate.app.utility.CsvReaderResponse;
import com.syndicate.app.utility.WrapperClz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/api/v1/product")
public class ProductResource {

	@Autowired
	IProductService iProductService;

	@Autowired
	ExecutorClzz executorsClzz;

	@GetMapping("/greet")
	public String greet(){
		return "Greet";
	}

	@PostMapping("/save")
	public String save(@RequestBody ProductDTO productDTO) {
		return iProductService.save(productDTO);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ProductDTO>> findAll(@RequestParam("storeId") Long storeId) {
		System.out.println("FindAll::Product API");
		Optional<List<ProductDTO>> productList = iProductService.findAll(storeId);
		return new ResponseEntity<List<ProductDTO>>(productList.get(), HttpStatus.OK);
	}

	@GetMapping("/searchProductCount")
	public Long findAll(@RequestParam("search") String search) {
		return iProductService.searchProductCount(search);
	}

	@GetMapping("/findAllWithPagination")
	public ResponseEntity<List<ProductDTO>> findAll(@RequestParam("page") String paramPage,
			@RequestParam("pageSize") String paramPageSize) {
		int page = Integer.valueOf(paramPage);
		int pageSize = Integer.valueOf(paramPageSize);
		Optional<List<ProductDTO>> productList = iProductService.findAll(page, pageSize);
		return new ResponseEntity<List<ProductDTO>>(productList.get(), HttpStatus.OK);
	}

	@GetMapping("/searchAllWithPagination")
	public ResponseEntity<Map<String, Object>> findAll(@RequestParam("search") String search,
			@RequestParam("page") String paramPage, @RequestParam("pageSize") String paramPageSize,
			@RequestParam("totalRecords") String paramTotalRecords) {
		int page = Integer.valueOf(paramPage);
		int pageSize = Integer.valueOf(paramPageSize);
		int totalRecords = Integer.valueOf(paramTotalRecords);
		Map<String, Object> productList = iProductService.findAll(search, page, pageSize, totalRecords);
		return new ResponseEntity<Map<String, Object>>(productList, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product) {
		Optional<ProductDTO> productOPT = iProductService.update(product);
		return new ResponseEntity<ProductDTO>(productOPT.get(), HttpStatus.OK);
	}

	@PutMapping("/update/upload")
	public ResponseEntity<Long> update(@RequestBody WrapperClz list) {
//		System.out.println("productList " +list.getSuccessList().size());
//		System.out.println("productList " +list.getSuccessList());
//		System.out.println("storeId " +list.getStoreId());
		int startTime = LocalTime.now().getMinute();
		System.out.print("Start : " + startTime);
//		iProductService.update(list);

//		ExecutorService executor = Executors.newFixedThreadPool(4);
//		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
//		ExecuteTask et = new ExecuteTask(iProductService);
//		et.setList(list);
//		Future<?> f = pool.submit(et);
//		System.out.println("is terminated " +f.isDone());
//		while (!f.isDone()) {		
//		}
//		int endTime = LocalTime.now().getMinute();
//		executor.shutdown();
		
		System.out.println("Available proc\t"+Runtime.getRuntime().availableProcessors());
		ForkJoinPool p = new ForkJoinPool(); //.commonPool();
		
//		Task t = new Task(list.getSuccessList(),false,iProductService);
//
//		p.execute(t);
//
//		while (!t.isDone()) {}

		p.shutdown();

		if (p.isTerminated()) {
			System.out.println("Completed normaly.!");
		}

		int endTime = LocalTime.now().getMinute();
		System.out.println("end : " + endTime);
		System.out.println("Total Time Taken in minutes : " + (endTime - startTime));
	
		return new ResponseEntity<Long>(100l, HttpStatus.OK);

	}

	@PostMapping("/uploadImage")
	public ResponseEntity<String> updateImage(@RequestParam("file") MultipartFile file, @RequestParam("rowNum") Long rowNum) throws IOException {
		String fileName = file.getOriginalFilename();
		return new ResponseEntity<String>(iProductService.uploadImage(file,rowNum), HttpStatus.OK);
	}

	@PutMapping("/upload")
	public ResponseEntity<CsvReaderResponse> update(@RequestParam("file") MultipartFile file) {
		System.out.println("uploading product file.! " + file.getOriginalFilename());
		try{
			CsvReaderResponse csvReaderResponse = CsvReader.csvToProducts(file.getInputStream());
			return new ResponseEntity<CsvReaderResponse>(csvReaderResponse, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<CsvReaderResponse>(new CsvReaderResponse(), HttpStatus.OK);
	}

	@PutMapping("/update/rate")
	public ResponseEntity<ProductRatesDTO> updateRate(@RequestBody ProductRatesDTO productRateDTO) {
		Optional<ProductRatesDTO> productOPT = iProductService.update(productRateDTO);
		return new ResponseEntity<ProductRatesDTO>(productOPT.get(), HttpStatus.OK);
	}

	@PatchMapping(path = "/delete", consumes = "application/json-patch+json")
	public ResponseEntity<ProductDTO> delete(@RequestBody ProductDTO product) {
		Optional<ProductDTO> productOPT = iProductService.update(product);
		return new ResponseEntity<ProductDTO>(productOPT.get(), HttpStatus.OK);
	}
}
