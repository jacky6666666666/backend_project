package com.fsse2501pt.fsse2501projectbackend.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class ProductOutOfStock extends RuntimeException    {
    public ProductOutOfStock(Integer pid) {

        super("the selected product with product id" + pid + "is out of stock");
    }
}
