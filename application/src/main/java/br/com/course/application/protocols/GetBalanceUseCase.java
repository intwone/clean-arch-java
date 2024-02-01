package br.com.course.application.protocols;

import br.com.course.core.domain.Wallet;

public interface GetBalanceUseCase {
    Integer get(Wallet wallet);
}
