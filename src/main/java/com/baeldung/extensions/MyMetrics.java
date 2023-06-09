package com.baeldung.extensions;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyMetrics {
    private final Counter successfulRequestsTotal;
    private final Counter failedRequestsTotal;

    @Autowired
    public MyMetrics(MeterRegistry meterRegistry) {
        this.successfulRequestsTotal = meterRegistry.counter("successful_requests_total", "description", "Total number of successful requests");
        this.failedRequestsTotal = meterRegistry.counter("failed_requests_total", "description", "Total number of failed requests");
    }

    public void processSuccessfulRequest() {
        successfulRequestsTotal.increment();
        
        // Other logic for processing successful request
    }
    
    public void processFailedRequest() {
        failedRequestsTotal.increment();
        
        // Other logic for processing failed request
    }
}
