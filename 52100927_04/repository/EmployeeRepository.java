package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.Employee;
import model.table.EmployeeTable;

public class EmployeeRepository {

    public Employee login(String username, String password) {

        File file = new File("../resources/employee.ser");

        FileInputStream f = null;

        if (!file.exists())
            return null;

        EmployeeTable employeeTable = null;

        try {
            f = new FileInputStream("../resources/employee.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            employeeTable = (EmployeeTable) in.readObject();

            in.close();
            f.close();

        } catch (Exception e) {

            return null;

        }

        if (employeeTable == null)
            return null;

        ArrayList<Employee> employees = employeeTable.getEmployees();

        if (employees == null)
            return null;

        for (Employee employee : employees) {
            if (employee.getUsername().equals(username)) {
                if (employee.getPassword().equals(password)) {
                    return employee;
                }
            }
        }

        return null;

    }

}
