package br.com.course.core.domain;

import br.com.course.core.exception.TransactionPinException;
import br.com.course.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransactionPin {
    private Long id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean isBlocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(
        Long id,
        User user,
        String pin,
        Integer attempt,
        Boolean isBlocked,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.isBlocked = isBlocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user) {
        int ATTEMPT_MAX = 3;

        this.user = user;
        this.attempt = ATTEMPT_MAX;
        this.isBlocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        isValidPin(pin);

        this.pin = pin;
    }

    public void isValidPin(String pin) throws TransactionPinException {
        int VALID_PIN_LENGTH = 8;

        boolean isInvalidPinLength = pin.length() != VALID_PIN_LENGTH;

        if (isInvalidPinLength) throw new TransactionPinException(ErrorCodeEnum.AU0001.getMessage(), ErrorCodeEnum.AU0001.getCode());
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
       this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
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
