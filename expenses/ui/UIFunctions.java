package com.stl.expenses.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.stl.expenses.domain.Department;
import com.stl.expenses.domain.Employee;
import com.stl.expenses.domain.ExpenseClaim;
import com.stl.expenses.domain.ExpenseItem;
import com.stl.expenses.domain.ExpenseType;
import com.stl.expenses.domain.StaffEmployee;
import com.stl.expenses.exceptions.InvalidEmployeeIdException;
import com.stl.expenses.exceptions.NameTooShortException;
import com.stl.expenses.utilities.EmployeeUtilities;

public class UIFunctions {
	
	public Employee registerNewEmployee() {
		
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeUtilities employeeutilities = new EmployeeUtilities();
		
		boolean idIsValid = false;
		while(!idIsValid) {
			System.out.println("Enter the id");
			String inputId = scanner.nextLine();
			try {
				Integer id = employeeutilities.validateEmployeeId(inputId);
				employee.setId(id);
				idIsValid = true;
			} catch (InvalidEmployeeIdException e) {
				System.out.println("The id you entered was invalid , please enter a valid id!");
			}
		}
		
		System.out.println("Enter the title");
		String title = scanner.nextLine();
		employee.setTitle(title);
		
		boolean nameIsValid = false;
		while (!nameIsValid) {
			
			System.out.println("Enter the first name");
			String firstName = scanner.nextLine();
			employee.setFirstName(firstName);
			
			System.out.println("Enter the surname");
			String surname = scanner.nextLine();
			employee.setSurname(surname);
			try {
				employeeutilities.validateEmployeeName(firstName, surname);
				nameIsValid = true;
			} catch (NameTooShortException e) {
				System.out.println("The name you entered was not valid, please enter a valid firstname and surname!");
			}
			
		}
		
		System.out.println("Enter the job title");
		String jobTitle = scanner.nextLine();
		employee.setJobTitle(jobTitle);
		
		boolean departmentIsValid = false;
		
		while(!departmentIsValid) {
		
			System.out.println("Enter the department");
			String departmnet = scanner.nextLine();
			try {
			Department d = Department.valueOf(departmnet.toUpperCase());
			employee.setDepartment(d);
			departmentIsValid = true;
			}
			catch(IllegalArgumentException e) {
					System.out.println("The department you entered was not valid, please enter a valid department");
			}
		}
		
		System.out.println("Is this a member of staff: Y?N ");
		String isAStaffmember = scanner.nextLine();
		if(isAStaffmember.toUpperCase().equals("Y")) {
			StaffEmployee staff = new StaffEmployee(employee);
			
			System.out.println("Enter the username");
			String username = scanner.nextLine();
			staff.setUsername(username);
			
			System.out.println("Enter the password");
			String password = scanner.nextLine();
			staff.setPassword(password);
			
			return staff;
		}
		else {
			return(employee);
		}
		
		
	}
	
	public ExpenseClaim registerNewExpenseClaim() {
		
		Scanner scanner = new Scanner(System.in);
		EmployeeUtilities employeeUtilities = new EmployeeUtilities();
		
		System.out.println("Enter the claim Id");
		int claimId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the employee Id");
		int employeeId = scanner.nextInt();
		scanner.nextLine();
		
		LocalDate dateOfClaim = LocalDate.now();
		
		
		
		ExpenseClaim claim = new ExpenseClaim(claimId, employeeId, dateOfClaim);
		
		boolean finished = false;
		while (!finished) {
			System.out.println("Enter the expense item id");
			int eiId = scanner.nextInt();
			scanner.nextLine();
			
			boolean expenseTypeIsValid = false;
			
			ExpenseType eiType = null;
			
			while(!expenseTypeIsValid) {
			
				System.out.println("Enter the expense type");
				String expenseType = scanner.nextLine();
				
				try {
					eiType = ExpenseType.valueOf(expenseType.toUpperCase());
					expenseTypeIsValid = true;
				}
				catch(IllegalArgumentException e) {
						System.out.println("The expenseType you entered was not valid, please enter a valid expenseType");
				}
			}
			
			System.out.println("Enter the description");
			String description = scanner.nextLine();
			
			System.out.println("Enter the amount");
			double amount = scanner.nextDouble();
			scanner.nextLine();
			
			ExpenseItem ei = new ExpenseItem(eiId, claimId, eiType, description, amount);
			claim.addExpenseItem(ei);
			
			//To Do
			System.out.println("Want to add another expense item? (Y?N)");
			String anyMore = scanner.nextLine();
			
			if (!anyMore.toUpperCase().equals("Y")) {
				finished = true;
			}
			
			
		}
		
		return claim;
	}

}

