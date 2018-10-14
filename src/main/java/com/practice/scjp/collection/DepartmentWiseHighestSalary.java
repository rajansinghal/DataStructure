package com.practice.scjp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Employee implements Comparable<Employee>{
	String name;
	String sal;
	String dep;
	Employee(String name, String sal, String dep){
		
		this.name=name;
		this.sal=sal;
		this.dep=dep;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public int compareTo(Employee e){
		
		if(dep.compareTo(e.getDep()) > 0)
			return 1;
		else if(dep.compareTo(e.getDep()) < 0)
			return -1;
		else {	
			return sal.compareTo(e.getSal());
		}
	}
	public String toString() {
		return name + " | " + sal + " |" + dep + "\n";
	}
}
public class DepartmentWiseHighestSalary {
	
	
	
	
	public static void main(String arr[]){
		List<Employee> emps= new ArrayList<Employee>();
		emps.add(new Employee("rajan","1","2"));
		emps.add(new Employee("pankaj","1","1"));
		emps.add(new Employee("monika", "2", "3"));
		emps.add(new Employee("sunil", "2", "2"));
		emps.add(new Employee("satendra", "2", "1"));
		emps.add(new Employee("kajal","1","3"));
		emps.add(new Employee("prasad","5", "3"));
		emps.add(new Employee("ashu","5", "2"));
		emps.add(new Employee("sunny","5", "1"));
		Collections.sort(emps);
		System.out.println(emps);
		
	}

}
