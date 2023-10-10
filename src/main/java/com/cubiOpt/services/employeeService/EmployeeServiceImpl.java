package com.cubiOpt.services.employeeService;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Request;
import com.cubiOpt.repositories.DeskRepository;
import com.cubiOpt.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    DeskRepository deskRepository;

    @Override
    public void createRequest(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    @Override
    public List<Request> requestStatus(Integer empId) {
        return requestRepository.findRequestsByEmployeeEmpId(empId);
    }

}
