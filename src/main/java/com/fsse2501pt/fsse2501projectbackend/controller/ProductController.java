package com.fsse2501pt.fsse2501projectbackend.controller;

import com.fsse2501pt.fsse2501projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.product.dto.response.GetAllProductResponseDto;
import com.fsse2501pt.fsse2501projectbackend.data.product.dto.response.ProductResponseDto;
import com.fsse2501pt.fsse2501projectbackend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/product")
@CrossOrigin("http://localhost:5173")
// is the command directly sent to serviceImpl?
public class ProductController {
    private final ProductService productService; // type this line in order to access method in ProductService interface
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<GetAllProductResponseDto> getAllProduct() {
        List<GetAllProductResponseDto> dtoList = new ArrayList<>();
        for(ProductResponseData data: productService.getAllProduct()){
            dtoList.add(new GetAllProductResponseDto(data));
        }
            return dtoList;
    }

    @GetMapping("/{pid}")  // to add further link
    public ProductResponseDto getByPid(@PathVariable Integer pid) {
        return new ProductResponseDto(
                productService.getProductByPid(pid)
        );
    }


}
