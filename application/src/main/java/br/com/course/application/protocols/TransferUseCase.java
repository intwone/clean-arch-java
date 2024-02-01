package br.com.course.application.protocols;

import br.com.course.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
