package com.stl.expenses.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenseClaim {
	
	private Integer id;
	private Integer employeeId;
	private LocalDate dateOfClaim;
	private Boolean approved;
	private Boolean paid;
	
	private List<ExpenseItem> expenseItems;
	
	public ExpenseClaim(Integer id, Integer employeeId, LocalDate dateOfClaim) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.dateOfClaim = dateOfClaim;
		this.approved = false;
		this.paid = false;
		this.expenseItems = new ArrayList<>();
	}
	
	public void addExpenseItem(ExpenseItem item) {
		expenseItems.add(item);
	}
	
	public void printExpenseItems() {
		for(ExpenseItem ei : expenseItems) {
			System.out.println(ei);
		}
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public void setPaid(Boolean paid) {
		if(paid && !approved) {
			System.out.println("Amount cant be paid because it has not yet been approved!");
		}
		else {
			this.paid = paid;
		}
	}

	public Integer getId() {
		return id;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public LocalDate getDateOfClaim() {
		return dateOfClaim;
	}


	public Double getTotalAmount() {
		Double total = 0d;
		for(ExpenseItem ei : expenseItems) {
			total += ei.getAmount();
		}
		return total;
	}

	public Boolean getApproved() {
		return approved;
	}

	public Boolean getPaid() {
		return paid;
	}

	

	@Override
	public String toString() {
		return "ExpenseClaim [id=" + id + ", employeeId=" + employeeId + ", dateOfClaim=" + dateOfClaim + ", approved="
				+ approved + ", paid=" + paid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approved, dateOfClaim, employeeId, expenseItems, id, paid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpenseClaim other = (ExpenseClaim) obj;
		return Objects.equals(approved, other.approved) && Objects.equals(dateOfClaim, other.dateOfClaim)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(expenseItems, other.expenseItems)
				&& Objects.equals(id, other.id) && Objects.equals(paid, other.paid);
	}

	
	
	
	
}
