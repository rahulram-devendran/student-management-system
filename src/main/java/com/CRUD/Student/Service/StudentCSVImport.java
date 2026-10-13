package com.CRUD.Student.Service;

import com.CRUD.Student.Entity.StudentCSVData;

import java.io.File;
import java.util.List;

public interface StudentCSVImport {
    List<StudentCSVData> convertCSVData(File csvf);
}
