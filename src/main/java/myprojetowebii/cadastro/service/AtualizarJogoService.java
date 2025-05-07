package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.dto.AtualizarJogoRequestDTO;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarJogoService {

    private final JogosRepository repository;

    @Autowired
    public AtualizarJogoService(JogosRepository repository) { this.repository = repository; }

    public Jogo atualizar(Long id, AtualizarJogoRequestDTO dto) {
        return repository.findById(id).map(jogo -> {
            if (dto.getNome() != null) {
                jogo.setNome(dto.getNome());
            }
            if (dto.getGenero() != null) {
                jogo.setGenero(dto.getGenero());
            }
            if (dto.getDataLancamento() != null) {
                jogo.setDataLancamento(dto.getDataLancamento());
            }
            if (dto.getPreco() != null) {
                jogo.setPreco(dto.getPreco());
            }
            return repository.save(jogo);
        }).orElseThrow(() -> new JogoNaoEncontradoException
                ("Jogo com ID " + id + " não foi encontrado."));
    }
}
