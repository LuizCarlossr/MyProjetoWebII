package myprojetowebii.cadastro.service;

import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.repository.JogosRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

public class AdicionarJogoServiceTest {

    private final JogosRepository repository = mock(JogosRepository.class);
    private final AdicionarJogoService service = new AdicionarJogoService(repository);

    @Test
    void deveAdicionarJogoComSucesso() {
        Jogo jogo = new Jogo(null, "Zelda", "Aventura", LocalDate.now(), 199.9, "Switch");
        Jogo salvo = new Jogo(1L, "Zelda", "Aventura", LocalDate.now(), 199.9, "Switch");

        when(repository.save(jogo)).thenReturn(salvo);

        Jogo resultado = service.adicionarJogo(jogo);

        assertNotNull(resultado.getId());
        assertEquals("Zelda", resultado.getNome());
        verify(repository, times(1)).save(jogo);
    }
}
