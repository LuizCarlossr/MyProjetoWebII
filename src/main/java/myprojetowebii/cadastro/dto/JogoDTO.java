package myprojetowebii.cadastro.dto;

import java.time.LocalDate;

public class JogoDTO {
    private int id;
    private String nome;
    private String genero;
    private LocalDate dataLancamento;
    private Double preco;

    public JogoDTO() {}

    public JogoDTO(String nome, String genero, LocalDate dataLancamento, Double preco) {
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getDataLancamento() { return dataLancamento; }

    public void setDataLancamento(LocalDate dataNascimento) { this.dataLancamento = dataLancamento; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}