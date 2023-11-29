package med.voll.api.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.adapters.controllers.medico.dtos.DadosAtualizacaoMedico;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;
    public Endereco(String cep) {
        this.cep = cep;
        this.logradouro = "fake";
        this.bairro = "fake";
        this.cidade = "fake";
        this.uf = "fake";
        this.numero = "fake";
        this.complemento = "fake";
    }

    public void atualizarDados(String cep) {
        if(cep != null){
            this.cep = cep;
        }
    }
}
