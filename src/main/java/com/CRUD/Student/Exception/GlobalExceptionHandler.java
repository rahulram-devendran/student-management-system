package com.CRUD.Student.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundEnception.class)
    public ResponseEntity studentNotFoundEx(StudentNotFoundEnception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("Student-Name","Student Not Found")
                .body(e.getMessage());
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity courseNotFoundEx(CourseNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("Course-Name","Course Not Found")
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidEx(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldErrors());
    }

    @ExceptionHandler(AssertionError.class)
    public ResponseEntity assertionErrorEx(AssertionError ex){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()+"@@@");
    }
}
