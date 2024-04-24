package com.dev.school.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dev.school.model.Student;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    
    @BeforeEach
    private void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    
    @Test
    @WithMockUser("you")
    void testDelete() throws Exception  {
        mockMvc.perform(get("/student/delete/0001"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/student/list"));

    }

    @Test
    @WithMockUser("you")
    void testDisplayAddForm() throws Exception {
        mockMvc.perform(get("/student/add"))
        .andExpect(status().isOk());
       // .andExpect(content().string(containsString("Laurent")));
    }


    @Test
    @WithMockUser("you")
    void testDisplayUpdateForm() throws Exception {
        mockMvc.perform(get("/student/update/001"))
        .andExpect(status().isOk())
        .andExpect(view().name("student/update"));
    }

    @Test
    @WithMockUser("you")
    void testList() throws Exception {
        mockMvc.perform(get("/student/list"))
        .andExpect(status().isOk());
    }

    @Test
    @WithMockUser("you")
    void testProcessAdd() throws Exception {
        Student student = new Student();
        student.setFirstName("firstName");
        student.setLastName("lastName");
        student.setRegistrationNumber("002");
       
        mockMvc.perform(post("/student/add")
        .flashAttr("student", student))
        //.andExpect(status().isFound())
        .andExpect(redirectedUrl("/student/list"));
    }

    @Test
    @WithMockUser("you")
    void testProcessUpdate() {

    }
}
