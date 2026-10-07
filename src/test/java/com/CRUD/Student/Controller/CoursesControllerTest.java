package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.CoursesDTO;
import com.CRUD.Student.Entity.Courses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CoursesControllerTest {

    @Autowired
    CoursesController coursesController;

    @Test
    void Test1(){
        CoursesDTO c1 = CoursesDTO.builder().name("C1").author("CA1").build();
        coursesController.createCourse(c1);
        CoursesDTO coursesDTO = coursesController.coursesList().get(0);
        assertThat(coursesDTO.getName()).isEqualTo("ABC");
    }
}