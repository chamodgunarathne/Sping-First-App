package com.spingsample.backend.services;

import com.spingsample.backend.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AdminService {
    List<Employee> getAllUsers();

    Employee newUser(Employee newEmployee);

    Employee getUserbyId( Long id);

    Employee updateUser(Employee newEmployee, Long id);

    String deleteUser(Long id);


}
