package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private Environment environment;

    @Autowired
    public HelloController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/")
    public String getMessage() {
        String message = environment.getProperty("message");
        return String.format("Message: %s", message);
    }

    @RequestMapping("/sample")
    public ResponseEntity<SampleResponse> getSample() {
        SampleResponse sample = new SampleResponse();
        return ResponseEntity.status(HttpStatus.OK).body(sample);
    }

    @RequestMapping("/sample/{count}")
    public ResponseEntity<List<SampleResponse>> getSamples(@PathVariable("count") int sampleCount) {
        List<SampleResponse> sampleResponses = new ArrayList<>();
        for (int i = 0; i < sampleCount; i++) {
            sampleResponses.add(new SampleResponse());
        }
        return ResponseEntity.status(HttpStatus.OK).body(sampleResponses);
    }

    @RequestMapping("/oops")
    public ResponseEntity<SampleResponse> getError() {
        SampleResponse sample = new SampleResponse();
        if (sample != null) {
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(sample);
    }
}
