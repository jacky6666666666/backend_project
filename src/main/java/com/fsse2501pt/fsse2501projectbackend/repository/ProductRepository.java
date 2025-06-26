package com.fsse2501pt.fsse2501projectbackend.repository;

import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <ProductEntity, Integer> {
    //ProductEntity findById(Integer pid);

}
