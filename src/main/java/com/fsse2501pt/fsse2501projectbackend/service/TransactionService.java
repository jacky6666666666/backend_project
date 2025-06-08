package com.fsse2501pt.fsse2501projectbackend.service;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;

public interface TransactionService {
    TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData);




}
