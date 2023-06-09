package user.details;

public class Employee {
    private Long id;
    private String name;
    private String email;
    private Long salary;
    
    
    
	public Employee(Long id, String name, String email, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public Employee(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	  public String toString() {
	        return "Employee{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }

    

    // Constructors, getters, and setters
}