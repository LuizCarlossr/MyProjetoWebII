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
                System.out.println("Nome atualizado para: " + jogo.getNome());
            }
            if (dto.getGenero() != null) {
                jogo.setGenero(dto.getGenero());
                System.out.println("Genero atualizado para: " + jogo.getGenero());
            }
            if (dto.getDataLancamento() != null) {
                jogo.setDataLancamento(dto.getDataLancamento());
                System.out.println("Data atualizado para: " + jogo.getDataLancamento());
            }
            if (dto.getPreco() != null) {
                jogo.setPreco(dto.getPreco());
                System.out.println("Preço atualizado para R$: " + jogo.getPreco());
            }
            if (dto.getPlataforma() != null) {
                jogo.setPlataforma(dto.getPlataforma());
                System.out.println("Plataforma atualizado para: " + jogo.getPlataforma());
            }
            return repository.save(jogo);
        }).orElseThrow(() -> new JogoNaoEncontradoException
                ("Jogo com ID " + id + " não foi encontrado."));
    }
}
