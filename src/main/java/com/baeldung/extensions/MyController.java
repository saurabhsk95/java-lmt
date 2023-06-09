package com.baeldung.extensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyMetrics myMetrics;

    @Autowired
    public MyController(MyMetrics myMetrics) {
        this.myMetrics = myMetrics;
    }

    @GetMapping("/test")
    public String myEndpoint() {
   
            myMetrics.processSuccessfulRequest();
            
            return "Endpoint response";
    }
    
    
    @GetMapping("/failure")
    public String failure() {
   
    	 myMetrics.processFailedRequest();
            
            return "Endpoint response";
    }
      
    }


