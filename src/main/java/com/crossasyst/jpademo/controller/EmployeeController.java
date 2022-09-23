package com.crossasyst.jpademo.controller;

import com.crossasyst.jpademo.model.Employee;
import com.crossasyst.jpademo.model.EmployeeResponse;
import com.crossasyst.jpademo.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
@Component
@Log4j2

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee){
        EmployeeResponse employeeResponse= employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/employees/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId){
        Employee employee=employeeService.getEmployee(employeeId);
        if(Objects.isNull(employee)) {
            log.info("Employee with employeeId "+employeeId+" found");
        }
        else {
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping(path="/employees/{employeeId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
      employeeService.updateEmployee(employeeId,employee);
     return ResponseEntity.ok().build();
    }

}
