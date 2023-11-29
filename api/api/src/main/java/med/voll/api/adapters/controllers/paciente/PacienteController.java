package med.voll.api.adapters.controllers.paciente;

import jakarta.validation.Valid;
import med.voll.api.adapters.controllers.paciente.dtos.DadosCadastroPaciente;
import med.voll.api.adapters.repositories.medico.MedicoEntity;
import med.voll.api.adapters.repositories.medico.MedicoRepository;
import med.voll.api.adapters.repositories.paciente.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
       // TODO
    }
}
