package com.tcs.crud.model;

import lombok.Data;

@Data
public class EmployeeRequest {

	private Integer empno;
	private String ename;
	private Double sal;
	private Integer deptno;
}
