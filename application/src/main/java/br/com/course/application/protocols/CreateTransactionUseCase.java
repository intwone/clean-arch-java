package br.com.course.application.protocols;

import br.com.course.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
