package com.CRUD.Student.Service;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Entity.Student;
import com.CRUD.Student.Exception.StudentNotFoundEnception;
import com.CRUD.Student.Mapper.StudentMapper;
import com.CRUD.Student.Repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::studenttoStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getStudent(UUID id) {
        return Optional.of(studentMapper
                .studenttoStudentDTO(studentRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new StudentNotFoundEnception("Student " + id + " not found")
                        )));
    }

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        return studentMapper
                .studenttoStudentDTO(
                        studentRepository.save(studentMapper.studentDTOtoStudent(student)));
    }

    @Override
    public StudentDTO updateStudent(StudentDTO student, UUID id) {
        Student student1 = studentRepository
                .findById(id)
                .orElseThrow(()->new StudentNotFoundEnception("" +
                "Student "+id+" not Found"));

        student1.setName(student.getName());
        student1.setMobileNumber(student.getMobileNumber());
        student1.setDepartment(student.getStudentDepartment());

        Student updatedStudent = studentRepository.save(student1);
        return studentMapper.studenttoStudentDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(UUID id) {
        Student student1 = studentRepository
                .findById(id)
                .orElseThrow(()->new StudentNotFoundEnception("" +
                        "Student "+id+" not Found"));

        studentRepository.delete(student1);
    }
}