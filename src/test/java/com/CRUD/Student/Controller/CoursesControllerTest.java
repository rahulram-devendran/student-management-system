package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.CoursesDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Disabled
class CoursesControllerTest {

    @Autowired
    CoursesController coursesController;

    @Test
    void Test1() {
        CoursesDTO c1 = CoursesDTO.builder().name("C1").author("CA1").build();
        coursesController.createCourse(c1);
        CoursesDTO coursesDTO = coursesController.coursesList().get(0);
        assertThat(coursesDTO.getName()).isEqualTo("ABC");
    }
}