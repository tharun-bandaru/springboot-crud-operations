package com.tcs.crud.service;

import java.util.List;

import com.tcs.crud.model.EmployeeRequest;

public interface EmployeeService {

	public List<EmployeeRequest> fetchEmployees();
	public boolean addEmployee(EmployeeRequest employee);
	public boolean editEmployee(EmployeeRequest employee);
	public boolean deleteEmployee(Integer empno);
	public EmployeeRequest fetchEmployeeById(int empno);
}
