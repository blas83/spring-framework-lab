package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeDao employeeDao() {
        System.out.println("employeeDao");
        return new EmployeeDao();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService(employeeDao());
    }
}
