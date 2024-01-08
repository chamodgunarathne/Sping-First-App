package com.spingsample.backend.controller;

import com.spingsample.backend.exception.EmployeeNotFoundException;
import com.spingsample.backend.model.Employee;
import com.spingsample.backend.repository.EmployeeRepository;
import com.spingsample.backend.services.AdminService;
import com.spingsample.backend.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getAllUsers() {
        List<Employee> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<Employee> newUser(@RequestBody Employee newEmployee) {
        Employee createdUser = adminService.newUser(newEmployee);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable Long id) {
        Employee user = adminService.getUserbyId(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Employee> updateUser(@RequestBody Employee newEmployee, @PathVariable Long id) {
        Employee updatedUser = adminService.updateUser(newEmployee, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/userDel/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String result = adminService.deleteUser(id);
        return ResponseEntity.ok(result);
    }

}
