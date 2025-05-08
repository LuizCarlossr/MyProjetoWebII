package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.springframework.stereotype.Service;

@Service
public class AdicionarJogoService {

    private final JogosRepository repository;

    public AdicionarJogoService(JogosRepository repository) {
        this.repository = repository; }

    public Jogo adicionarJogo(Jogo jogo) { Jogo salvo = repository.save(jogo);
        System.out.println("O jogo '" + salvo.getNome() + "' foi adicionado em sua biblioteca.");
        return salvo;
    }
}
