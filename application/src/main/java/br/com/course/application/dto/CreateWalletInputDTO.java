package br.com.course.application.dto;

import br.com.course.core.domain.Wallet;

public class CreateWalletInputDTO {
    private final Wallet wallet;

    public CreateWalletInputDTO(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
