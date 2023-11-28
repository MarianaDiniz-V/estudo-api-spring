package med.voll.api.adapters.controllers.dtos;


import med.voll.api.domain.Especialidade;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        String cep
) {
}
