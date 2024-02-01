package br.com.course.application.dto;

public class AvailableTaxNumberUseCaseOutputDTO {
    private final Boolean isAvailable;

    public AvailableTaxNumberUseCaseOutputDTO(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }
}
