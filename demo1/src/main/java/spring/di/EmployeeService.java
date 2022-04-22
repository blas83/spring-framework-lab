package spring.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

public class EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private EmployeeDao employeeDao;

    private ApplicationEventPublisher applicationEventPublisher;

    public EmployeeService(EmployeeDao employeeDao) {
        logger.info("EmployeeService constructor: " + employeeDao);
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name) {
        String trimmedName = name.trim();

        if (applicationEventPublisher != null) {
            logger.info("applicationEventPublisher van.");
            EmployeeHasCreatedEvent event = new EmployeeHasCreatedEvent(this, name);
            applicationEventPublisher.publishEvent(event);
        } else {
            logger.info("Valamiért nem találja.");
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
