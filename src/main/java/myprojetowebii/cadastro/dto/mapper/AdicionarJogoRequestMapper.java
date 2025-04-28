package myprojetowebii.cadastro.dto.mapper;

import myprojetowebii.cadastro.dto.AdicionarJogoRequestDTO;
import myprojetowebii.cadastro.model.Jogo;

public class AdicionarJogoRequestMapper {

    public static Jogo toEntity(AdicionarJogoRequestDTO dto) {
        Jogo jogo = new Jogo();
        jogo.getNome(dto.getNome());
        jogo.getGenero(dto.getGenero());
        jogo.getDataLancamento(dto.getDataLancamento());
        jogo.getPreco(dto.getPreco());
        return jogo;

    }
}
