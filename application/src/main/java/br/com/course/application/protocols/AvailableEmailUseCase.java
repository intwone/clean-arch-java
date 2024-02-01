package br.com.course.application.protocols;

import br.com.course.application.dto.AvailableEmailUseCaseInputDTO;
import br.com.course.application.dto.AvailableEmailUseCaseOutputDTO;

public interface AvailableEmailUseCase extends UseCase<AvailableEmailUseCaseInputDTO, AvailableEmailUseCaseOutputDTO> {
    @Override
    AvailableEmailUseCaseOutputDTO execute(AvailableEmailUseCaseInputDTO availableEmailUseCaseInputDTO);
}
