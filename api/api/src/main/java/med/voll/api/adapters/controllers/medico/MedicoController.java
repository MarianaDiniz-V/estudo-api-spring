package med.voll.api.adapters.controllers.medico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.adapters.controllers.medico.dtos.DadosAtualizacaoMedico;
import med.voll.api.adapters.controllers.medico.dtos.DadosCadastroMedico;
import med.voll.api.adapters.controllers.medico.dtos.DadosListagemMedico;
import med.voll.api.adapters.repositories.medico.MedicoEntity;
import med.voll.api.adapters.repositories.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new MedicoEntity(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        MedicoEntity medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativar(@PathVariable Long id){
        MedicoEntity medico = repository.getReferenceById(id);
        medico.desativar();
    }
}
