package spring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/clear.sql")
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveThenList() {
        employeeDao.saveEmployee("John Doe");
        List<String> names = employeeDao.listEmployees();

        assertEquals(List.of("John Doe"), names);
    }
}
