package com.fsse2501pt.fsse2501projectbackend.service;

import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;

public interface UserService {
    public UserEntity getEntityByEmail(FirebaseUserData firebaseUserData);
}
