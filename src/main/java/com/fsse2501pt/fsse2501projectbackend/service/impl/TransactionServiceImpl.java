package com.fsse2501pt.fsse2501projectbackend.service.impl;

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




}
