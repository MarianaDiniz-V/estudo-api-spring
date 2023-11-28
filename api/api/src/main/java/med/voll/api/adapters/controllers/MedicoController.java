package med.voll.api.adapters.controllers;

import med.voll.api.adapters.controllers.dtos.DadosCadastroMedico;
import med.voll.api.adapters.repositories.MedicoEntity;
import med.voll.api.adapters.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new MedicoEntity(dados));
    }
}
