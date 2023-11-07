package guru.springfamework.controllers.v1;

import guru.springfamework.services.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Gestion des exceptions

@ControllerAdvice // gérer les exceptions générées dans les contrôleurs de l'application.
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class}) // appelée lorsque l'exception ResourceNotFoundException est levée
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>("Resource not found",new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
