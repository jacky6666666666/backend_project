package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.cart.entity.CartEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.repository.TransactionProductRepository;
import com.fsse2501pt.fsse2501projectbackend.service.CartService;
import com.fsse2501pt.fsse2501projectbackend.service.TransactionProductService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransactionProductServiceImpl implements TransactionProductService {
    public CartService cartService;
    private TransactionProductRepository transactionProductRepository;

    @Autowired
    public TransactionProductServiceImpl(CartService cartService, TransactionProductRepository transactionProductRepository) {
        this.cartService = cartService;
        this.transactionProductRepository = transactionProductRepository;

    }

    @Override
    private List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity){
        List<CartEntity> cartEntityList = cartService.getCartItemListByUserEntity(transactionEntity.getUserEntity());
        List<TransactionProductEntity> transactionProductEntities = new ArrayList<>();

        for (CartEntity cartEntity : cartEntityList) {
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transactionEntity);
            transactionProductEntity = transactionProductRepository.save(transactionProductEntity);

        }

        return transactionProductEntities;

    }

}
