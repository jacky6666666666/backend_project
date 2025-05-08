package com.fsse2501pt.fsse2501projectbackend.repository;

import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
}
