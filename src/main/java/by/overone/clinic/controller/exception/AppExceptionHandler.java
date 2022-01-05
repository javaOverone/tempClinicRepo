package by.overone.clinic.controller.exception;

import by.overone.clinic.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> entityNotFoundHandler(EntityNotFoundException e){
        ExceptionResponse response = new ExceptionResponse();
        response.setException(e.getClass().getName());
        response.setErrorCode(e.getMessage());
        String message="";
        switch (e.getMessage()){
            case "4000": message="User not found";
            break;
            case "4001": message="Pet not found";
            break;
        }
        response.setMessage(message);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionResponse> sqlExceptionHandler(SQLException e){
        ExceptionResponse response = new ExceptionResponse();
        response.setException(e.getClass().getSimpleName());
        response.setErrorCode("5001");
        response.setMessage("Oops BD exception. ");
        log.error("SQL EXCEPTION: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }

}
