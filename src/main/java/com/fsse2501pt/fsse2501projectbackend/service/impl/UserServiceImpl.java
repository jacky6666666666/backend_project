package com.fsse2501pt.fsse2501projectbackend.service.impl;

import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2501pt.fsse2501projectbackend.repository.UserReposity;
import com.fsse2501pt.fsse2501projectbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  UserServiceImpl implements UserService {
    private final UserReposity userReposity;

    public UserServiceImpl(UserReposity userReposity) {
        this.userReposity = userReposity;
    }

    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData) {

        Optional<UserEntity> optionalUserEntity = userReposity.findByEmail(firebaseUserData.getEmail());

        // if have valid email in firebaseUserData, get it
        if (optionalUserEntity.isPresent()) {
            return optionalUserEntity.get();
        }

        // if do not have valid email in firebaseUserData, create a new one
        UserEntity userEntity = new UserEntity(firebaseUserData);  // this userEntity do not have uid
        return userReposity.save(userEntity); // after save, this userEntity has uid

        /*
        // compacted style in Lambda function
        userRepository.findByEmail(firebaseUserData.getEmail()).orElseGet(
        () -> userRepository.save(
        new UserEntity(firebaseUserData)));


        */


    }

}
