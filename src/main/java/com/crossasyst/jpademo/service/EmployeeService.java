package com.crossasyst.jpademo.service;

import com.crossasyst.jpademo.entity.EmployeeEntity;
import com.crossasyst.jpademo.mapper.EmployeeMapper;
import com.crossasyst.jpademo.model.Employee;
import com.crossasyst.jpademo.model.EmployeeResponse;
import com.crossasyst.jpademo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;



    public EmployeeResponse createEmployee(Employee employee){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        /*employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setCity(employee.getCity());
        employeeEntity.setZipcode(employee.getZipcode());*/
        employeeEntity=employeeMapper.employeeToEntity(employee);
        EmployeeResponse employeeResponse=new EmployeeResponse();
        Long id=(long)(Math.random()*20);
        employeeEntity.setId(id);
        employeeResponse.setId(employeeEntity.getId());
        employeeRepository.save(employeeEntity);
        return employeeResponse;
    }

    public Employee getEmployee(Long employeeId){
       Employee employee=new Employee();
       EmployeeEntity employeeEntity=new EmployeeEntity();
        Optional<EmployeeEntity> employeeEntity1=employeeRepository.findById(employeeId);
        if(employeeEntity1.isPresent()){
            /*employee.setFirstName(employeeEntity1.get().getFirstName());
            employee.setLastName(employeeEntity1.get().getLastName());
            employee.setCity(employeeEntity1.get().getCity());
            employee.setZipcode(employeeEntity1.get().getZipcode());*/
            employee=employeeMapper.entityToEmployee(employeeEntity1.get());
        }
        else {
            log.info("Employee with id "+employeeId+" not found");
        }
        return employee;
    }

    public void updateEmployee(Long employeeId,Employee employee){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        Optional<EmployeeEntity> employeeEntityOptional=employeeRepository.findById(employeeId);
        if(employeeEntityOptional.isPresent()){
            employeeEntityOptional.get().setFirstName(employee.getFirstName());
            employeeEntityOptional.get().setLastName(employee.getLastName());
            employeeEntityOptional.get().setCity(employee.getCity());
            employeeEntityOptional.get().setZipcode(employee.getZipcode());
            employeeRepository.save(employeeEntityOptional.get());
        }
        else {
            log.info("Employee with id "+employeeId+" not found");
        }
    }
}
