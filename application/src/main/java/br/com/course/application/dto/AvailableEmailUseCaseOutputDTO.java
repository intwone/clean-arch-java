package br.com.course.application.dto;

public class AvailableEmailUseCaseOutputDTO {
    private final Boolean isAvailable;

    public AvailableEmailUseCaseOutputDTO(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }
}
