package com.fsse2501pt.fsse2501projectbackend.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer pid) {
        super("Could not find product with id " + pid);
    }

}
