package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import com.fsse2501pt.fsse2501projectbackend.exception.product.ProductNotFoundException;
import com.fsse2501pt.fsse2501projectbackend.repository.ProductRepository;
import com.fsse2501pt.fsse2501projectbackend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;  // ready call the data in DB for below method

    public ProductServiceImpl(ProductRepository productrepository){
        this.productRepository = productrepository;
    }

    @Override
    public List <ProductResponseData> getAllProduct() {

        List<ProductResponseData> responseDataList = new ArrayList<>();

        for(ProductEntity entity: productRepository.findAll()){
            responseDataList.add(new ProductResponseData(entity));
        }
        return responseDataList;

    }

    @Override
    public ProductResponseData getProductByPid(Integer pid) {
        try{
            return new ProductResponseData(getEntityByPid(pid));

        }catch (Exception e){
            log.warn("Product get by pid failed: " + e.getMessage());
            throw e;
        }
    }



    public ProductEntity getEntityByPid(Integer pid){
        return productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid));
    }


}
