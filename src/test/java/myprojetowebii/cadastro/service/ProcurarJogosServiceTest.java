package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcurarJogosServiceTest {

    private final JogosRepository repository = mock(JogosRepository.class);
    private final ProcurarJogosService service = new ProcurarJogosService(repository);

    @Test
    void deveRetornarTodosOsJogos() {
        Jogo jogo = new Jogo(1L, "Zelda", "Ação", LocalDate.now(), 100.0, "Switch");

        when(repository.findAll()).thenReturn(Arrays.asList(jogo));

        assertEquals(1, service.procurarTodosOsJogos().size());
    }

    @Test
    void deveBuscarPorId() {
        Jogo jogo = new Jogo(1L, "Zelda", "Ação", LocalDate.now(), 100.0, "Switch");

        when(repository.findById(1L)).thenReturn(Optional.of(jogo));

        Jogo resultado = service.procurarJogoPorId(1L);

        assertEquals("Zelda", resultado.getNome());
    }
}
