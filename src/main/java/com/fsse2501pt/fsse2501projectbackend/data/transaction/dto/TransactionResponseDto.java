package com.fsse2501pt.fsse2501projectbackend.data.transaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.response.TransactionResponseData;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.dto.TransactionProductResponseDto;
import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.response.TransactionProductResponseData;
import com.fsse2501pt.fsse2501projectbackend.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    private Integer id;
    private Integer buyerUid;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime transactionDate;

    private TransactionStatus status;
    private BigDecimal total;

    @JsonProperty("Items")
    private List<TransactionProductResponseDto> transactionProductResponseDtoList = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData transactionResponseData) {
        this.id = transactionResponseData.getTid();
        this.buyerUid = transactionResponseData.getUser().getUid();
        this.transactionDate = transactionResponseData.getTransactionDate();
        this.status = transactionResponseData.getTransactionStatus();
        this.total = transactionResponseData.getAmount();
        for (TransactionProductResponseData transactionProductResponseData: transactionResponseData.getTransactionProductResponseDataList()){
            this.transactionProductResponseDtoList.add(new TransactionProductResponseDto(transactionProductResponseData));
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductResponseDto> getTransactionProductResponseDtoList() {
        return transactionProductResponseDtoList;
    }

    public void setTransactionProductResponseDtoList(List<TransactionProductResponseDto> transactionProductResponseDtoList) {
        this.transactionProductResponseDtoList = transactionProductResponseDtoList;
    }
}
