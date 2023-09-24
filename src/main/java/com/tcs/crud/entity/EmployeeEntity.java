package com.tcs.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMP")
@Data
public class EmployeeEntity {

	@Id
	private Integer empno;
	private String ename;
	private Double sal;
	private Integer deptno;
	
}
