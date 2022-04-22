package spring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.w3c.dom.css.Counter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class) // JUnit5 miatt elhagyható
//@ContextConfiguration(classes = AppConfig.class) // JUnit5-nél a lenti annotáció kell
@SpringJUnitConfig(AppConfig.class)
public class EmployeeServiceRunnerIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Employee2Service employee2Service;

    @Autowired
    private CounterAspect counterAspect;
    @Test
    public void testSaveThanList() {
        counterAspect.reset();
        employeeService.saveEmployee("John Doe");
        assertEquals(List.of("John Doe"), employeeService.listEmployees());

        employeeService.saveEmployee("John Doe2");
        assertEquals(List.of("John Doe", "John Doe2"), employeeService.listEmployees());

        employee2Service.saveEmployee("Jack Doe");
        assertEquals(List.of("Jack Doe"), employee2Service.listEmployees());

        assertEquals(2, counterAspect.getCounter());
    }
}
