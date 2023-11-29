package med.voll.api.adapters.controllers.medico.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicoRequest(
        @NotNull
        Long id,
        String email,
        String telefone,
        String cep
) {
}
