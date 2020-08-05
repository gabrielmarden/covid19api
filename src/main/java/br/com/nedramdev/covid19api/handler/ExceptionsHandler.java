package br.com.nedramdev.covid19api.handler;

import br.com.nedramdev.covid19api.dao.ErrorDAO;
import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ResourceNotFoundHandler(ResourceNotFoundException e){
        ErrorDAO error = new ErrorDAO("Resource not found exception",e.getMessage(), LocalDate.now());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
