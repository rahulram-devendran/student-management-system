package com.CRUD.Student.Repository;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Entity.Student;
import com.CRUD.Student.Mapper.StudentMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
//@ActiveProfiles("mysqlp")
public class MySqlIT{

    @Container
    @ServiceConnection
    static MySQLContainer mySQLContainer =
            new MySQLContainer("mysql:9");

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DataSource dataSource;

    @Disabled
    @Test
    void testListStudents() {
        List<Student> students = studentRepository.findAll();
        assertThat(students.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void testsaveStudent() {
        StudentDTO studentDTO = StudentDTO.builder()
                .name("S12").mobileNumber("12345").department("D11").build();

        Student student = studentRepository.save(studentMapper.studentDTOtoStudent(studentDTO));
        assertThat(student.getName()).isEqualTo(studentDTO.getName());
    }
}
