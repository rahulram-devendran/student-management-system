package com.CRUD.Student.Repository;

import com.CRUD.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findAllByNameIsLikeIgnoreCase(String name);
}
