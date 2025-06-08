package com.fsse2501pt.fsse2501projectbackend.service;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TransactionProductService {
    List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity);

}
