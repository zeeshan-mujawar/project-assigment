package com.cubiOpt.services.employeeService;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Request;

import java.util.List;

public interface EmployeeService {

    void createRequest(Request request);

    List<Desk> getAllDesks();

    List<Request> requestStatus(Integer empId);
}
