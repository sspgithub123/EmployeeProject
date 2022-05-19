package com.example.employeeproject.exceptionHandling;

import com.example.employeeproject.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(EmployeeException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while parsing Rest request",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}