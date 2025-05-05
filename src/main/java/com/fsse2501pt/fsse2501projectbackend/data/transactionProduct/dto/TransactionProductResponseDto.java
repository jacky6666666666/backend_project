package com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.dto;

import com.fsse2501pt.fsse2501projectbackend.data.product.dto.response.ProductResponseDto;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.response.TransactionProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.service.ProductService;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto product;
    private Integer quantity;
    private BigDecimal subtotal;

    /*
    // DI
    private ProductService productService; // type this line in order to access method in ProductService interface
    public TransactionProductResponseDto(ProductService productService) {
        this.productService = productService;
    }
     */

    public TransactionProductResponseDto(TransactionProductEntity transactionProductEntity) {
        this.tpid = transactionProductEntity.getTpid();
        this.product = new ProductResponseDto(transactionProductResponseData);
        this.quantity = transactionProductEntity.getQuantity();
        this.subtotal = transactionProductEntity.getPrice().multiply(
                new BigDecimal(transactionProductEntity.getQuantity()));
    }


}
