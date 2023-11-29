package med.voll.api.adapters.controllers.medico.dtos;


import med.voll.api.adapters.repositories.medico.MedicoEntity;
import med.voll.api.domain.Endereco;
import med.voll.api.domain.Especialidade;

public record DadosMedicoResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        Endereco endereco
) {
        public DadosMedicoResponse(MedicoEntity medico){
                this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
        }
}
