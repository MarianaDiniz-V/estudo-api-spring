package med.voll.api;

public record DadosEnderecoMedico(
        String logradouro,
        String bairro,
        String cidade,
        String uf,
        String numero,
        String complemento
) {
}
