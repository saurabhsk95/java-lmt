package com.baeldung.springbootlogging;

import com.baeldung.extensions.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.micrometer.core.instrument.MeterRegistry;



@SpringBootApplication
@ComponentScan(basePackages = "user.details")
@ComponentScan(basePackages = "com.baeldung.extensions")
public class SpringBootLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoggingApplication.class, args);
    }


    @Bean
    public ProcessMemoryMetrics processMemoryMetrics(MeterRegistry meterRegistry) {
        ProcessMemoryMetrics memoryMetrics = new ProcessMemoryMetrics(meterRegistry);
        memoryMetrics.registerMetrics();
        return memoryMetrics;
        
        
    }
    @Bean
    public SystemMetricsCollector systemMetricsCollector(MeterRegistry meterRegistry) {
    	SystemMetricsCollector memoryMetrics = new SystemMetricsCollector(meterRegistry);
        memoryMetrics.registerMetrics();
        return memoryMetrics;
    }
 	
    	
   
}
