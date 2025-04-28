package myprojetowebii.cadastro.controller;

import jakarta.validation.Valid;
import myprojetowebii.cadastro.dto.AdicionarJogoRequestDTO;
import myprojetowebii.cadastro.dto.mapper.AdicionarJogoRequestMapper;
import myprojetowebii.cadastro.model.Jogo;
import myprojetowebii.cadastro.service.AdicionarJogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private final AdicionarJogoService adicionarJogoService;

    public JogoController(AdicionarJogoService adicionarJogoService) {
        this.adicionarJogoService = adicionarJogoService;
    }

    @PostMapping
    public ResponseEntity<Jogo> adicionarJogo(@RequestBody @Valid AdicionarJogoRequestDTO dto) {
        Jogo novoJogo = adicionarJogoService.adicionarJogo(AdicionarJogoRequestMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }
}
