package org.sv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.sv2.model.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer>  {
//dynamic proxy class and it object is created.
}
