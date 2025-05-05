package com.fsse2501pt.fsse2501projectbackend.data.cart.domainObject.response;

import com.fsse2501pt.fsse2501projectbackend.data.cart.entity.CartEntity;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;

public class CartResponseData {
    private Integer cid;
    private ProductEntity productEntity;
    private UserEntity userEntity;
    private Integer quantity;

    public CartResponseData(CartEntity cartEntity) {
        this.cid = cartEntity.getCid();
        this.productEntity = cartEntity.getProduct();
        this.userEntity = cartEntity.getUser();
        this.quantity = cartEntity.getQuantity();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
