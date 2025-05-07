package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluirJogoService {

    private final JogosRepository repository;

    @Autowired
    public ExcluirJogoService(JogosRepository repository) {
        this.repository = repository; }

    public String excluirJogoPorId(Long id) {
        Jogo jogo = repository.findById(id).orElseThrow
                (() -> new JogoNaoEncontradoException("Jogo com ID " + id + " não foi encontrado."));
        repository.delete(jogo);

        return "O jogo '" + jogo.getId() + "' com ID " + id + " foi excluído com sucesso!";
    }
}
