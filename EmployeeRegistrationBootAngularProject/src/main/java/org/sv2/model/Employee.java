package org.sv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue//hibernate_sequence
	private Integer empId;
	private String empName;
	private String deptName;
	private Double salary;
	//take the phone number as String if you want to save the country codes also
	//suppose as indian number as +91-8989898989 then Long is not capable to handle it 
	//because it is numeric only
	//private Long phoneNo;
	@Column(name ="phoneNo",length = 14)
	private String phoneNo;
	private String email;
	private String createdOn;
	
	//no need write getter setter manually as we have written them using lombok api
	}
