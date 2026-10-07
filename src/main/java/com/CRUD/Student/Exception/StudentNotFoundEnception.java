package com.CRUD.Student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentNotFoundEnception extends RuntimeException{
    public StudentNotFoundEnception(String msg) {
        super(msg);
    }
}

