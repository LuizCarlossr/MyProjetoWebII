package myprojetowebii.cadastro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AdicionarJogoRequestDTO {

    @NotBlank(message = "Precisa adicionar o nome do jogo")
    @Size(min = 3, message = "O nome do jogo precisa ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Digite o gênero do jogo")
    @Size(min = 3, message = "O gênero precisa ter no mínimo 3 caracteres")
    private String genero;

    @NotNull(message = "A data de lançamento não pode ficar vazia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataLancamento;

    @NotNull(message = "O valor do jogo não pode ser vazio")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço do jogo deve ser maior que zero")
    private Double preco;

    public AdicionarJogoRequestDTO() {}

    public AdicionarJogoRequestDTO(String nome, String genero, LocalDate dataLancamento, Double preco) {
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

    public void setDataLancamento(LocalDate dataLancamento)
    { this.dataLancamento = dataLancamento; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}


