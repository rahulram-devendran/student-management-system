package com.CRUD.Student.Repository;

import com.CRUD.Student.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Page<Student> findAllByNameIsLikeIgnoreCase(String name, Pageable pageable);
}
