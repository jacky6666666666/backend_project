package com.fsse2501pt.fsse2501projectbackend.data.transactionProduct.entity;


import com.fsse2501pt.fsse2501projectbackend.data.cart.entity.CartEntity;
import com.fsse2501pt.fsse2501projectbackend.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_product")
public class TransactionProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;

    @ManyToOne
    @JoinColumn(name = "tid", nullable = false)
    private TransactionEntity transaction;


    @Column(name = "pid", nullable = false)
    private Integer pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public TransactionProductEntity(TransactionEntity transactionEntity, CartEntity cartEntity) {
//        use this constructor!
        this.transaction = transactionEntity;
        this.pid = cartEntity.getProduct().getPid();
        this.name = cartEntity.getProduct().getName();
        this.description = cartEntity.getProduct().getDescription();
        this.imageUrl = cartEntity.getProduct().getImageUrl();
        this.price = cartEntity.getProduct().getPrice();
        this.stock = cartEntity.getProduct().getStock();
        this.quantity = cartEntity.getQuantity();
    }

    public TransactionProductEntity() {
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
