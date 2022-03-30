package com.lin.service;

import org.springframework.data.domain.Page;

import com.lin.dto.ProductAddDto;
import com.lin.dto.ProductDeleteDto;
import com.lin.dto.ProductQueryDto;
import com.lin.dto.ProductUpdateDto;
import com.lin.entity.Product;

public interface ProductService {
	void addProduct(ProductAddDto dto);

	void updateProduct(ProductUpdateDto dto);

	void deleteProduct(ProductDeleteDto dto);

	Product findProduct(ProductQueryDto dto);

	Page<Product> findProducts(ProductQueryDto dto);
}
