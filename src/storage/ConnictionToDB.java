package storage;

import application.model.Company;
import application.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class ConnictionToDB {
    private static Connection minConnection;

    static {
        try {
            String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=CompanyEmployee;user=sa;password=CARDONDB;";
            minConnection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Company> getCompanies() {
        ArrayList<Company> comp = new ArrayList<Company>();
        try {
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select * from Company");
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                int hours = res.getInt(3);
                Company company = new Company(id, name, hours);
                comp.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comp;
    }

    public static ArrayList<Employee> getEmployee() {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        try {
            Statement statement = minConnection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Employees");

            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString(2);
                int wage = res.getInt(3);

                Employee employee = new Employee(id, name, wage);
                emp.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return emp;
    }

    public static ArrayList<Employee> getEmpForComp(int companyid) {
        ArrayList<Employee> ansatte = new ArrayList<Employee>();
       try{
           Statement statement = minConnection.createStatement();
           ResultSet res = statement.executeQuery("SELECT * FROM Employees WHERE companyID = " + companyid);

           while(res.next()){
               while(res.next()){
                   int id = res.getInt(1);
                   String name = res.getString(2);
                   int wage = res.getInt(3);

                   Employee employee = new Employee(id, name, wage);
                   ansatte.add(employee);
               }
           }


       }catch (SQLException e) {
           throw new RuntimeException(e);
       }
        return ansatte;
    }

    public static String removeCompany(int id) {

        try{
            Statement statement = minConnection.createStatement();
            statement.executeUpdate("DELETE FROM Company WHERE companyID = " + id);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Company id:" + id +". Er blever slettet";
    }

    //return name of company for employee
    public static String getCompanyForEmp(Employee emp) {

        String Cname = "";
        try{
            Statement statement = minConnection.createStatement();
            ResultSet res = statement.executeQuery("EXEC getCompanyNameByEmployee " + emp.getEmployeeId());
            res.next();
            Cname = res.getString(1);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return Cname;
    }
    //return id of company for employee
    public static int getCompanyIdForEmp(Employee emp) {
        int id = 9999;
        //TODO
        return id;
    }

    public static void createCompany(String name, int hours) {
        //TODO
    }

    public static int getHoursPrWeek(int empId){
        int hoursrWeek = 0;
       //TODO
        return hoursrWeek;
    }

    public static void updateCompany(String name, int hours, int compId){
        //TODO
    }

    public static void updateEmployee(String name, int wage, int empId, int compID){
        //TODO
    }

    public static void addEmployee(String name, int wage, int compId){
       //TODO
    }

    public static void removeEmployee(Employee emp) {
        //TODO
    }
}
