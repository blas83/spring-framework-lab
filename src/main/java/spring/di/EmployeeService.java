package spring.di;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name) {
        String trimmedName = name.trim();
        employeeDao.saveEmployee(trimmedName);
    }

    public List<String> listEmployees() {
        return employeeDao.listEmployees();
    }
}
