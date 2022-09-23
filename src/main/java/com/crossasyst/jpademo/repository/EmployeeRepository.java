package com.crossasyst.jpademo.repository;

import com.crossasyst.jpademo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
