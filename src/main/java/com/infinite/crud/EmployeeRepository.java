package com.infinite.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByLastName(String lastName);
	Employee findByEmailId(String emailId);
	Employee findByEmailIdAndLastName(String emailId,String lastName);
}
