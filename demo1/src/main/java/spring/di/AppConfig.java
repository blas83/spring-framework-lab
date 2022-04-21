package spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
//@Lazy
@PropertySource("classpath:/application.properties")
public class AppConfig {

    @Bean
    public InitBean initBean() {
        return new InitBean();
    }

    @Autowired
    private Environment environment;

    @Bean
    public String applicationVersion() {
        String version = environment.getProperty("application.version");
        System.out.println("Version: " + version);
        System.out.println("OS: " + environment.getProperty("OS")); //windows környezeti változó
        return version;
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
    public LoggerService loggerService() {
        return new LoggerService();
    }

    @Bean
    public Employee2Service employee2Service() {
        return new Employee2Service(employeeDao());
    }
}
