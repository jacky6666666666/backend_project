package com.fsse2501pt.fsse2501projectbackend.controller;
import com.fsse2501pt.fsse2501projectbackend.data.cart.domainObject.response.CartResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.cart.dto.response.CartResponseDto;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.service.CartService;
import com.fsse2501pt.fsse2501projectbackend.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart/items")
public class CartController {
    private final CartService cartService;

    // DI
    @Autowired
    public CartController(CartService cartService) {

        this.cartService = cartService;
    }

    @PutMapping("{pid}/{quantity}")
    public void putCartItem(JwtAuthenticationToken token, @PathVariable int pid, @Positive @PathVariable int quantity) {

        FirebaseUserData firebaseUserData = JwtUtil.toFirebaseUserData(token);

        cartService.putCartItem(firebaseUserData, pid, quantity);
    }

    @GetMapping()
    public List<CartResponseDto> getCartItem(JwtAuthenticationToken token) {
        FirebaseUserData firebaseUserData = JwtUtil.toFirebaseUserData(token);
        List<CartResponseDto> cartResponseDtoList = new ArrayList<>();

        for (CartResponseData cartResponseData: cartService.getCartItemList(firebaseUserData)) {
            cartResponseDtoList.add(new CartResponseDto(cartResponseData));
        }
        return cartResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartResponseDto updateCartItem(@PathVariable Integer pid,
                                          @PathVariable Integer quantity,
                                          JwtAuthenticationToken token) {

        return new CartResponseDto(cartService.updateCartItem(JwtUtil.toFirebaseUserData(token), pid, quantity));
    }

    @DeleteMapping("/{pid}")
    public void deleteCartItem(@PathVariable Integer pid, JwtAuthenticationToken token) {
        cartService.deleteCartItem(JwtUtil.toFirebaseUserData(token), pid);

    }


}
