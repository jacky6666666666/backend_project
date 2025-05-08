
package com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.dto;

import com.fsse2501pt.fsse2501projectbackend.data.product.dto.response.ProductResponseDto;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.response.TransactionProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.service.ProductService;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto product;
    private Integer quantity;
    private BigDecimal subtotal;


    // DI
   // private ProductService productService; // type this line in order to access method in ProductService interface
    //public TransactionProductResponseDto(ProductService productService) {
    //    this.productService = productService;
    //}


    public TransactionProductResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.tpid = transactionProductResponseData.getTpid();
        this.product = new ProductResponseDto(transactionProductResponseData);
        this.quantity = transactionProductResponseData.getQuantity();
        this.subtotal = transactionProductResponseData.getPrice().multiply(
                new BigDecimal(transactionProductResponseData.getQuantity()));
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}


