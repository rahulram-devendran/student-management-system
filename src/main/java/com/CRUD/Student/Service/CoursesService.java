package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.CoursesDTO;
import com.CRUD.Student.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoursesService {
    List<CoursesDTO> getAllCourses();
    Optional<CoursesDTO> getCourse(UUID id);
    CoursesDTO createCourse(CoursesDTO course);
    Optional<CoursesDTO> updateCourse(CoursesDTO course,UUID id);
    void deleteStudent(UUID id);
}
