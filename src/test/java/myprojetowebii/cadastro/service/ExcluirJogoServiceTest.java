package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExcluirJogoServiceTest {

    private final JogosRepository repository = mock(JogosRepository.class);
    private final ExcluirJogoService service = new ExcluirJogoService(repository);

    @Test
    void deveExcluirJogoExistente() {
        Jogo jogo = new Jogo(1L, "Zelda", "RPG", null, 100.0, "Switch");

        when(repository.findById(1L)).thenReturn(Optional.of(jogo));

        String mensagem = service.excluirJogoPorId(1L);

        assertTrue(mensagem.contains("foi excluído com sucesso"));
        verify(repository).delete(jogo);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrado() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(JogoNaoEncontradoException.class, () -> service.excluirJogoPorId(1L));
    }
}
