package br.com.course.application.dto;

public class AvailableTaxNumberUseCaseInputDTO {
    private final String taxNumber;

    public AvailableTaxNumberUseCaseInputDTO(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }
}
