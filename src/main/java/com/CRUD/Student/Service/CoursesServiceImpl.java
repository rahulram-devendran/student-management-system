package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.CoursesDTO;
import com.CRUD.Student.Entity.Courses;
import com.CRUD.Student.Exception.CourseNotFoundException;
import com.CRUD.Student.Mapper.CoursesMapper;
import com.CRUD.Student.Repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;
    private final CoursesMapper coursesMapper;

    public CoursesServiceImpl(CoursesRepository coursesRepository, CoursesMapper coursesMapper) {
        this.coursesRepository = coursesRepository;
        this.coursesMapper = coursesMapper;
    }

    @Override
    public List<CoursesDTO> getAllCourses() {
        return coursesRepository.findAll().stream().map(coursesMapper::coursestoCoursesDTO).toList();
    }

    @Override
    public Optional<CoursesDTO> getCourse(UUID id) {
        return Optional.of(coursesMapper.coursestoCoursesDTO(coursesRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course " + id + " not found"))));
    }

    @Override
    public CoursesDTO createCourse(CoursesDTO course) {
        return coursesMapper.coursestoCoursesDTO(coursesRepository.save(coursesMapper.coursesDTOtoCourses(course)));
    }

    @Override
    public Optional<CoursesDTO> updateCourse(CoursesDTO course, UUID id) {
        AtomicReference<Optional<CoursesDTO>> ar = new AtomicReference<>();

        coursesRepository.findById(id).ifPresentOrElse(fc -> {
            fc.setName(course.getName());
            fc.setAuthor(course.getAuthor());
            ar.set(Optional.of(
                    coursesMapper.coursestoCoursesDTO(coursesRepository.save(fc))));
        }, () -> {
            ar.set(Optional.empty());
        });

        return ar.get();
    }

    @Override
    public void deleteStudent(UUID id) {
        Courses course = coursesRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course " + id + " not found"));

        coursesRepository.delete(course);
    }
}
