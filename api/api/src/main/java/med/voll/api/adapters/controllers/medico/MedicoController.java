package med.voll.api.adapters.controllers.medico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.adapters.controllers.medico.dtos.DadosAtualizacaoMedicoRequest;
import med.voll.api.adapters.controllers.medico.dtos.DadosMedicoResponse;
import med.voll.api.adapters.controllers.medico.dtos.DadosCadastroMedico;
import med.voll.api.adapters.controllers.medico.dtos.DadosListagemMedico;
import med.voll.api.adapters.repositories.medico.MedicoEntity;
import med.voll.api.adapters.repositories.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemMedico> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id){
        MedicoEntity medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMedicoResponse(medico));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        var medico = new MedicoEntity(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(medico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosMedicoResponse> atualizar(@RequestBody @Valid DadosAtualizacaoMedicoRequest dados){
        MedicoEntity medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);

        return ResponseEntity.ok(new DadosMedicoResponse(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        MedicoEntity medico = repository.getReferenceById(id);
        medico.desativar();

        return ResponseEntity.noContent().build();
    }
}
