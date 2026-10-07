package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
     List<StudentDTO> getAllStudents();
     Optional<StudentDTO> getStudent(UUID id);
     StudentDTO createStudent(StudentDTO student);
     StudentDTO updateStudent(StudentDTO student,UUID id);
     void deleteStudent(UUID id);
}
