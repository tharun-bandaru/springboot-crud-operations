package com.tcs.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.crud.model.EmployeeRequest;
import com.tcs.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;


	@GetMapping("/index")
	public String getIndex()
	{
		return "index";
	}

	@GetMapping("/listEmployees")
	public String listEmployees(Model model) {

		List<EmployeeRequest> emp=empService.fetchEmployees();
		System.out.println("employee data fetching");
		model.addAttribute("employees",emp);
		return "listEmployees";	
	}

	@GetMapping("/addEmployee")
	public String getAddEmployee(Model model){

		EmployeeRequest employeeRequest=new EmployeeRequest();
		model.addAttribute("employeeRequest",employeeRequest);
		return "addEmployee";
	}


	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employeeRequest") EmployeeRequest employeeRequest,Model model)
	{
		boolean flag=empService.addEmployee(employeeRequest);
		if(flag)
		{
			model.addAttribute("message","Employee is added to the database");

		}
		else {
			model.addAttribute("message","Employee is already exists !..");
		}
		return "index";
	}

	@GetMapping("/editEmployee")
	public String editEmployee(@RequestParam Integer id, Model model) {

		EmployeeRequest emp=empService.fetchEmployeeById(id);
		model.addAttribute("emp",emp);
		return "editEmployee";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute EmployeeRequest emp)
	{
		empService.editEmployee(emp);
		return "redirect:listEmployees";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer id) {
		empService.deleteEmployee(id);
		return "redirect:listEmployees";
	}
	
	@GetMapping("/logoutUser")
	public String logoutUser() {
		
		
		return "loggedout";
	}

}
