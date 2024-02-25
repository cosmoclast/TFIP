package jpa_demo_01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeTest {
    
    static final String DBNAME = "test2";
    
    public static void main(String[] args) {
        // overriding the existing properties in persistence.xml
        Map<String,String> persistenceMap = new HashMap<String, String>();
        persistenceMap.put("jakarta.persistence.jdbc.url", 
                "jdbc:mariadb://localhost:3306/"+DBNAME);
        
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("EmployeeService", persistenceMap);
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeService(em);

        //  create and persist an employee
        em.getTransaction().begin();
        Employee emp = service.createEmployee(159, "John Doe 2", 45999);
        em.getTransaction().commit();
        System.out.println("Persisted " + emp);
//
//        // find a specific employee
//        emp = service.findEmployee(158);
//        System.out.println("Found " + emp);

        // find all employees
        List<Employee> emps = service.findAllEmployees();
        for (Employee e : emps)
            System.out.println("Found employee: " + e);

        // update the employee
//        em.getTransaction().begin();
//        emp = service.raiseEmployeeSalary(158, 1000);
//        em.getTransaction().commit();
//        System.out.println("Updated " + emp);
//
//        // remove an employee
//        em.getTransaction().begin();
//        service.removeEmployee(158);
//        em.getTransaction().commit();
//        System.out.println("Removed Employee 158");

        // close the EM and EMF when done
        em.close();
        emf.close();
    }
}
