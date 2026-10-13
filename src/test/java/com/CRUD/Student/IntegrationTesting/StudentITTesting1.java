package com.CRUD.Student.IntegrationTesting;

import com.CRUD.Student.Controller.studentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentITTesting1 {

    @Autowired
    studentController studentController;
    @Autowired
    MockMvc mockMvc;

    @Test
    void Test1() throws Exception {
        mockMvc.perform(get("/student/find"))
                .andExpect(jsonPath("$.size()",is(1984)));
    }
}
