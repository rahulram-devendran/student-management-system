package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
     List<StudentDTO> getAllStudents(String studentName);
     Optional<StudentDTO> getStudent(UUID id);
     StudentDTO createStudent(StudentDTO student);
     StudentDTO updateStudent(StudentDTO student,UUID id);
     void deleteStudent(UUID id);
}
