package com.etcxm.enmo;

public class Employee {
    private int enumber;
    private String ejob;
    private String ename;
    private String esex;
    private double esalary;
	public int getEnumber() {
		return enumber;
	}
	public void setEnumber(int enumber) {
		this.enumber = enumber;
	}
	public String getEjob() {
		return ejob;
	}
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int enumber, String ejob, String ename, String esex,
			double esalary) {
		super();
		this.enumber = enumber;
		this.ejob = ejob;
		this.ename = ename;
		this.esex = esex;
		this.esalary = esalary;
	}
	@Override
	public String toString() {
		return "Employee [enumber=" + enumber + ", ejob=" + ejob + ", ename="
				+ ename + ", esex=" + esex + ", esalary=" + esalary + "]";
	}
    
}
