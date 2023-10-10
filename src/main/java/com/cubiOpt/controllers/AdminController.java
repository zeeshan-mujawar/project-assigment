package com.cubiOpt.controllers;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Employee;
import com.cubiOpt.entities.Request;
import com.cubiOpt.services.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        return this.adminService.getAllRequests();
    }

    @PostMapping("/desk")
    public void addDesk(@RequestBody Desk desk) {
        this.adminService.addDesk(desk);
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        this.adminService.addEmployee(employee);
    }

    @GetMapping("/approve-request/{requestId}")
    public void approveRequest(@PathVariable Long requestId){
        adminService.approveDeskChangeRequest(requestId);
    }

    @GetMapping("/reject-request/{requestId}")
    public void rejectRequest(@PathVariable Long requestId){
        adminService.rejectDeskChangeRequest(requestId);
    }
}
