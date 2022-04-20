package spring.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

//    private EmployeeDao employeeDao = mock(EmployeeDao.class);
//
//    private EmployeeService employeeService = new EmployeeService(employeeDao);

    @Test
    public void testSaveEmployee() {
        employeeService.saveEmployee(" John Doe ");
        verify(employeeDao).saveEmployee("John Doe");
    }
}
