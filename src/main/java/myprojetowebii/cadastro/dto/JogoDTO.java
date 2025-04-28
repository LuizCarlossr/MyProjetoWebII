package myprojetowebii.cadastro.dto;

import java.time.LocalDate;

public class JogoDTO {
    private int id;
    private String nome;
    private String genero;
    private LocalDate dataNascimento;
    private Double preco;

    public JogoDTO() {}

    public JogoDTO(String nome, String genero, LocalDate dataNascimento, Double preco) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.preco = preco;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}