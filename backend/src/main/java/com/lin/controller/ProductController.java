package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.dto.ApiResult;
import com.lin.dto.ProductAddDto;
import com.lin.dto.ProductDeleteDto;
import com.lin.dto.ProductQueryDto;
import com.lin.dto.ProductUpdateDto;
import com.lin.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ApiResult addProduct(@RequestBody ProductAddDto dto) {
		productService.addProduct(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updateProduct(@RequestBody ProductUpdateDto dto) {
		productService.updateProduct(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deleteProduct(@RequestBody ProductDeleteDto dto) {
		productService.deleteProduct(dto);
		return ApiResult.ok();
	}

	@GetMapping
	public ApiResult queryProduct(ProductQueryDto dto) {
		if (StringUtils.hasText(dto.getId())) {
			return ApiResult.ok(productService.findProduct(dto));
		}
		return ApiResult.ok(productService.findProducts(dto));
	}

}
