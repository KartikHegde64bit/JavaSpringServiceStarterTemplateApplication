package com.example.starter.service;

import com.example.starter.model.request.ExampleRequest;
import com.example.starter.model.response.ExampleResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public ExampleResponse process(ExampleRequest request) {
        return new ExampleResponse("SUCCESS", UUID.randomUUID().toString());
    }
}

