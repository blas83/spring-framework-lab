package spring.di;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeDaoTest {

    private EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void testSaveThanList() {
        employeeDao.saveEmployee("John Doe");
        assertEquals(List.of("John Doe"), employeeDao.listEmployees());
    }
}
