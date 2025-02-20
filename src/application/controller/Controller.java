package application.controller;


import application.model.Company;
import application.model.Employee;
import storage.ConnictionToDB;

import java.util.ArrayList;

public class Controller {
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public static void createCompany(String name, int hours) {
        ConnictionToDB.createCompany(name, hours);
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public static String deleteCompany(Company company) {

        //Storage.removeCompany(company);
        String s = ConnictionToDB.removeCompany(company.getId());
        return s;
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        ConnictionToDB.updateCompany(name,hours, company.getId());
    }

    /**
     * Get all the companies
     */
    public static ArrayList<Company> getCompanies() {
        return ConnictionToDB.getCompanies();
    }

    //ny metode
    /*public static ArrayList<Employee> getEmployeeFromComp(int companyid) {
        return ConnictionToDB.getAnsatteIVirksomhed(companyid);
    }*/

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public static void createEmployee(String name, int wage, int compId) {
        ConnictionToDB.addEmployee(name, wage, compId);
    }


    /**
     * Deletes the employee.
     */
    public static void deleteEmployee(Employee employee) {
        ConnictionToDB.removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, Company company) {
        ConnictionToDB.updateEmployee(name,wage, employee.getEmployeeId(), company.getId());
    }

    /**
     * Get all the employees.
     */
    public static ArrayList<Employee> getEmployees() {
        return ConnictionToDB.getEmployee();
    }

    public static int weeklySalary(Employee employee) {
        int salary = employee.getWage() * ConnictionToDB.getHoursPrWeek(employee.getEmployeeId());
        return salary;
    }

    public static String getCompanyForEmp(Employee employee){
        String emp = ConnictionToDB.getCompanyForEmp(employee);
        return emp;
    }

    public static ArrayList<Employee> getEmpForComp(int companyid) {
        return ConnictionToDB.getEmpForComp(companyid);
    }

    // -------------------------------------------------------------------------


}
