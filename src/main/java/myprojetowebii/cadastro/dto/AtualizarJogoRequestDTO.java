package myprojetowebii.cadastro.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AtualizarJogoRequestDTO {

    @NotBlank(message = "Precisa adicionar o nome do jogo")
    @Size(min = 3, message = "O nome do jogo precisa ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Digite o gênero do jogo")
    @Size(min = 3, message = "O gênero precisa ter no mínimo 3 caracteres")
    private String genero;

    @NotNull(message = "A data de lançamento não pode ficar vazia, ex: ano-mês-dia com 4 dígitos")
    private LocalDate dataLancamento;

    @NotNull(message = "O valor do jogo não pode ser vazio")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço do jogo deve ser maior que zero")
    private Double preco;

    @NotBlank(message = "Precisa adicionar o nome da plataforma")
    @Size(min = 3, message = "O nome da plataforma precisa ter no mínimo 3 caracteres")
    private String plataforma;

    public AtualizarJogoRequestDTO() {}

    public AtualizarJogoRequestDTO(String nome, String genero, LocalDate dataLancamento, Double preco, String plataforma) {
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
        this.plataforma = plataforma;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getDataLancamento() { return dataLancamento; }

    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public String getPlataforma() { return plataforma; }

    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
}


