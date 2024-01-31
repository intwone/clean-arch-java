package br.com.course.core.domain;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.enums.ErrorCodeEnum;

public class TaxNumber {
    private String value;

    public TaxNumber(String taxNumber) throws Exception {
        setValue(taxNumber);
    }

    public TaxNumber() {
    }

    public void setValue(String value) throws Exception {
        if (isValid(value)) this.value = value;

        throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
    }

    public String getValue(){
        return this.value;
    }

    private Boolean isValid(String taxNumber) throws Exception {
        String removeSpecialCharsRegex = "\\W";
        String normalizedTaxNumber = taxNumber.replaceAll(removeSpecialCharsRegex, "");

        boolean isValidTaxNumberLength = normalizedTaxNumber.length() == 11 || normalizedTaxNumber.length() == 14;

        if (isValidTaxNumberLength) return isCpfValid(taxNumber) || isCnpjValid(taxNumber);

        throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
    }

    private Boolean isCpfValid(String cpf) {
        return new CPFValidator().isEligible(cpf);
    }

    private Boolean isCnpjValid(String cnpj) {
        return new CNPJValidator().isEligible(cnpj);
    }
}
