package com.example.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private Environment environment;

    @Autowired
    public HelloController(Environment environment) {
        this.environment = environment;
    }

    @LogExecutionTime
    @RequestMapping("/")
    public String getMessage() {
        String message = environment.getProperty("message");
        return String.format("Message: %s", message);
    }

    @LogExecutionTime
    @RequestMapping("/sample")
    public ResponseEntity<SampleResponse> getSample() {
        SampleResponse sample = new SampleResponse();
        sample.
        return ResponseEntity.status(HttpStatus.OK).body(sample);
    }

    @LogExecutionTime
    @RequestMapping("/sample/{count}")
    public ResponseEntity<List<SampleResponse>> getSamples(@PathVariable("count") int sampleCount) {
        List<SampleResponse> sampleResponses = new ArrayList<>();
        for (int i = 0; i < sampleCount; i++) {
            sampleResponses.add(new SampleResponse());
        }
        return ResponseEntity.status(HttpStatus.OK).body(sampleResponses);
    }

    @LogExecutionTime
    @RequestMapping("/oops")
    public ResponseEntity<SampleResponse> getError() {
        SampleResponse sample = new SampleResponse();
        if (sample != null) {
            throw new RuntimeException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(sample);
    }

    @LogExecutionTime
    @RequestMapping(method = RequestMethod.POST, value = "/logger")
    public void postLog(@RequestBody String logEntry) {
        logger.info(logEntry);
    }
}
