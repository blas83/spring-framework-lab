package spring.di;

import org.springframework.context.annotation.*;

@Configuration
//@Lazy
public class AppConfig {

    @Bean
    public InitBean initBean() {
        return new InitBean();
    }

//    @Bean(initMethod = "init")
    @Bean
    @DependsOn("initBean")
    @Scope("prototype")
    public EmployeeDao employeeDao() {
        System.out.println("employeeDao");
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.init();
//        return employeeDao;
        return new EmployeeDao();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService(employeeDao());
    }

    @Bean
    public Employee2Service employee2Service() {
        return new Employee2Service(employeeDao());
    }
}
