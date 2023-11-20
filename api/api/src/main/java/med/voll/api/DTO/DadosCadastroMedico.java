package med.voll.api.DTO;

import med.voll.api.Especialidade;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        String cep
) {
}
