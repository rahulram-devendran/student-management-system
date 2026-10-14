package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface StudentService {
     Page<StudentDTO> getAllStudents(String studentName,
                                     Integer pageNumber,
                                     Integer pageSize);
     Optional<StudentDTO> getStudent(UUID id);
     StudentDTO createStudent(StudentDTO student);
     StudentDTO updateStudent(StudentDTO student,UUID id);
     void deleteStudent(UUID id);
}
