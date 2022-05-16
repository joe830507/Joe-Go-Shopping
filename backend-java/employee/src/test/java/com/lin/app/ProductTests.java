package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.lin.controller.ProductController;
import com.lin.dto.ApiResult;
import com.lin.dto.ApiResult.ApiResultCode;
import com.lin.dto.ProductAddDto;
import com.lin.dto.ProductDeleteDto;
import com.lin.dto.ProductQueryDto;
import com.lin.dto.ProductUpdateDto;
import com.lin.entity.Product;
import com.lin.mongo.repository.ProductRepository;

@SpringBootTest
public class ProductTests {

	@Autowired
	ProductController productController;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ModelMapper modelMapper;

	@Test
	void addProduct() {
		ProductAddDto addDto = new ProductAddDto();
		addDto.setName("Cap");
		addDto.setNumber(10f);
		addDto.setImportPirce(10f);
		addDto.setSalesPrice(20f);
		ApiResult result = productController.addProduct(addDto);
		assertEquals(ApiResultCode.SUCCESS, result.getCode());
		productRepository.deleteAll();
	}

	@Test
	void updateProduct() {
		ProductAddDto addDto = new ProductAddDto();
		addDto.setName("Cap");
		addDto.setNumber(10f);
		addDto.setImportPirce(10f);
		addDto.setSalesPrice(20f);
		productController.addProduct(addDto);
		Product product = productRepository.findAll().get(0);
		ProductUpdateDto updateDto = modelMapper.map(product, ProductUpdateDto.class);
		updateDto.setSalesPrice(25f);
		productController.updateProduct(updateDto);
		product = productRepository.findAll().get(0);
		assertEquals(25f, product.getSalesPrice());
		productRepository.deleteAll();
	}

	@Test
	void deleteProduct() {
		ProductAddDto addDto = new ProductAddDto();
		addDto.setName("Cap");
		addDto.setNumber(10f);
		addDto.setImportPirce(10f);
		addDto.setSalesPrice(20f);
		productController.addProduct(addDto);
		Product product = productRepository.findAll().get(0);
		ProductDeleteDto deleteDto = modelMapper.map(product, ProductDeleteDto.class);
		productController.deleteProduct(deleteDto);
		Boolean isPresent = productRepository.findById(product.getId()).isPresent();
		assertFalse(isPresent);
	}

	@Test
	void queryProducts() {
		addProducts();
		ProductQueryDto queryDto = new ProductQueryDto();
		ApiResult result = productController.queryProduct(queryDto);
		@SuppressWarnings("unchecked")
		Page<Product> productPage = (Page<Product>) result.getResponseBody();
		assertEquals(2, productPage.getContent().size());
		queryDto.setId(productPage.getContent().get(0).getId());
		result = productController.queryProduct(queryDto);
		Product product = (Product) result.getResponseBody();
		assertNotNull(product);
		productRepository.deleteAll();
	}

	private void addProducts() {
		ProductAddDto addDto = new ProductAddDto();
		addDto.setName("Cap");
		addDto.setNumber(10f);
		addDto.setImportPirce(10f);
		addDto.setSalesPrice(20f);
		productController.addProduct(addDto);
		addDto = new ProductAddDto();
		addDto.setName("T-shirt");
		addDto.setNumber(20f);
		addDto.setImportPirce(30f);
		addDto.setSalesPrice(50f);
		productController.addProduct(addDto);
	}
}
