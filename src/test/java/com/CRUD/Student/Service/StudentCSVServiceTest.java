package com.CRUD.Student.Service;

import com.CRUD.Student.Entity.StudentCSVData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(StudentCSVImportService.class)
public class StudentCSVServiceTest {

    @Autowired
    StudentCSVImport studentCSVImport;

    @Autowired
    StudentCSVImportService studentCSVImportService;

    @Test
    void test1() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/studentdata.csv");
        List<?> l1 = studentCSVImportService.importCSVtoDB(file);
        l1.forEach(System.out::println);
    }
}
