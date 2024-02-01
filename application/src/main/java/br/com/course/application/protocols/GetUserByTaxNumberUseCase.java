package br.com.course.application.protocols;

import br.com.course.core.domain.User;

public interface GetUserByTaxNumberUseCase {
    User getByTaxNumber(String taxNumber);
}
