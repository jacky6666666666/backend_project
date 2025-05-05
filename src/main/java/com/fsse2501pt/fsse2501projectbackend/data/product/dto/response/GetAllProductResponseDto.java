package com.fsse2501pt.fsse2501projectbackend.data.product.dto.response;

import com.fsse2501pt.fsse2501projectbackend.data.product.domainObject.response.ProductResponseData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Boolean hasStock;

    public GetAllProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        this.hasStock = data.getStock() > 0;
    }

    public Integer getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean isHasStock() {
        return hasStock;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setHasStock(Boolean hasStock) {
        this.hasStock = hasStock;
    }
}
