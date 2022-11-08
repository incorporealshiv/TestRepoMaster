 package org.sv2.service;

import java.util.List;

import org.sv2.model.Employee;



public interface IEmployeeService {
	Employee saveEmployee(Employee e) throws Exception;
	Employee updateEmployee(Employee emp) throws Exception;
	void deleteEmployee(Integer id);
	 Employee getOneEmployee(Integer id);
	Iterable<Employee> getAllEmployees(String ... properties);// method implemented using paging and sorting employee
}//class
