package jpa_demo_01;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    @Id private int id;
    private String name;
    private double salary;

    public Employee() {}
    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    public void setSalary (double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return String.format("Id: %s, Name: %s, Salary: %.2f",
                this.id, this.name, this.salary);
    }
}
