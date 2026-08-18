package jdbc.sales.dao;

import jdbc.sales.entities.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
    private final Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Employee> selectAll() throws SQLException {
        if (conn == null) {
            return null;
        }

        String select = "select * from employees";
        ArrayList<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(select);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employee_id"));
                employee.setLastName(rs.getString("last_name"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setBirthdate(rs.getString("birth_date"));
                employee.setSupervisor(rs.getInt("supervisor_id"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        return employees;
    }

    public boolean insert(Employee employee) throws SQLException {
        if (conn == null) {
            return false;
        }

        String insert = "{call sp_add_employee(?, ?, ?, ?)}";

        int index = 1;
        try (CallableStatement cs = conn.prepareCall(insert)) {
            cs.setString(index++, employee.getLastName());
            cs.setString(index++, employee.getFirstName());
            cs.setString(index++, employee.getBirthdate());
            cs.setInt(index++, employee.getSupervisor());

            if (cs.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return false;
    }

    public boolean update(int id, Employee employee) throws SQLException {
        if (conn == null) {
            return false;
        }

        String update = "update employees set last_name = ?, first_name = ?, birth_date = ?, supervisor_id = ? where employee_id = ?";

        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(update)) {
            ps.setString(index++, employee.getLastName());
            ps.setString(index++, employee.getFirstName());
            ps.setString(index++, employee.getBirthdate());
            ps.setInt(index++, employee.getSupervisor());
            ps.setInt(index++, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return false;
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) {
            return false;
        }

        String delete = "delete from employees where employee_id = ?";

        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(delete)) {
            ps.setInt(index++, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return false;
    }
}
