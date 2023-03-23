package com.stl.expenses.management;

import com.stl.expenses.domain.Employee;
import com.stl.expenses.domain.ExpenseClaim;

public class ExpressExpenseManagementProcess implements ExpenseManagementProcess{

	private ExpenseClaim claim;
	
	@Override
	public int registerExpenseClaim(ExpenseClaim claim) {
		
		this.claim = claim;
		return -1;
	}

	@Override
	public boolean approveClaim(int id, Employee approver) {
		
		return (claim.getTotalAmount() < 50000);
	}

}
