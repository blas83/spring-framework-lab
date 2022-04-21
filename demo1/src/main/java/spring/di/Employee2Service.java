package spring.di;

import java.util.List;

public class Employee2Service {

    EmployeeDao employeeDao;

    public Employee2Service(EmployeeDao employeeDao) {
        System.out.println("Employee2Service constructor: " + employeeDao);
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name) {
        employeeDao.saveEmployee(name);
    }

    public List<String> listEmployees() {
        return employeeDao.listEmployees();
    }
}
