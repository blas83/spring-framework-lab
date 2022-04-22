package spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeDao {

    private List<String> employees = Collections.synchronizedList(new ArrayList<>());

    private DataSource dataSource;

    @Autowired
    public EmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveEmployee(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("insert into employees(emp_name) values (?)");
        ) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert", e);
        }
    }

    public List<String> listEmployees() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select emp_name from employees");
                ResultSet rs = ps.executeQuery();
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }

            return names;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot select", e);
        }
    }

}
