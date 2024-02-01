package br.com.course.application.usecase;

import br.com.course.application.dto.*;
import br.com.course.application.gateway.CreateUserGateway;
import br.com.course.application.protocols.*;
import br.com.course.core.domain.TaxNumber;
import br.com.course.core.domain.TransactionPin;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.TransactionPinException;
import br.com.course.core.exception.enums.ErrorCodeEnum;

public class CreateUserUseCase implements UseCase<CreateUserInputDTO, CreateUserOutputDTO> {
    private final AvailableTaxNumberUseCase availableTaxNumberUseCase;
    private final AvailableEmailUseCase availableEmailUseCase;
    private final CreateUserGateway createUserGateway;
    private final CreateWalletUseCase createWalletUseCase;
    private final CreateTransactionPinUseCase createTransactionPinUseCase;

    public CreateUserUseCase(
        AvailableTaxNumberUseCase availableTaxNumberUseCase,
        AvailableEmailUseCase availableEmailUseCase,
        CreateUserGateway createUserGateway,
        CreateWalletUseCase createWalletUseCase,
        CreateTransactionPinUseCase createTransactionPinUseCase
    ) {
        this.availableTaxNumberUseCase = availableTaxNumberUseCase;
        this.availableEmailUseCase = availableEmailUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
    }

    @Override
    public CreateUserOutputDTO execute(CreateUserInputDTO createUserInputDTO) throws TaxNumberException, TransactionPinException {
        TaxNumber taxNumber = createUserInputDTO.getUser().getTaxNumber();
        AvailableTaxNumberUseCaseInputDTO availableTaxNumberUseCaseInput = new AvailableTaxNumberUseCaseInputDTO(taxNumber.getValue());
        AvailableTaxNumberUseCaseOutputDTO isAvailableTaxNumber = availableTaxNumberUseCase.execute(availableTaxNumberUseCaseInput);

        if (!isAvailableTaxNumber.getIsAvailable()) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        String email = createUserInputDTO.getUser().getEmail();
        AvailableEmailUseCaseInputDTO availableEmailUseCaseInput = new AvailableEmailUseCaseInputDTO(email);
        AvailableEmailUseCaseOutputDTO isAvailableEmail = availableEmailUseCase.execute(availableEmailUseCaseInput);

        if (!isAvailableEmail.getIsAvailable()) {
            throw new TaxNumberException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var createdUser = createUserGateway.create(createUserInputDTO.getUser());

        Wallet wallet = new Wallet(0, createdUser);
        CreateWalletInputDTO createWalletInputDTO = new CreateWalletInputDTO(wallet);
        createWalletUseCase.execute(createWalletInputDTO);

        String pin = createUserInputDTO.getPin();

        TransactionPin transactionPin = new TransactionPin(createdUser);
        transactionPin.setPin(pin);

        return new CreateUserOutputDTO();
    }
}
