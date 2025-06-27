package com.fsse2501pt.fsse2501projectbackend.data.transaction.entity;

import com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2501pt.fsse2501projectbackend.data.user.entity.UserEntity;
import com.fsse2501pt.fsse2501projectbackend.status.TransactionStatus;
import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Column(name = "data_time", nullable = false)
    private LocalDateTime dataTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();

    public TransactionEntity() {
    }

    public TransactionEntity(UserEntity userEntity, LocalDateTime dataTime, TransactionStatus status, BigDecimal total) {
        this.userEntity = userEntity;
        this.dataTime = LocalDateTime.now();
        this.status = TransactionStatus.PREPARE;
        this.total = BigDecimal.ZERO;
    }

    public TransactionEntity(UserEntity userEntity) {
        // empty?????? you are doing nothing  max fixed
        this.userEntity = userEntity;
        this.dataTime = LocalDateTime.now();
        this.status = TransactionStatus.PREPARE;
        this.total = BigDecimal.ZERO;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
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

    public List<TransactionProductEntity> getTransactionProductEntityList() {
        return transactionProductEntityList;
    }

    public void setTransactionProductEntityList(List<TransactionProductEntity> transactionProductEntityList) {
        this.transactionProductEntityList = transactionProductEntityList;
    }
}
