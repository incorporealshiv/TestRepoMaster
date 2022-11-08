package org.sv2.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sv2.model.Employee;
import org.sv2.service.IEmployeeService;

@RestController
@RequestMapping("/employee-rest-controller")//this is to request all type of request
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	
	
	//1.save
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws Exception{
		//public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		System.out.println("EmployeeRestController.saveEmployee()");
		//@RequestBody is media type annotation
		//we will save json data from angular converted to Emp object 
		//will be inserted into data base by Employee Service
//		Integer id=service.saveEmployee(employee);
		try {
			Employee emp=service.saveEmployee(employee);
			//String body="Employee is save with id"+id;
			return ResponseEntity.ok(emp);
			// ResponseEntity contains body and message
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;//rethrowing exeption after handling to send it to front end
			
		}
	}//method
	
	//2.fetch all
	@GetMapping("/all")
	public ResponseEntity<Iterable<Employee>> getAllEmployees(){
		System.out.println("EmployeeRestController.getAllEmployees()");
		try {//try
			Iterable<Employee> listEmp=service.getAllEmployees("empId");
			return ResponseEntity.ok(listEmp);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}//catch
	}//method
	
	
	//3.fetch one
	@GetMapping("/get_one_emp/{id}")//ID IS PATH VARIABLE is the input that comes at run time
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id){
		System.out.println("EmployeeRestController.getOneEmployee()");
		try {//try
			Employee e=service.getOneEmployee(id);
			return  ResponseEntity.ok(e);
			//PATH VARIABLE IS THE INPUT THAT COMES AT RUNTIME
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}//method
	
	//4.delete
	@DeleteMapping("/remove/{id}")//id is variable comes at runtime
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		System.out.println("EmployeeRestController.deleteEmployee()");
		try {//try
			service.deleteEmployee(id);
			String body="employee deleted with id\t\t"+id;
			return ResponseEntity.ok(body);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}//catch
	}//method
	
	//5.update
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) throws Exception{
		
		System.out.println("EmployeeRestController.updateEmployee()");
		//String body =service.updateEmployee(employee);//if id is already availbale then update
		try {
			Employee emp=service.updateEmployee(employee);
//			String body="Employee Updated whose id is "+employee.getEmpId();
			
			return ResponseEntity.ok(emp);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}//catch
	}//method

}//class

