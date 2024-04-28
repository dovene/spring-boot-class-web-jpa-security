package com.dev.school.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test-application.properties")
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    private void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    void testDisplayAddForm_shouldReturnUnAuthenticatedError() throws Exception {
        mockMvc.perform(get("/student/add"))
                .andExpect(unauthenticated());
    }

    @Test
    @WithMockUser("user")
    void testDisplayAddForm() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/student/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("student")).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Nouvel étudiant"));
    }

    @Test
    @WithMockUser("user")
    void testProcessAdd() throws Exception {
        String formData = "registrationNumber=001&firstName=testFirstName&lastName=testLastName";
        RequestBuilder request = post("/student/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(formData)
                .with(csrf());
        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/student/list"));
    }

    @Test
    @WithMockUser("user")
    void testDisplayUpdateForm() throws Exception {
        mockMvc.perform(get("/student/update/001"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/update"));
    }

    @Test
    @WithMockUser("user")
    void testDelete() throws Exception {
        mockMvc.perform(get("/student/delete/001"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/student/list"));

    }

    @Test
    @WithMockUser("user")
    void testList() throws Exception {
        mockMvc.perform(get("/student/list"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser("user")
    void testProcessUpdate() throws Exception {
        String updateFormData = "registrationNumber=sdgfd&firstName=updated&lastName=updated";
        RequestBuilder requestUpdate = post("/student/update")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(updateFormData)
                .with(csrf());
        mockMvc.perform(requestUpdate)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/student/list"));
    }
}
