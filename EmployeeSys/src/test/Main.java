package test;

import java.util.ArrayList;

import employeeClass.Employees;
import model.EmployeeModel;

public class Main {
	
	public static void main(String[] args) {
//		EmployeeModel employeeModel = new EmployeeModel();
//		Employees em = new Employees();

//		em = employeeModel.find(4);
//		System.out.println(em.toString());
		
		
		
//		Employees em = new Employees("CHH", "Bunkak", "kak@gmail.com", "1999-08-22", "011440811", "Employee", 0.01);
//		employeeModel.create(em);
		
//		Employees em = new Employees("CHH", "Bunnarong aka kak", "kak@gmail.com", "1999-08-22", "011440811", "Employee", 0.01);
//		em.setID(4);
//		employeeModel.edit(em);
		
//		employeeModel.delete(10);
		
		
		ArrayList<Employees> list = new ArrayList<>();
		list = EmployeeModel.search("Bunna");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

}
