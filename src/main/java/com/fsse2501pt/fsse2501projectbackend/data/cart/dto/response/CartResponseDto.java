package com.fsse2501pt.fsse2501projectbackend.data.cart.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2501pt.fsse2501projectbackend.data.cart.domainObject.response.CartResponseData;

import java.math.BigDecimal;

public class CartResponseDto {
    @JsonProperty("pid")
    private Integer pid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("cartQuantity")
    private Integer quantity;

    @JsonProperty("stock")
    private Integer stock;

    public CartResponseDto(CartResponseData cartResponseData) {
        this.pid = cartResponseData.getProductEntity().getPid();
        this.name = cartResponseData.getProductEntity().getName();
        this.imageUrl = cartResponseData.getProductEntity().getImageUrl();
        this.price = cartResponseData.getProductEntity().getPrice();
        this.quantity = cartResponseData.getQuantity();
        this.stock = cartResponseData.getQuantity();

    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
