package br.com.course.application.protocols;

import br.com.course.core.domain.Transaction;

public interface NotificationUserUseCase {
    Boolean notify(Transaction transaction, String email);
}
