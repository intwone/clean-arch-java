package br.com.course.application.dto;

public class AvailableEmailUseCaseInputDTO {
    private final String email;

    public AvailableEmailUseCaseInputDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
