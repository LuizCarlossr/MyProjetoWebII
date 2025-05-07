package myprojetowebii.cadastro.controller;

import jakarta.validation.Valid;
import myprojetowebii.cadastro.dto.AdicionarJogoRequestDTO;
import myprojetowebii.cadastro.dto.AtualizarJogoRequestDTO;
import myprojetowebii.cadastro.dto.JogoDTO;
import myprojetowebii.cadastro.dto.mapper.AdicionarJogoRequestMapper;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.service.AdicionarJogoService;
import myprojetowebii.cadastro.service.AtualizarJogoService;
import myprojetowebii.cadastro.service.ExcluirJogoService;
import myprojetowebii.cadastro.service.ProcurarJogosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final AdicionarJogoService adicionarJogoService;
    private final ProcurarJogosService procurarJogosService;
    private final AtualizarJogoService atualizarJogoService;
    private final ExcluirJogoService excluirJogoService;

    public JogoController(AdicionarJogoService adicionarJogoService,
                          ProcurarJogosService procurarJogosService,
                          AtualizarJogoService atualizarJogoService,
                          ExcluirJogoService excluirJogoService) {
        this.adicionarJogoService = adicionarJogoService;
        this.procurarJogosService = procurarJogosService;
        this.atualizarJogoService = atualizarJogoService;
        this.excluirJogoService = excluirJogoService;
    }

    @PostMapping
    public ResponseEntity<Jogo> adicionarJogo(@RequestBody @Valid AdicionarJogoRequestDTO dto) {
        Jogo novoJogo = adicionarJogoService.adicionarJogo(AdicionarJogoRequestMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }

    @GetMapping
    public List<JogoDTO> procurarTodosOsJogos() {
        return procurarJogosService.procurarTodosOsJogos();
    }

    @GetMapping("/{id}")
    public Jogo procurarJogoPorId(@PathVariable (value = "id") Long id) {
        return procurarJogosService.procurarJogoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogo(@PathVariable Long id, @RequestBody @Valid AtualizarJogoRequestDTO dto) {
        Jogo jogoAtualizado = atualizarJogoService.atualizar(id, dto);
        return ResponseEntity.ok(jogoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirJogo(@PathVariable Long id) {
        String mensagem = excluirJogoService.excluirJogoPorId(id);
        return ResponseEntity.ok(mensagem);
    }
}
