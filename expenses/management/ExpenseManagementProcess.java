package com.stl.expenses.management;

import com.stl.expenses.domain.Employee;
import com.stl.expenses.domain.ExpenseClaim;

public interface ExpenseManagementProcess {
	
	public int registerExpenseClaim(ExpenseClaim claim);
	public boolean approveClaim(int id, Employee approver);
	
}
