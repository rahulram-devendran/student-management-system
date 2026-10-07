package com.CRUD.Student.Repository;

import com.CRUD.Student.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Courses, UUID> {
}
