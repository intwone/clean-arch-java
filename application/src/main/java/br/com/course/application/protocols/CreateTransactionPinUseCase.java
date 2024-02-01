package br.com.course.application.protocols;

import br.com.course.application.dto.CreateTransactionPinInputDTO;
import br.com.course.core.domain.TransactionPin;

public interface CreateTransactionPinUseCase {
    void create(TransactionPin transactionPin);
}


