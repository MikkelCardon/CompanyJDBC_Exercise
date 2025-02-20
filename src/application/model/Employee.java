package application.model;

public class Employee {

	private int employeeId;
	private String name;
	private int wage; // hourly wage

	public Employee(int employeeId, String name, int wage) {
		this.employeeId = employeeId;
		this.name = name;
		this.wage = wage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getEmployeeId(){return employeeId;}

	@Override
	public String toString() {
		return name + " (kr " + wage + ")";
	}

	/**
	 * Returns the weekly salary of this employee.
	 */

	//Metode flyttes til controller


}
