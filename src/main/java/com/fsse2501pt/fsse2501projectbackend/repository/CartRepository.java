package com.fsse2501pt.fsse2501projectbackend.repository;

import com.fsse2501pt.fsse2501projectbackend.data.cart.entity.CartEntity;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
    // a list only for collecting cartItems with attributes user and product
    Optional<CartEntity> findByUserAndProduct(UserEntity user, ProductEntity product);

    List<CartEntity> findByUser(UserEntity user);


}

