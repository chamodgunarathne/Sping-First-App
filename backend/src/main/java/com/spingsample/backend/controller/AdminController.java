package com.spingsample.backend.controller;

import com.spingsample.backend.exception.EmployeeNotFoundException;
import com.spingsample.backend.model.Employee;
import com.spingsample.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi Admin");
    }

    @GetMapping("/users")
    List<Employee> getAllUsers(){
        System.out.println("Header received");
        return employeeRepository.findAll();
    }

    @PostMapping("/user")
    Employee newUser(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
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
