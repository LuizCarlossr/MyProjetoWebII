package myprojetowebii.cadastro.dto.mapper;

import myprojetowebii.cadastro.dto.AdicionarJogoRequestDTO;
import myprojetowebii.cadastro.model.Jogo;

public class AdicionarJogoRequestMapper {

    public static Jogo toEntity(AdicionarJogoRequestDTO dto) {
        Jogo jogo = new Jogo();
        jogo.setNome(dto.getNome());
        jogo.setGenero(dto.getGenero());
        jogo.setDataLancamento(dto.getDataLancamento());
        jogo.setPreco(dto.getPreco());
        return jogo;
    }
}
