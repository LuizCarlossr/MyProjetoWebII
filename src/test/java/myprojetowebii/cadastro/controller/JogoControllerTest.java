package myprojetowebii.cadastro.controller;

import myprojetowebii.cadastro.dto.AdicionarJogoRequestDTO;
import myprojetowebii.cadastro.dto.AtualizarJogoRequestDTO;
import myprojetowebii.cadastro.dto.JogoDTO;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.service.AdicionarJogoService;
import myprojetowebii.cadastro.service.AtualizarJogoService;
import myprojetowebii.cadastro.service.ExcluirJogoService;
import myprojetowebii.cadastro.service.ProcurarJogosService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JogoControllerTest {

    private AdicionarJogoService adicionarJogoService;
    private ProcurarJogosService procurarJogosService;
    private AtualizarJogoService atualizarJogoService;
    private ExcluirJogoService excluirJogoService;
    private JogoController jogoController;

    @BeforeEach
    public void setUp() {
        adicionarJogoService = Mockito.mock(AdicionarJogoService.class);
        procurarJogosService = Mockito.mock(ProcurarJogosService.class);
        atualizarJogoService = Mockito.mock(AtualizarJogoService.class);
        excluirJogoService = Mockito.mock(ExcluirJogoService.class);

        jogoController = new JogoController(adicionarJogoService, procurarJogosService,atualizarJogoService,excluirJogoService);
    }
    @Test
    public void deveAdicionarJogo() {
        AdicionarJogoRequestDTO dto = new AdicionarJogoRequestDTO();
        dto.setNome("Super Mario Odyssey");
        dto.setGenero("Aventura");

        Jogo jogo = new Jogo();
        jogo.setId(1L);
        jogo.setNome("Super Mario Odyssey");
        jogo.setGenero("Aventura");

        when(adicionarJogoService.adicionarJogo(any())).thenReturn(jogo);

        ResponseEntity<Jogo> response = jogoController.adicionarJogo(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(jogo, response.getBody());
        verify(adicionarJogoService, times(1)).adicionarJogo(any());
    }

    @Test
    public void deveRetornarTodosOsJogos() {
        JogoDTO jogoDTO = new JogoDTO();
        jogoDTO.setId(1L);
        jogoDTO.setNome("Super Mario Odyssey");
        jogoDTO.setGenero("Aventura");

        List<JogoDTO> lista = Arrays.asList(jogoDTO);
        when(procurarJogosService.procurarTodosOsJogos()).thenReturn(lista);

        List<JogoDTO> resposta = jogoController.procurarTodosOsJogos();

        assertEquals(1, resposta.size());
        assertEquals("Super Mario Odyssey", resposta.get(0).getNome());
        verify(procurarJogosService, times(1)).procurarTodosOsJogos();
    }

    @Test
    public void deveRetornarJogoPorId() {
        Jogo jogo = new Jogo();
        jogo.setId(1L);
        jogo.setNome("Bloodborne");
        jogo.setGenero("RPG de Ação");

        when(procurarJogosService.procurarJogoPorId(1L)).thenReturn(jogo);

        Jogo resposta = jogoController.procurarJogoPorId(1L);

        assertEquals("Bloodborne", resposta.getNome());
        verify(procurarJogosService, times(1)).procurarJogoPorId(1L);
    }

    @Test
    public void deveAtualizarJogo() {
        AtualizarJogoRequestDTO dto = new AtualizarJogoRequestDTO();
        dto.setNome("Nome Atualizado");
        dto.setGenero("Categoria Atualizada");

        Jogo jogoAtualizado = new Jogo();
        jogoAtualizado.setId(1L);
        jogoAtualizado.setNome("Nome Atualizado");
        jogoAtualizado.setGenero("Categoria Atualizada");

        when(atualizarJogoService.atualizar(eq(1L), eq(dto))).thenReturn(jogoAtualizado);

        ResponseEntity<Jogo> response = jogoController.atualizarJogo(1L, dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nome Atualizado", response.getBody().getNome());
    }

    @Test
    public void deveExcluirJogo() {
        when(excluirJogoService.excluirJogoPorId(1L)).thenReturn("Jogo excluído com sucesso");

        ResponseEntity<String> response = jogoController.excluirJogo(1L);

        assertEquals("Jogo excluído com sucesso", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(excluirJogoService).excluirJogoPorId(1L);
    }
}
