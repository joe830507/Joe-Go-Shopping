package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.ProductAddDto;
import com.lin.dto.ProductDeleteDto;
import com.lin.dto.ProductQueryDto;
import com.lin.dto.ProductUpdateDto;
import com.lin.entity.Product;
import com.lin.repository.ProductRepository;
import com.lin.service.ProductService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addProduct(ProductAddDto dto) {
		Product product = modelMapper.map(dto, Product.class);
		product.setId(UUIDUtil.getIdWithoutDashes());
		product.setCreateTime(new Date());
		productRepository.insert(product);
	}

	@Override
	public void updateProduct(ProductUpdateDto dto) {
		Product origin = productRepository.findById(dto.getId()).get();
		Product updateOne = modelMapper.map(dto, Product.class);
		BeanUtil.copyPropertiesWithoutNull(updateOne, origin);
		origin.setUpdateTime(new Date());
		productRepository.save(origin);
	}

	@Override
	public void deleteProduct(ProductDeleteDto dto) {
		productRepository.deleteById(dto.getId());
	}

	@Override
	public Product findProduct(ProductQueryDto dto) {
		return productRepository.findById(dto.getId()).get();
	}

	@Override
	public Page<Product> findProducts(ProductQueryDto dto) {
		PageRequest request = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return productRepository.findAll(request);
	}

}
