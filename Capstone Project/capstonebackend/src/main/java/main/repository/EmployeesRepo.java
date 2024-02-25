package main.repository;

import main.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeesRepo extends the JpaRepository and has access to the default CRUD methods
 */
@Repository
public interface EmployeesRepo extends JpaRepository<Employees, String>{
}
