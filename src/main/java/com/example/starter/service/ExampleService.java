package com.example.starter.service;

import com.example.starter.model.request.ExampleRequest;
import com.example.starter.model.response.ExampleResponse;

public interface ExampleService {

    ExampleResponse process(ExampleRequest request);
}

