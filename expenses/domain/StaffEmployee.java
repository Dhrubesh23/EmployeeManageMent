package com.stl.expenses.domain;

import java.util.Objects;

public class StaffEmployee extends Employee implements Comparable<Employee> {
	
	private String username;
	private String password;
	
	public StaffEmployee() {
		super();
	}
	
	public StaffEmployee (Employee e) {
		super(e.getId(), e.getTitle(), e.getFirstName(), e.getSurname(), e.getJobTitle(), e.getDepartment());
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password, username);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffEmployee other = (StaffEmployee) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
	
	
}
