package br.com.course.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Invalid tax number", "ON-0001"),
    TR0001("Shopkeeper cannot transfer a value", "TR-0001"),
    TR0002("Insufficient funds", "TR-0002"),
    AU0001("Invalid pin length", "AU-0001"),
    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
