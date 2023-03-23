package com.stl.expenses.management;

import java.util.ArrayList;
import java.util.List;

import com.stl.expenses.domain.Employee;
import com.stl.expenses.domain.ExpenseClaim;
import com.stl.expenses.domain.StaffEmployee;

public class RegularExpenseManagementProcess implements ExpenseManagementProcess {

	List<ExpenseClaim> claims = new ArrayList<>();
	
	
	@Override
	public int registerExpenseClaim(ExpenseClaim claim) {
		claims.add(claim);
		return claims.size() - 1;
	}

	@Override
	public boolean approveClaim(int id, Employee approver) {
		ExpenseClaim claim = claims.get(id);
		if (claim.getTotalAmount() <20000) {
			return true;
		}
		if (approver instanceof StaffEmployee) {
			return true;
		}
		return false;
	}
	

		
}
