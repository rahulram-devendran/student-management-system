package com.CRUD.Student.Mapper;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student studentDTOtoStudent(StudentDTO studentDTO);

    StudentDTO studenttoStudentDTO(Student student);
}
