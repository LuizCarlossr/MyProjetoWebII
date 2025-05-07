package myprojetowebii.cadastro.dto.mapper;

import myprojetowebii.cadastro.dto.JogoDTO;
import myprojetowebii.cadastro.model.Jogo;

public class JogoMapper {

    public static JogoDTO toJogoDTO(Jogo jogo) {
        JogoDTO jogoDTO = new JogoDTO(
                jogo.getNome(), jogo.getGenero(),
                jogo.getDataLancamento(), jogo.getPreco()
        );
        return jogoDTO;
    }
}


