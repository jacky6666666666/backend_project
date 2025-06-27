package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.repository.TransactionRepository;
import com.fsse2501pt.fsse2501projectbackend.service.*;
import com.fsse2501pt.fsse2501projectbackend.status.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private UserService userService;
    private TransactionRepository transactionRepository;
    private TransactionProductService transactionProductService;
    private ProductService productService;
    private CartService cartService;



    @Autowired
    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository, TransactionProductService transactionProductService, ProductService productService, CartService cartService) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
        this.productService = productService;
        this.cartService = cartService;

    }

    @Override
    public TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = new TransactionEntity(userEntity); // constructor with 1 para
        transactionEntity = transactionRepository.save(transactionEntity);

        List<TransactionProductEntity> transactionProductEntityList = transactionProductService.createTransactionProductList(transactionEntity);
        transactionEntity.setTransactionProductEntityList(transactionProductEntityList);

        transactionEntity.setTotal(
            getTotal(transactionEntity.getTransactionProductEntityList())

        );
        transactionRepository.save(transactionEntity);
       // System.out.println(transactionEntity.getDataTime());

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


    @Override
    public TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTid(tid);



    if (!transactionEntity.getUserEntity().getUid().equals(userEntity.getUid())){
         throw new RuntimeException();
    }
    // we should not see what we bought if we have not login
        return new TransactionResponseData(transactionEntity);

}

    @Override
    public void processTransaction(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTidAndUserEntity(tid, userEntity);

        // check if the previous status is in Prepare, ok if yes
        if (transactionEntity.getStatus() != TransactionStatus.PREPARE){
            throw new RuntimeException();
        }

        /*
        code for connecting to some payment gateway
        */

        transactionEntity.setStatus(TransactionStatus.PROCESSING);
        transactionRepository.save(transactionEntity);

    }

    @Override
    public TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        TransactionEntity transactionEntity = transactionRepository.findTransactionEntityByTidAndUserEntity(tid, userEntity);

        if (transactionEntity.getStatus() != TransactionStatus.PROCESSING){
            throw new RuntimeException();
        }

        for(TransactionProductEntity transactionProductEntity: transactionEntity.getTransactionProductEntityList()){
            productService.deductStock(transactionProductEntity.getPid(), transactionProductEntity.getQuantity());
        }

        cartService.emptyCart(userEntity);
        transactionEntity.setStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transactionEntity);
        return new TransactionResponseData(transactionEntity);

    }



}