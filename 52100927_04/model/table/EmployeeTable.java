package model.table;

import java.io.Serializable;
import java.util.ArrayList;

import model.Employee;

public class EmployeeTable implements Serializable{
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(String username, String password) {

        for (Employee employee : this.employees) {

            if (employee.getUsername().equals(username)) {
                
                if (employee.getPassword().equals(password)) {
                    this.employees.remove(employee);
                }

            }
        }
    }

}
