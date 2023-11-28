package med.voll.api.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
