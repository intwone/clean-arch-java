package br.com.course.core.domain;

import br.com.course.core.domain.enums.UserTypeEnum;
import br.com.course.core.exception.TransferException;
import br.com.course.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private Integer balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, Integer balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(Integer balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void receive(Integer value) {
        this.balance = this.balance + value;
    }

    public void transfer(Integer value) throws TransferException {
        boolean isShopKeeperUser = this.user.getType() != UserTypeEnum.ShopKeeper;

        if (isShopKeeperUser) throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());

        boolean hasNegativeBalance = this.balance <= 0;

        if (hasNegativeBalance) throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());

        this.balance = this.balance - value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
