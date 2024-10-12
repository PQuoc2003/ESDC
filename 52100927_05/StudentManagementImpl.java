// DO NOT USE PACKAGE

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class StudentManagementImpl implements StudentManagement {
    
    ArrayList<Student> students;

    public StudentManagementImpl()
    {
        this.students = new ArrayList<>();
    }

    public StudentManagementImpl(String dataPath)
    {
        this.students = new ArrayList<>();
        readData(dataPath);
    }

    private void readData(String filePath)
    {
        try
        {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String readLine = "";
            while ((readLine = br.readLine()) != null)
            {
                // Insert your code here ...
            }
            
            br.close();
        } catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int getNoOfStudent() throws RemoteException
    {
        // Insert your code here ...
        return -1;
    }

    @Override
    public int getNoOfStudent_byGender(String gender) throws RemoteException
    {
        // Insert your code here ...
        return -1;
    }

    @Override
    public int getNoOfStudent_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        return -1;
    }

    @Override
    public int getNoOfStudent_byGPA(double gpa) throws RemoteException
    {
        // Insert your code here ...
        return -1;
    }

    @Override
    public Student findStudent_byName(String name) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public Student findStudent_byID(String id) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public double getAvgGPA() throws RemoteException
    {
        // Insert your code here ...
        return -1;
    }

    @Override
    public Student getHighestGPA_byGender(String gender) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public Student getHighestGPA_byFName(String fname) throws RemoteException
    {
        return null;
    }

    @Override
    public Student getHighestGPA_byLName(String lname) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public Student getHighestGPA_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
    public Student getLowestGPA_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        return null;
    }

    @Override
	public ArrayList<Student> getTop10_byGPA() throws RemoteException
	{
		// Insert your code here ...
        return null;
	}

	@Override
	public ArrayList<Student> getTop10GPA_byGender(String gender) throws RemoteException
	{
    	// Insert your code here ...
        return null;
	}

	@Override
	public ArrayList<Student> getTop10GPA_byMajor(String major) throws RemoteException
	{
		// Insert your code here ...
        return null;
	}

	@Override
	public ArrayList<Student> getLast10GPA_byGender(String gender) throws RemoteException
	{
		// Insert your code here ...
        return null;
	}

	@Override
	public ArrayList<Student> getLast10GPA_byMajor(String major) throws RemoteException
	{
		// Insert your code here ...
        return null;
	}

    @Override
    public ArrayList<String> getMajors() throws RemoteException
    {
        // Insert your code here ...
        return null;
    }
    
}
