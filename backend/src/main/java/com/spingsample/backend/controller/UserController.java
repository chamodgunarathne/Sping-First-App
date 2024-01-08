package com.spingsample.backend.controller;

import com.spingsample.backend.exception.EmployeeNotFoundException;
import com.spingsample.backend.model.Employee;
import com.spingsample.backend.model.User;
import com.spingsample.backend.repository.EmployeeRepository;
import com.spingsample.backend.services.UserService;
import com.spingsample.backend.services.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }



}
