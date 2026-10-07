package com.CRUD.Student.Repository;

import com.CRUD.Student.Entity.Student;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

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

    @Test
    void colTest(){
        assertThrows(ConstraintViolationException.class,()->{
            studentRepository.save(Student.builder()
                    .name("s1")
                    .mobileNumber("123456712345678901234567891234567890")
                    .department("d1").build());

            studentRepository.flush();
        });
    }
}