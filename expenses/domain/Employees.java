package com.stl.expenses.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.stl.expenses.exceptions.EmployeeNotFoundException;

public class Employees {
	
	private Map<Integer, Employee> employees = new HashMap<>();
	
	
	public void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
	
	public List<Employee> getEmployeeList() {
		return new ArrayList<Employee>(employees.values());
	}
	
	public void printEmployees() {
		List<Employee> employeeList = new ArrayList<>(employees.values());
		Collections.sort(employeeList);
		for(Employee e : employeeList) {
				System.out.println(e);
				for (ExpenseClaim claim : e.getClaims().values()) {
					System.out.println(claim);
					claim.printExpenseItems();
					System.out.println("Total value of claim " + claim.getTotalAmount());
				}
		}
	}
	
	public Employee findBySurname(String surname) {
		for(Employee e : employees.values()) {
			if (e.getSurname().equals(surname)) {
				return e;
			}
		}
		return null;
	}
	
	public Employee findById(int id) {
		
		return employees.get(id);
	}
	
	public boolean employeeExists(int id) {
		
		return employees.containsKey(id);
	}
	
	public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
		int employeeId = claim.getEmployeeId();
		
		if (!employeeExists(employeeId)) {
			throw new EmployeeNotFoundException();
		}
		
		
		for(Employee e : employees.values()) {
			if (e.getId() == employeeId) {
				
				e.getClaims().put(claim.getId(), claim);
			}
		}
	}
	
}
