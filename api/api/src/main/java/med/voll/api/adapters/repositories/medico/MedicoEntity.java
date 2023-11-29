package med.voll.api.adapters.repositories.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.adapters.controllers.medico.dtos.DadosAtualizacaoMedico;
import med.voll.api.adapters.controllers.medico.dtos.DadosCadastroMedico;
import med.voll.api.domain.Especialidade;
import med.voll.api.domain.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter //gera automaticamente métodos getters para todos os campos da classe
@NoArgsConstructor //gera automaticamente um construtor sem parâmetros
@AllArgsConstructor //gera automaticamente um construtor que aceita todos os campos da classe como parâmetros.
@EqualsAndHashCode(of = "id") //gera automaticamente os métodos equals() e hashCode()
public class MedicoEntity{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private String email;
        private String telefone;
        private String crm;
        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;
        @Embedded
        private Endereco endereco;
        private Boolean ativo;

        public MedicoEntity(DadosCadastroMedico dados) {
                this.nome = dados.nome();
                this.email = dados.email();
                this.telefone = dados.telefone();
                this.crm = dados.crm();
                this.especialidade = dados.especialidade();
                this.endereco = new Endereco(dados.cep());
                this.ativo = true;
        }

        public void atualizarDados(DadosAtualizacaoMedico dados) {
                if(dados.email() != null){
                        this.email = dados.email();
                }
                if(dados.telefone() != null){
                        this.telefone = dados.telefone();
                }
                if(dados.cep() != null){
                        this.endereco.atualizarDados(dados.cep());
                }
        }

        public void desativar() {
                this.ativo = false;
        }
}
