package spring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class) // JUnit5 miatt elhagyható
//@ContextConfiguration(classes = AppConfig.class) // JUnit5-nél a lenti annotáció kell
@SpringJUnitConfig(AppConfig.class)
public class EmployeeServiceRunnerIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveThanList() {
        employeeService.saveEmployee("John Doe");
        assertEquals(List.of("John Doe"), employeeService.listEmployees());
    }
}
