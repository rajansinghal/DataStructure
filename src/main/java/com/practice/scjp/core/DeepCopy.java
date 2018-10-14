package com.practice.scjp.core;

public class DeepCopy {

	public static void main(String[] args) {
		Employe employee1 = new Employe("singhal", "rajan");
		employee1.setValue(40000.0);
		//employee1.addr = new Address("Gangal wali", " MZN", "UP", "251002");
		Employe employee2 = (Employe) employee1.clone();
		printEmployee(employee1);
		System.out.println("----------------------------------------");
		printEmployee(employee2);
		System.out.println("=============================================");
		employee2.setLN("gupta");
		//employee2.addr = new Address("modibhawan", " gurgaon", "Haryana", "2320112");
		printEmployee(employee1);
		System.out.println("----------------------------------------");
		printEmployee(employee2);
	}

	private static void printEmployee(Employe e) {
		System.out.println(e.getFN() + " " + e.getLN());
		//System.out.println(e.addr.getAddr());
		System.out.println("Salary: " + e.getValue());
	}
}

class Employe implements Cloneable {

	private String lN;
	private String fN;
	private Double value;
	public Address addr;

	public Employe(String lastName, String firstName) {
		this.lN = lastName;
		this.fN = firstName;
		this.addr = new Address();
	}

	public String getLN() {
		return this.lN;
	}

	public void setLN(String lastName) {
		this.lN = lastName;

	}

	public String getFN() {
		return this.fN;
	}

	public void setFirstName(String firstName) {
		this.fN = firstName;

	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double salary) {

		this.value = salary;
	}

	@Override
	public Object clone() {

		Employe emp;
		try {
			emp = (Employe) super.clone();
			emp.addr = (Address) addr.clone();

		} catch (CloneNotSupportedException e) {
			return null; // will never happen
		}

		return emp;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[" + this.fN + " " + this.lN + ", " + this.value + "]";
	}

}

class Address implements Cloneable {
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public Address() {
		this.street = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
	}

	public Address(String street, String city, String state, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public Object clone() {

		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null; // will never happen
		}
	}
	public String getAddr() {
		return this.street + "n" + this.city + ", " + this.state + " "+ this.zipCode;
	}

}
