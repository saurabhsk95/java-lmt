package user.details;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees;
    
   
   
  
    public EmployeeService() {
        // Initialize the list of hardcoded employees
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", "john@example.com",10000L));
        employees.add(new Employee(2L, "Jane Smith", "jane@example.com",20000L));
        employees.add(new Employee(3L, "Mike Johnson", "mike@example.com",30000L));
    }
    
   

    public Employee getEmployeeById(long id) {
        // Find the employee by ID in the list
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Return null if employee not found
    }
    public List<Employee> getAllEmployees() {
        return employees;
    }
    
    public String convertEmployeeToString(Employee employee) {
        return employee.toString();
    }
    
  
}
