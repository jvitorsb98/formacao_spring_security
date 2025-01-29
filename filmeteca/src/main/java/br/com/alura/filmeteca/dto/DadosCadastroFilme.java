package br.com.alura.filmeteca.dto;

public record DadosCadastroFilme(

        String nome,

        Integer duracaoEmMinutos,

        Integer anoLancamento,

        String genero

) {
}
