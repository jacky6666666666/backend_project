package com.fsse2501pt.fsse2501projectbackend.data.product.dto.response;

import com.fsse2501pt.fsse2501projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.product.entity.ProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.response.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductResponseDto {
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;

    public ProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.description = data.getDescription();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        this.stock = data.getStock();

    }

    public ProductResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.pid = transactionProductResponseData.getPid();
        this.name = transactionProductResponseData.getName();
        this.description = transactionProductResponseData.getDescription();
        this.imageUrl = transactionProductResponseData.getImageUrl();
        this.price = transactionProductResponseData.getPrice();
        this.stock = transactionProductResponseData.getStock();

    }

}
