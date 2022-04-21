package spring.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDao {

    private List<String> employees = Collections.synchronizedList(new ArrayList<>());

    private EmployeeService employeeService;

    public EmployeeDao() {
        System.out.println("EmployeeDao constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }

    public void saveEmployee(String name) {
        employees.add(name);
    }

    public List<String> listEmployees() {
        return new ArrayList<>(employees);
    }
}
