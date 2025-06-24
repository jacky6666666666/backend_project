package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.cart.domainObject.response.CartResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.cart.entity.CartEntity;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.exception.product.ProductNotFoundException;
import com.fsse2501pt.fsse2501projectbackend.repository.CartRepository;
import com.fsse2501pt.fsse2501projectbackend.service.CartService;
import com.fsse2501pt.fsse2501projectbackend.service.ProductService;
import com.fsse2501pt.fsse2501projectbackend.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final UserService userService;
    private final CartRepository cartRepository;
    private final ProductService productService;


    // this constructor is for DI
    public CartServiceImpl(UserService userService, ProductService productService, CartRepository cartRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartRepository = cartRepository;
    }

    @Override
    public void putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getEntityByPid(pid);
        Optional<CartEntity> existingCartItem = cartRepository.findByUserAndProduct(userEntity, productEntity);
        CartEntity cartEntity;

        // check if the product already exist in the cart, if yes, then add up the number
        if(existingCartItem.isPresent()) {
            cartEntity = existingCartItem.get();
            cartEntity.setQuantity(cartEntity.getQuantity() + quantity);
        }


        // if no, then put a new product to the cart with the input quantity
        else{
            cartEntity = new CartEntity(productEntity, userEntity, quantity);
            cartEntity.setQuantity(quantity);
        }

        cartRepository.save(cartEntity);
    }

    @Override
    public List<CartResponseData> getCartItemList(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartResponseData> cartResponseDataList = new ArrayList<>();

        for (CartEntity cartEntity : cartRepository.findByUser(userEntity)) {
            cartResponseDataList.add(new CartResponseData(cartEntity));
        }

        return cartResponseDataList;
    }

    @Override
    public CartResponseData updateCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getEntityByPid(pid);
        //List<CartResponseData> cartResponseDataList = new ArrayList<>();

        if (cartRepository.findByUserAndProduct(userEntity, productEntity).isPresent()) {
            CartEntity existingItem = cartRepository.findByUserAndProduct(userEntity, productEntity).get();
            existingItem.setQuantity(quantity);
            cartRepository.save(existingItem);
            return new CartResponseData(existingItem);
        }
        else{
            throw new ProductNotFoundException(pid);
        }

    }

    @Override
    public void deleteCartItem(FirebaseUserData firebaseUserData, Integer pid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getEntityByPid(pid);
        Optional<CartEntity> existingItem = cartRepository.findByUserAndProduct(userEntity, productEntity);

        CartEntity cartEntity;
        if (existingItem.isPresent()) {
            cartEntity = existingItem.get();
            cartRepository.delete(cartEntity);

        }

        else{
            throw new ProductNotFoundException(pid);
        }
    }

    @Override
    public List<CartEntity> getCartItemListByUserEntity(UserEntity userEntity){
        return cartRepository.findByUser(userEntity);
    }

    // this process could need roll back, so need to add @Transactional
    @Transactional
    @Override
    public void emptyCart(UserEntity userEntity){
        cartRepository.deleteAllByUser(userEntity);
    }







}
