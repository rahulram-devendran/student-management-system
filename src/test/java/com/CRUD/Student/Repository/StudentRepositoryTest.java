package com.CRUD.Student.Repository;

import com.CRUD.Student.Entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DataSource dataSource;

    @Test
    void test() {
        Student s1 = Student.builder()
                .name(null)
                .department("SD112345432345654323456434565432345676543456787654")
                .mobileNumber("1234567")
                .build();

        studentRepository.save(s1);
        studentRepository.flush();

        assertThat(s1).isNotNull();
    }
}