package br.com.course.application.protocols;

import br.com.course.application.dto.AvailableTaxNumberUseCaseInputDTO;
import br.com.course.application.dto.AvailableTaxNumberUseCaseOutputDTO;

public interface AvailableTaxNumberUseCase extends UseCase<AvailableTaxNumberUseCaseInputDTO, AvailableTaxNumberUseCaseOutputDTO> {
    @Override
    AvailableTaxNumberUseCaseOutputDTO execute(AvailableTaxNumberUseCaseInputDTO availableTaxNumberUseCaseInputDTO);
}
