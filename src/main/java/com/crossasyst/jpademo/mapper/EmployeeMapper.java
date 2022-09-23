package com.crossasyst.jpademo.mapper;
import com.crossasyst.jpademo.entity.EmployeeEntity;
import com.crossasyst.jpademo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeEntity employeeToEntity(Employee employee);

    Employee entityToEmployee(EmployeeEntity employeeEntity);
        
}
