package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.repository.TransactionRepository;
import com.fsse2501pt.fsse2501projectbackend.service.TransactionService;
import com.fsse2501pt.fsse2501projectbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionServiceImpl implements TransactionService {
    private UserService userService;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;

    }

    @Override
    public TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByEmail(firebaseUserData);

        TransactionEntity transactionEntity = new TransactionEntity(userEntity);
        transactionEntity = transactionRepository.save(transactionEntity);

    }




}
