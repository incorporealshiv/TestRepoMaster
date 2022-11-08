package org.sv2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.sv2.model.Employee;
import org.sv2.repository.EmployeeRepo;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
private EmployeeRepo repo;
	@Override
	public Employee saveEmployee(Employee e) throws Exception {
		System.out.println("EmployeeServiceImpl.saveEmployee()");
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.now();
		String dateString=date.toString();
		System.out.println(dateString);
		e.setCreatedOn(dateString);
		//save method throws two type of Exception one is IllegalArgumentException  in case given entity is null
		//and other is OptimisticLockingFailureException so we have taken super class
		Employee emp=repo.save(e);//persist means save if id primary key is not present
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeServiceImpl.updateEmployee()");
		// TODO Auto-generated method stub
		//merge is update actually
		//update and persist both are done by save method
		//Employee empfind=repo.findById(emp.getEmpId()).orElseThrow();
		Optional<Employee> opt=repo.findById(emp.getEmpId());
		if(opt.isPresent()) {
			
			LocalDate date=LocalDate.now();
			String dateString=date.toString();
			System.out.println(dateString);
			emp.setCreatedOn(dateString);
			return repo.save(emp);
//			return "Employee with id\t"+emp.getEmpId()+"\tis updated"; 
		}//try
		else {
			throw new Exception();
		}//else
		 
		

	}//method

	@Override
	public void deleteEmployee(Integer id)  throws IllegalArgumentException{
		// TODO Auto-generated method stub
		System.out.println("EmployeeServiceImpl.deleteEmployee()");
		repo.deleteById(id);

	}//method
	
	@Override
	public Employee getOneEmployee(Integer id) throws NoSuchElementException  {
		System.out.println("EmployeeServiceImpl.getOneEmployee()");
		// TODO Auto-generated method stub
		Optional<Employee>  opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}//method

	@Override
	public Iterable<Employee> getAllEmployees(String...properties) {
		// TODO Auto-generated method stub
		System.out.println("EmployeeServiceImpl.getAllStudents()");
		Sort sort=Sort.by(Direction.ASC, properties);
		return (List<Employee>)repo.findAll(sort);
	}//method

	

}
