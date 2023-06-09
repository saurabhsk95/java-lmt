package com.baeldung.extensions;

import io.opentracing.Span;
import io.opentracing.Tracer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final Tracer tracer;

    @Autowired
    public GreetingService(Tracer tracer) {
        this.tracer = tracer;
    }

    public String greet(String name) {
        // Start a span
        Span span = tracer.buildSpan("greeting").start();
        try {
            // Generate the greeting message
            String greeting = "Hello, " + name + "!";
            return greeting;
        } finally {
            span.finish();
        }
    }
}

