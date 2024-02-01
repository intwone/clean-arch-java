package br.com.course.application.protocols;

import br.com.course.application.dto.CreateWalletInputDTO;
import br.com.course.application.dto.CreateWalletOutputDTO;

public interface CreateWalletUseCase extends UseCase<CreateWalletInputDTO, CreateWalletOutputDTO> {
    @Override
    CreateWalletOutputDTO execute(CreateWalletInputDTO createWalletInputDTO);
}
