package com.fsse2501pt.fsse2501projectbackend.repository;

import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserReposity extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}


