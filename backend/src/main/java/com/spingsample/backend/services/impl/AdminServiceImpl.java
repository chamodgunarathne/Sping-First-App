package com.spingsample.backend.services.impl;

import com.spingsample.backend.exception.EmployeeNotFoundException;
import com.spingsample.backend.model.Employee;
import com.spingsample.backend.repository.EmployeeRepository;
import com.spingsample.backend.repository.ItemRepository;
import com.spingsample.backend.services.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee newUser(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee getUserbyId(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }


    @Override
    public Employee updateUser(Employee newEmployee, Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setUsername((newEmployee.getUsername()));
                    employee.setName(newEmployee.getName());
                    employee.setEmail(newEmployee.getEmail());
                    return employeeRepository.save(employee);
                }).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    @Override
    public String deleteUser(Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "user with id " + id+ " has been deleted";
    }











}
