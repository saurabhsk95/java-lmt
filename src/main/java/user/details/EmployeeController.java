package user.details;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Tracer tracer;

    @Autowired
    public EmployeeController(EmployeeService employeeService, Tracer tracer) {
        this.employeeService = employeeService;
        this.tracer = tracer;
    }

    @GetMapping("/list_user")
    public List<String> getAllEmployeeNames() {
        List<String> employeeNames = new ArrayList<>();
        List<Employee> employees = employeeService.getAllEmployees();

        for (Employee employee : employees) {
            employeeNames.add(employee.getName());
        }

        return employeeNames;
    }
    
    @GetMapping("/get_user/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        // Start a span
    	Span span = tracer.buildSpan("getEmployeeById").start();
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return employee != null ? employee.toString() : "Employee not found";
        } finally {
            span.finish();
        }
    }
    
    @GetMapping("/get_user_salary/{id}")
    public Employee getEmployeeSalaryById(@PathVariable long id) {
        // Start a span
        Span span = tracer.buildSpan("getEmployeeSalaryById").start();
        try {
            return employeeService.getEmployeeById(id);
        } finally {
            span.finish();
        }
    }
}
