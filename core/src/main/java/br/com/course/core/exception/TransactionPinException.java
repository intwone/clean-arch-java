package br.com.course.core.exception;

public class TransactionPinException extends Exception {
    public String code;

    public TransactionPinException(String message, String code) {
        super(message);
        this.code = code;
    }
}
