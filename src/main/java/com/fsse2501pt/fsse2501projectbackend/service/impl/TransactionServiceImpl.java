package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.repository.TransactionRepository;
import com.fsse2501pt.fsse2501projectbackend.service.TransactionProductService;
import com.fsse2501pt.fsse2501projectbackend.service.TransactionService;
import com.fsse2501pt.fsse2501projectbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private UserService userService;
    private TransactionRepository transactionRepository;
    private TransactionProductService transactionProductService;



    @Autowired
    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository, TransactionProductService transactionProductService) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;

    }

    @Override
    public TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByEmail(firebaseUserData);

        TransactionEntity transactionEntity = new TransactionEntity(userEntity);
        transactionEntity = transactionRepository.save(transactionEntity);

        List<TransactionProductEntity> transactionProductEntityList = transactionProductService.createTransactionProductList(transactionEntity);
        transactionEntity.setTransactionProductEntityList(transactionProductEntityList);

        transactionEntity.setTotal(
            getTotal(transactionEntity.getTransactionProductEntityList())

        );
        transactionRepository.save(transactionEntity);

        TransactionResponseData transactionResponseData = new TransactionResponseData(transactionEntity);
        return transactionResponseData;
    }

    public BigDecimal getTotal(List<TransactionProductEntity> transactionProductEntityList){
        BigDecimal total = BigDecimal.ZERO;
        for(TransactionProductEntity transactionProductEntity : transactionProductEntityList){
            BigDecimal price = transactionProductEntity.getPrice();
            Integer quantity = transactionProductEntity.getQuantity();
            total = total.add(price.multiply(BigDecimal.valueOf(quantity)));
        }
        return total;

    }




}
