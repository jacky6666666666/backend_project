package com.fsse2501pt.fsse2501projectbackend.repository;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

    TransactionEntity findTransactionEntityByTid(Integer tid);

    TransactionEntity findTransactionEntityByTidAndUserEntity(Integer tid, UserEntity userEntity);
}
