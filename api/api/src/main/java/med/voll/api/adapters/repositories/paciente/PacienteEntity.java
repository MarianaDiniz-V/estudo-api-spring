package med.voll.api.adapters.repositories.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.adapters.controllers.paciente.dtos.DadosCadastroPaciente;
import med.voll.api.domain.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter //gera automaticamente métodos getters para todos os campos da classe
@NoArgsConstructor //gera automaticamente um construtor sem parâmetros
@AllArgsConstructor //gera automaticamente um construtor que aceita todos os campos da classe como parâmetros.
@EqualsAndHashCode(of = "id") //gera automaticamente os métodos equals() e hashCode()
public class PacienteEntity {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private String email;
        private String telefone;
        @Embedded
        private Endereco endereco;

        public PacienteEntity(DadosCadastroPaciente dados) {
                this.nome = dados.nome();
                this.email = dados.email();
                this.telefone = dados.telefone();
                this.endereco = new Endereco(dados.cep());
        }
}
