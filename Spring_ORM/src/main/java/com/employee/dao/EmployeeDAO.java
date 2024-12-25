package com.employee.dao;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeDAO 
{
	void insert(Employee employee);
	List<Employee>getAll();
	Employee fetchOne(int id);
	void update(Employee employee);
	void delete(int id);
	
}
