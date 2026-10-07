package com.CRUD.Student.Mapper;

import com.CRUD.Student.DTO.CoursesDTO;
import com.CRUD.Student.Entity.Courses;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoursesMapper {
    Courses coursesDTOtoCourses(CoursesDTO coursesDTO);

    CoursesDTO coursestoCoursesDTO(Courses courses);
}
