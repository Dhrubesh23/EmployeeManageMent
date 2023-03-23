package com.stl.expenses;
import java.time.LocalDate;

import com.stl.expenses.domain.Department;
import com.stl.expenses.domain.Employee;
import com.stl.expenses.domain.Employees;
import com.stl.expenses.domain.ExpenseClaim;
import com.stl.expenses.domain.ExpenseItem;
import com.stl.expenses.domain.ExpenseType;

public class Main {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setTitle("Mr");
		employee1.setFirstName("Dhrubesh");
		employee1.setSurname("Mahata");
		
		System.out.println(employee1.getMailingName());
		System.out.println(employee1.getMailingName(true));
		System.out.println(employee1.getMailingName(false));
		
		
		
		Employee employee2 = new Employee(2, "Manager");
		employee2.setTitle("Dr");
		employee2.setFirstName("Debasish");
		employee2.setSurname("Bera");
		
		
		Employees employees = new Employees();
		employees.addEmployee(employee1);
		employees.addEmployee(employee2);
		employees.addEmployee(new Employee(3, "Mrs", "Priyanka", "Mahata", "Director", Department.MARKETING));
		
		employees.printEmployees();
		
		Employee foundEmployee = employees.findBySurname("Bera");
		System.out.println("Found" + foundEmployee.getMailingName());
		
		Employee foundEmployee2 = employees.findBySurname("Paul");
		System.out.println("Didn't Find " + (foundEmployee2 == null));
	
		
		ExpenseClaim expenseClaim = new ExpenseClaim(24, 642, LocalDate.now());
		System.out.println(expenseClaim.getEmployeeId());
		expenseClaim.setPaid(true);
		System.out.println(expenseClaim.getPaid());
		expenseClaim.setApproved(true);
		expenseClaim.setPaid(true);
		System.out.println(expenseClaim.getPaid());
		 
		ExpenseItem expenseItem = new ExpenseItem(24, 102, ExpenseType.ACCOMODATION, "JW Marriot", 25000D);
		System.out.println(expenseItem.getDescription());
		
		System.out.println(employee1);
		
		
		Employee employee3 = new Employee();
		employee3.setId(1);
		employee3.setTitle("Mr");
		employee3.setFirstName("Dhrubesh");
		employee3.setSurname("Mahata");
		
		System.out.println(employee1.equals(employee3));
	}

}
