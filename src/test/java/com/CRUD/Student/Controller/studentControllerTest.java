package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.StudentDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

@Transactional
@Rollback
@SpringBootTest
@AutoConfigureMockMvc
class studentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    studentController studentController;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testCreateStudent() throws Exception {
        StudentDTO studentDTO = StudentDTO.builder().name(null)
                .studentDepartment("d9")
                .mobileNumber("9234323454323456786543234567").build();

        mockMvc.perform(
                post("/student/create")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO))
        ).andExpect(status().isCreated());
    }
}