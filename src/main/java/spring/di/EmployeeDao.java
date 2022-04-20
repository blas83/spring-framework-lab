package spring.di;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDao {

    private List<String> employees = Collections.synchronizedList(new ArrayList<>());

    public void saveEmployee(String name) {
        employees.add(name);
    }

    public List<String> listEmployees() {
        return new ArrayList<>(employees);
    }
}
