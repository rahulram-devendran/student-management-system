package com.CRUD.Student.Controller;

import com.CRUD.Student.DTO.StudentDTO;
import com.CRUD.Student.Service.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(studentController.class)
class studentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    studentController studentController;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    StudentService studentService;

    @Disabled
    @Test
    void testCreateStudent() throws Exception {
        StudentDTO studentDTO = StudentDTO.builder().name(null)
                .department("d9")
                .mobileNumber("9234323454323456786543234567").build();

        mockMvc.perform(
                post("/student/create")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO))
        ).andExpect(status().isCreated());
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/student/find")
                .param("studentName","S"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}