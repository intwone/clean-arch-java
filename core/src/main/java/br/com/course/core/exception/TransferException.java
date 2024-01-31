package br.com.course.core.exception;

public class TransferException extends Exception {
    public String code;

    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }
}
