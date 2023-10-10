package com.cubiOpt.controllers;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Request;
import com.cubiOpt.services.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/request")
    public void createRequest(@RequestBody Request request) {
        this.employeeService.createRequest(request);
    }

    @GetMapping("/request-status/{empId}")
    public List<Request> requestStatus (@PathVariable Integer empId){
        return this.employeeService.requestStatus(empId);
    }

    @GetMapping("/desks")
    public List<Desk> getAllDesks() {
        return this.employeeService.getAllDesks();
    }
}


