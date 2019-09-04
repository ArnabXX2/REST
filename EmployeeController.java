package com.rohit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.rohit.demo.EmployeeRepository;

import java.util.List;


@RestController
@RequestMapping("/api/vi")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable(value="id")Long employeeId){
	//throws ResourceNotFoundException{
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: "+employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
}
