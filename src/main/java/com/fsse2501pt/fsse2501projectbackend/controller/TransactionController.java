package com.fsse2501pt.fsse2501projectbackend.controller;


import com.fsse2501pt.fsse2501projectbackend.data.transaction.dto.TransactionResponseDto;
import com.fsse2501pt.fsse2501projectbackend.service.TransactionService;
import com.fsse2501pt.fsse2501projectbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("")
    public TransactionResponseDto createTransaction(JwtAuthenticationToken jwtAuthenticationToken) {
        return new TransactionResponseDto(
                transactionService.prepareTransaction(JwtUtil.toFirebaseUserData(jwtAuthenticationToken))
        );

    }



}
