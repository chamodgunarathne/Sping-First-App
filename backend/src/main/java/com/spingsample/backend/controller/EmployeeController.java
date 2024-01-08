package com.spingsample.backend.controller;

import com.spingsample.backend.exception.EmployeeNotFoundException;
import com.spingsample.backend.model.Employee;
import com.spingsample.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/user")
    Employee newUser(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/users")
    List<Employee> getAllUsers(){
     return employeeRepository.findAll();
    }

    @GetMapping("/users/{id}")
    Employee getUserbyId(@PathVariable Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    Employee updateUser(@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setUsername((newEmployee.getUsername()));
                    employee.setName(newEmployee.getName());
                    employee.setEmail(newEmployee.getEmail());
                    return employeeRepository.save(employee);
                }).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/userDel/{id}")
    String deleteUser(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "user with id " + id+ " has been deleted";
    }

}
