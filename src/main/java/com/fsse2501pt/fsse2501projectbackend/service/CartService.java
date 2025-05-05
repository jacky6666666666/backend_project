package com.fsse2501pt.fsse2501projectbackend.service;

import com.fsse2501pt.fsse2501projectbackend.data.cart.domainObject.response.CartResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;

import java.util.List;

public interface CartService {


    void putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    List<CartResponseData> getCartItemList(FirebaseUserData firebaseUserData);

    CartResponseData updateCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    void deleteCartItem(FirebaseUserData firebaseUserData, Integer pid);



}
