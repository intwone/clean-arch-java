package br.com.course.application.dto;

import br.com.course.core.domain.User;

public class CreateUserInputDTO {
    private final User user;
    private final String pin;

    public CreateUserInputDTO(User user, String pin) {
        this.user = user;
        this.pin = pin;
    }

    public User getUser() {
        return user;
    }

    public String getPin() {
        return pin;
    }
}
