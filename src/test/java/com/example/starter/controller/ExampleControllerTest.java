package com.example.starter.controller;

import com.example.starter.model.request.ExampleRequest;
import com.example.starter.model.response.ExampleResponse;
import com.example.starter.service.ExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExampleController.class)
class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ExampleService exampleService;

    @Test
    void shouldProcessExampleRequest() throws Exception {
        given(exampleService.process(any(ExampleRequest.class)))
                .willReturn(new ExampleResponse("SUCCESS", "123e4567-e89b-12d3-a456-426614174000"));

        ExampleRequest request = new ExampleRequest("123", 42);

        mockMvc.perform(post("/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.requestId").value("123e4567-e89b-12d3-a456-426614174000"));
    }

    @Test
    void shouldRejectInvalidExampleRequest() throws Exception {
        mockMvc.perform(post("/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":\"\",\"value\":42}"))
                .andExpect(status().isBadRequest());
    }
}

