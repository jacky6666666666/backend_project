package com.fsse2501pt.fsse2501projectbackend.service;

import com.fsse2501pt.fsse2501projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    public List<ProductResponseData> getAllProduct();
    public ProductResponseData getProductByPid(Integer pid);
    public ProductEntity getEntityByPid(Integer pid);
}
