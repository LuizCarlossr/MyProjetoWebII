package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.dto.AtualizarJogoRequestDTO;
import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AtualizarJogoServiceTest {

    private final JogosRepository repository = mock(JogosRepository.class);
    private final AtualizarJogoService service = new AtualizarJogoService(repository);

    @Test
    void deveAtualizarJogoExistente() {
        Long id = 1L;
        Jogo existente = new Jogo(id, "Dark Soul", "Ação", LocalDate.now(), 100.0, "PC");

        AtualizarJogoRequestDTO dto = new AtualizarJogoRequestDTO("Novo", "RPG", LocalDate.now(), 150.0, "PS5");

        when(repository.findById(id)).thenReturn(Optional.of(existente));
        when(repository.save(any(Jogo.class))).thenReturn(existente);

        Jogo atualizado = service.atualizar(id, dto);

        assertEquals("Novo", atualizado.getNome());
        assertEquals("RPG", atualizado.getGenero());
        verify(repository).save(existente);
    }

    @Test
    void deveLancarExcecaoQuandoJogoNaoExiste() {
        Long id = 99L;
        AtualizarJogoRequestDTO dto = new AtualizarJogoRequestDTO("Nome", "Gênero", LocalDate.now(), 100.0, "PC");

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(JogoNaoEncontradoException.class, () -> service.atualizar(id, dto));
    }
}
