package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.dto.JogoDTO;
import myprojetowebii.cadastro.dto.mapper.JogoMapper;
import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcurarJogosService {

    private final JogosRepository jogosRepository;

    public ProcurarJogosService(JogosRepository jogosRepository) { this.jogosRepository = jogosRepository; }

    public List<JogoDTO> procurarTodosOsJogos() {
        return jogosRepository.findAll().stream()
                .map(jogo -> JogoMapper.toJogoDTO(jogo)).collect(Collectors.toList());
    }

    public Jogo procurarJogoPorId(Long id) {
        Optional<Jogo> jogoOptional = jogosRepository.findById(id);
        return jogoOptional.orElseThrow(() -> new JogoNaoEncontradoException
                ("Jogo com ID " + id + " não foi encontrado"));
    }
}
