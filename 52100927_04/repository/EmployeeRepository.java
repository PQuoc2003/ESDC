package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Employee;
import model.Role;
import model.table.EmployeeTable;

public class EmployeeRepository {

    public Employee login(String username, String password) {

        File file = new File("resources/employee.ser");

        FileInputStream f = null;

        // If not existed file so we create new one with default user
        if (!file.exists())

            try {

                FileOutputStream f1 = new FileOutputStream("resources/employee.ser");
                ObjectOutputStream out = new ObjectOutputStream(f1);

                Employee manager = new Employee("Quoc", "123", Role.ROlE_MANAGER);
                Employee receptionist = new Employee("San", "1234", Role.ROLE_RECEPTIONIST);

                EmployeeTable employeeTable = new EmployeeTable();

                employeeTable.addEmployee(manager);
                employeeTable.addEmployee(receptionist);

                out.writeObject(employeeTable);

                out.close();
                f1.close();

            } catch (Exception e) {
                System.out.println(e.toString());
            }

        EmployeeTable employeeTable = null;

        try {
            f = new FileInputStream("resources/employee.ser");
            ObjectInputStream in = new ObjectInputStream(f);

            employeeTable = (EmployeeTable) in.readObject();

            in.close();
            f.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;

        }

        if (employeeTable == null) {
            return null;
        }

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
