package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.CoursesDTO;
import com.CRUD.Student.Exception.CourseNotFoundException;
import com.CRUD.Student.Service.CoursesService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/courses")
@RestController
public class CoursesController {
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/find")
    public List<CoursesDTO> coursesList(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/find/{id}")
    public Optional<CoursesDTO> getCourseById(@PathVariable("id") UUID id){
        return coursesService.getCourse(id);
    }

    @PostMapping("/create")
    public ResponseEntity createCourse(@RequestBody CoursesDTO coursesDTO){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Course Name",coursesDTO.getName());
        coursesService.createCourse(coursesDTO);
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable("id") UUID id,
                                   @RequestBody CoursesDTO coursesDTO){
        if(coursesService.updateCourse(coursesDTO,id).isEmpty()){
            throw new RuntimeException();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") UUID id){
        coursesService.deleteStudent(id);
        return ResponseEntity.ok("Delete Successfully");
    }

}
