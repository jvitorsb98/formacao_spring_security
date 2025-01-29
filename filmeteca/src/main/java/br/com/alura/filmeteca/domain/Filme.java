package br.com.alura.filmeteca.domain;

import br.com.alura.filmeteca.dto.DadosCadastroFilme;

public class Filme {

    private String nome;
    private Integer duracaoEmMinutos;

    private Integer anoLancamento;

    private String genero;

    public Filme(DadosCadastroFilme filme){
        this.nome = filme.nome();
        this.duracaoEmMinutos = filme.duracaoEmMinutos();
        this.anoLancamento = filme.anoLancamento();
        this.genero = filme.genero();
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }
}
