package br.com.course.application.dto;

import br.com.course.core.domain.TransactionPin;
import br.com.course.core.domain.Wallet;

public class CreateTransactionPinInputDTO {
    private final TransactionPin transactionPin;

    public CreateTransactionPinInputDTO(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }
}
