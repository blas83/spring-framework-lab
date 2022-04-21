package spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    private ApplicationEventPublisher applicationEventPublisher;

    public EmployeeService(EmployeeDao employeeDao) {
        System.out.println("EmployeeService constructor: " + employeeDao);
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name) {
        String trimmedName = name.trim();

        if (applicationEventPublisher != null) {
            System.out.println("applicationEventPublisher van.");
            EmployeeHasCreatedEvent event = new EmployeeHasCreatedEvent(this, name);
            applicationEventPublisher.publishEvent(event);
        } else {
            System.out.println("Valamiért nem találja.");
        }
        employeeDao.saveEmployee(trimmedName);
    }

    public List<String> listEmployees() {
        return employeeDao.listEmployees();
    }

    @Autowired(required = false)
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
