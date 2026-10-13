package com.CRUD.Student.Service;

import com.CRUD.Student.Entity.Student;
import com.CRUD.Student.Entity.StudentCSVData;
import com.CRUD.Student.Repository.StudentRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class StudentCSVImportService implements StudentCSVImport{
    private final StudentRepository studentRepository;

    public StudentCSVImportService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentCSVData> convertCSVData(File csvf){
        try(FileReader fileReader = new FileReader(csvf)){
            return new CsvToBeanBuilder<StudentCSVData>(fileReader)
                    .withType(StudentCSVData.class)
                    .build().parse();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Student> importCSVtoDB(File csv){
        List<StudentCSVData> csvData = convertCSVData(csv);
        List<Student> studentList = csvData.stream()
                .map(d ->
                        Student.builder()
                                .department(d.getSchoolName())
                                .name(d.getAge()+"").build())
                .toList();

        return studentRepository.saveAll(studentList);
    }
}
