package myprojetowebii.cadastro.config;

import myprojetowebii.cadastro.exception.JogoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceRest {

    @ExceptionHandler({JogoNaoEncontradoException.class})
    public ResponseEntity<Void> handlerJogoNaoEncontradoException(JogoNaoEncontradoException ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.notFound().build();
    }
}
