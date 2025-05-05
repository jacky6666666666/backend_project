package com.fsse2501pt.fsse2501projectbackend.data.user.entity;

import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import jakarta.persistence.*;

@Entity
@Table(name = "user", indexes = @Index(columnList = "email")) // to make a dictionary to enhance searching speed, mysql is defaulted to search object by auto id
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String firebaseuid;

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData firebaseUserData) {
        this.email = firebaseUserData.getEmail();
        this.firebaseuid = firebaseUserData.getFirebaseUid();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseuid() {
        return firebaseuid;
    }

    public void setFirebaseuid(String firebaseuid) {
        this.firebaseuid = firebaseuid;
    }
}
