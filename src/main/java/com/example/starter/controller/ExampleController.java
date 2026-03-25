package com.example.starter.controller;

import com.example.starter.model.request.ExampleRequest;
import com.example.starter.model.response.ExampleResponse;
import com.example.starter.service.ExampleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/example")
    @ResponseStatus(HttpStatus.OK)
    public ExampleResponse process(@Valid @RequestBody ExampleRequest request) {
        return exampleService.process(request);
    }
}

