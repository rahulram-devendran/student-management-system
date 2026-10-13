package com.CRUD.Student.Entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCSVData {
    @CsvBindByName(column = "school")
    private String schoolName;

    @CsvBindByName(column = "sex")
    private String gender;

    @CsvBindByName(column = "age")
    private Integer age;

    @CsvBindByName(column = "address")
    private String address;
}
