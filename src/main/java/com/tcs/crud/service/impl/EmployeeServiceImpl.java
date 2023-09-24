package com.tcs.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.crud.entity.EmployeeEntity;
import com.tcs.crud.model.EmployeeRequest;
import com.tcs.crud.repository.EmployeeRepository;
import com.tcs.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Override
	public List<EmployeeRequest> fetchEmployees() {
		List<EmployeeRequest> lst=new ArrayList<>();
		List<EmployeeEntity> empEntities=repo.findAll();
		empEntities.forEach(entity->{

			EmployeeRequest emp=new EmployeeRequest();
			BeanUtils.copyProperties(entity,emp);
			lst.add(emp);
		});
		return lst;
	}

	@Override
	public boolean addEmployee(EmployeeRequest emp) {

		if(!repo.existsById(emp.getEmpno())) {

			EmployeeEntity entity=new EmployeeEntity();
			BeanUtils.copyProperties(emp, entity);
			repo.save(entity);
			return true;
		}

		return false;
	}
	
	@Override
	public boolean editEmployee(EmployeeRequest employee) {
		
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		repo.saveAndFlush(entity);
		return true;
	}
	@Override
	public EmployeeRequest fetchEmployeeById(int empno) {
		
		EmployeeEntity entity=repo.findById(empno).get();
		EmployeeRequest emp=new EmployeeRequest();
		BeanUtils.copyProperties(entity, emp);
		
		return emp;
	}
	
	@Override
	public boolean deleteEmployee(Integer empno) {
		repo.deleteById(empno);
		return true;
	}

}
