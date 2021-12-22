package zw.co.lws.livestockwebservice.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zw.co.lws.livestockwebservice.service.exceptions.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exceptions.ExceptionResponse;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(ex.getMessage());
        response.setTimeStamp(LocalDateTime.now());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ExceptionResponse> duplicateEntryException(DuplicateEntryException ex){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(ex.getMessage());
        response.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
