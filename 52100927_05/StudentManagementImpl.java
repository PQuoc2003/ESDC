// DO NOT USE PACKAGE

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentManagementImpl implements StudentManagement {

    ArrayList<Student> students;

    public StudentManagementImpl() {
        this.students = new ArrayList<>();
    }

    public StudentManagementImpl(String dataPath) {
        this.students = new ArrayList<>();
        readData(dataPath);
    }

    private void readData(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String readLine = "";
            while ((readLine = br.readLine()) != null) {
                String[] atr = readLine.split(" ");

                if (atr.length != 5)
                    continue;

                double gpa = Double.parseDouble(atr[3]);

                Student student = new Student(atr[0], atr[1], atr[2], gpa, atr[4]);

                this.students.add(student);

            }

            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int getNoOfStudent() throws RemoteException {
        if (this.students == null)
            return 0;
        return this.students.size();
    }

    @Override
    public int getNoOfStudent_byGender(String gender) throws RemoteException {

        if (this.students == null)
            return 0;

        int count = 0;

        for (Student student : students) {
            if (student.getGender().equalsIgnoreCase(gender))
                count += 1;

        }

        return count;
    }

    @Override
    public int getNoOfStudent_byMajor(String major) throws RemoteException {

        if (this.students == null)
            return 0;

        int count = 0;

        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major))
                count += 1;

        }

        return count;

    }

    @Override
    public int getNoOfStudent_byGPA(double gpa) throws RemoteException {
        if (this.students == null)
            return 0;

        int count = 0;

        for (Student student : students) {
            if (student.getGpa() < gpa)
                count += 1;

        }

        return count;
    }

    @Override
    public Student findStudent_byName(String name) throws RemoteException {

        if (this.students == null)
            return null;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name))
                return student;
        }

        return null;
    }

    @Override
    public Student findStudent_byID(String id) throws RemoteException {
        if (this.students == null)
            return null;

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id))
                return student;
        }

        return null;
    }

    @Override
    public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException {
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : this.students) {
            if (student.getMajor().equalsIgnoreCase(major))
                result.add(student);
        }

        return result;

    }

    @Override
    public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException {
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : this.students) {
            if (student.getGpa() < GPA)
                result.add(student);
        }

        return result;
    }

    @Override
    public double getAvgGPA() throws RemoteException {

        if (this.students.size() == 0)
            return 0;

        double total = 0;

        for (Student student : students) {
            total += student.getGpa();
        }

        return total / (double) this.students.size();
    }

    @Override
    public Student getHighestGPA_byGender(String gender) throws RemoteException {

        double highest = 0;
        Student highestStudent = null;

        for (Student student : students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                if (student.getGpa() > highest) {
                    highestStudent = student;

                }
            }
        }

        return highestStudent;
    }

    @Override
    public Student getHighestGPA_byFName(String fname) throws RemoteException {
        double highest = 0;
        Student highestStudent = null;

        for (Student student : students) {
            if (student.getName().split(" ")[0].equalsIgnoreCase(fname)) {
                if (student.getGpa() > highest) {
                    highestStudent = student;

                }
            }
        }

        return highestStudent;
    }

    @Override
    public Student getHighestGPA_byLName(String lname) throws RemoteException {
        double highest = 0;
        Student highestStudent = null;

        for (Student student : students) {
            String name = student.getName();
            String[] names = name.split(" ");
            String lastname = names[names.length - 1];
            if (lastname.equalsIgnoreCase(lname)) {
                if (student.getGpa() > highest) {
                    highestStudent = student;

                }
            }
        }

        return highestStudent;
    }

    @Override
    public Student getHighestGPA_byMajor(String major) throws RemoteException {

        double highest = 0;
        Student highestStudent = null;

        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                if (student.getGpa() > highest) {
                    highestStudent = student;

                }
            }
        }

        return highestStudent;

    }

    @Override
    public Student getLowestGPA_byMajor(String major) throws RemoteException {

        double lowest = 0;
        Student lowestStudent = null;

        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                if (student.getGpa() < lowest) {
                    lowestStudent = student;

                }
            }
        }

        return lowestStudent;
    }

    @Override
    public ArrayList<Student> getTop10_byGPA() throws RemoteException {
        ArrayList<Student> top = new ArrayList<>(this.students);

        Comparator<Student> comparator = (s1, s2) -> s1.getGpa() - s2.getGpa() > 0 ? -1 : 1;

        top.sort(comparator);

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i > result.size())
                break;
            result.add(top.get(i));
        }

        return result;

    }

    @Override
    public ArrayList<Student> getTop10GPA_byGender(String gender) throws RemoteException {
        ArrayList<Student> genderList = new ArrayList<>();

        Comparator<Student> comparator = (s1, s2) -> s1.getGpa() - s2.getGpa() > 0 ? -1 : 1;

        for (Student student : this.students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                genderList.add(student);
            }
        }

        genderList.sort(comparator);

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i > result.size())
                break;
            result.add(genderList.get(i));
        }

        return result;
    }

    @Override
    public ArrayList<Student> getTop10GPA_byMajor(String major) throws RemoteException {
        ArrayList<Student> majorList = new ArrayList<>();

        Comparator<Student> comparator = (s1, s2) -> s1.getGpa() - s2.getGpa() > 0 ? -1 : 1;

        for (Student student : this.students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                majorList.add(student);
            }
        }

        majorList.sort(comparator);

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i > result.size())
                break;
            result.add(majorList.get(i));
        }

        return result;
    }

    @Override
    public ArrayList<Student> getLast10GPA_byGender(String gender) throws RemoteException {
        ArrayList<Student> genderList = new ArrayList<>();

        Comparator<Student> comparator = (s1, s2) -> s1.getGpa() - s2.getGpa() > 0 ? 1 : -1;

        for (Student student : this.students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                genderList.add(student);
            }
        }

        genderList.sort(comparator);

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i > result.size())
                break;
            result.add(genderList.get(i));
        }

        return result;
    }

    @Override
    public ArrayList<Student> getLast10GPA_byMajor(String major) throws RemoteException {
        ArrayList<Student> majorList = new ArrayList<>();

        Comparator<Student> comparator = (s1, s2) -> s1.getGpa() - s2.getGpa() > 0 ? 1 : -1;

        for (Student student : this.students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                majorList.add(student);
            }
        }

        majorList.sort(comparator);

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i > result.size())
                break;
            result.add(majorList.get(i));
        }

        return result;
    }

    @Override
    public ArrayList<String> getMajors() throws RemoteException {
        ArrayList<String> majors = new ArrayList<>();


        for (Student student : this.students) {
            String major = student.getMajor();


            if(!majors.contains(major)) majors.add(major);


        }


        return majors;
    }

}
