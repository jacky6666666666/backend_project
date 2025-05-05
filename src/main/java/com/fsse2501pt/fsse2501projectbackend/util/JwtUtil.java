package com.fsse2501pt.fsse2501projectbackend.util;


import com.fsse2501pt.fsse2501projectbackend.data.user.domainObject.request.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken; // initiate jwt encryption with token


// turn jwt auth token to firebase userData
public class JwtUtil {
    public static FirebaseUserData toFirebaseUserData(JwtAuthenticationToken token) {
        return new FirebaseUserData(token);

    }

}
