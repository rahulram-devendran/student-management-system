package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/student")
@RestController
public class studentController {
    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/find")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/find/{id}")
    public Optional<StudentDTO> getStudent(@PathVariable("id") UUID id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/create")
    public ResponseEntity createStudent(@Valid @RequestBody StudentDTO student) {
        StudentDTO studentDTO = studentService.createStudent(student);
        HttpHeaders http = new org.springframework.http.HttpHeaders();
        http.add("Location"
                , studentDTO.getName() + " id= " + studentDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Student "+studentDTO.getName()+" added Successfully");
    }

    @PutMapping("/update/{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO student, @PathVariable("id") UUID id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudent(id);
    }
}