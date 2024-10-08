package service.imp;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cookies.Information;
import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }





    @Override
    public boolean login(String username, String password) {

        Employee employee = employeeRepository.login(username, password);


        if (employee == null) return false;


        // static file

        Information.currentEmployee = employee;

        // log file

        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  

        String logPath = "resources/log.txt";
        String text = username + " - " + employee.getRole() + " - " + strDate + "\n";

        try {
            FileWriter fileWriter = new FileWriter(logPath, true);
            fileWriter.write(text);

            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

        return true;








    }
    
}
