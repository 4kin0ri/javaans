package ex13;

import java.io.Serializable;

public class EmployeesDTO implements Serializable{

	private String employee_id;

	private String first_name;

	private String last_name;

	private String email;

	private String hire_date;

	private int salary;

	private int department_id;

	public EmployeesDTO() {

	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	/**
	 * ポイント:　上の7つの変数のsetter/getterメソッドをそれぞれ書いてください．
	 * 上メニューの，ソース -> getterおよびsetterの生成　から，簡単に書き出せます．
	 * @return
	 */


}
