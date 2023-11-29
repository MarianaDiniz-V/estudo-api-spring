package med.voll.api.adapters.controllers.medico.dtos;

import med.voll.api.domain.Especialidade;
import med.voll.api.adapters.repositories.medico.MedicoEntity;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
        public DadosListagemMedico(MedicoEntity medico){
                this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
        }
}
