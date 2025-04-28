package myprojetowebii.cadastro.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private LocalDate dataLancamento;
    private Double preco;

    public Jogo(Long id, String nome, String genero, LocalDate dataLancamento, Double preco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
    }
    public Jogo() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome(String nome) { return this.nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getGenero(String genero) { return this.genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getDataLancamento(LocalDate dataLancamento) { return this.dataLancamento; }

    public void setDataLancamento(LocalDate dataLancamento)
    { this.dataLancamento = dataLancamento; }

    public Double getPreco(Double preco) { return this.preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}
