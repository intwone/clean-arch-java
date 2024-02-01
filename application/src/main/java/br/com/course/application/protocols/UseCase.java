package br.com.course.application.protocols;

import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.TransactionPinException;

@FunctionalInterface
public interface UseCase<TParams, TResult> {
    TResult execute(TParams params) throws TaxNumberException, TransactionPinException;
}
