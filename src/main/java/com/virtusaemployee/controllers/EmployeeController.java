package com.virtusaemployee.controllers;

import com.virtusaemployee.entities.VEmployee;
import com.virtusaemployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/virtusa")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	// Get All Employees
	@GetMapping("/employees")
	public ResponseEntity<List<VEmployee>> getEmployees() {
		List<VEmployee> employeeList;
		System.out.println("Rahul");
		employeeList = employeeService.getAllEmployees();
		if (employeeList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employeeList));
	}

	// Get single Employee
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<VEmployee>> getEmployee(@PathVariable("id") int id) {
		Optional<VEmployee> employee = employeeService.getEmployeeById(id);
		if (employee.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	// Save New Employee
	@PostMapping("/add")
	public ResponseEntity<Optional<VEmployee>> addEmployee(@RequestBody VEmployee employee) {
		VEmployee emp = null;
		try {
			emp = this.employeeService.addEmployee(employee);
			return ResponseEntity.ok(Optional.of(emp));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// update Employee by Eid
	@PutMapping("/edit/{eid}")
	public ResponseEntity<Optional<VEmployee>> updateEmployee(@RequestBody VEmployee vemployee,
			@PathVariable("eid") int eid) {
		try {
			this.employeeService.updateEmployeeById(vemployee, eid);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Delete VEmployee by Eid
	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<?> deleteEmp(@PathVariable("eid") int eid) {
		try {
			this.employeeService.deleteEmployee(eid);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
