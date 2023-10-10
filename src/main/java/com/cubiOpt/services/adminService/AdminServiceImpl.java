package com.cubiOpt.services.adminService;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Employee;
import com.cubiOpt.entities.Request;
import com.cubiOpt.repositories.DeskRepository;
import com.cubiOpt.repositories.EmployeeRepository;
import com.cubiOpt.repositories.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    DeskRepository deskRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public void addDesk(Desk desk) {
        deskRepository.save(desk);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void approveDeskChangeRequest(Long requestId) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request not found with ID: " + requestId));

        if (!"In progress".equals(request.getStatus())) {
            throw new RuntimeException("Request has already been processed.");
        }

        Desk fromDesk = request.getFromDesk();
        Desk toDesk = request.getToDesk();

        fromDesk.setOccupancyStatus("Vacant");
        toDesk.setOccupancyStatus("Occupied");

        Employee newEmployee = request.getEmployee();
        fromDesk.setEmployee(null);
        toDesk.setEmployee(newEmployee);

        request.setStatus("Resolved");

        deskRepository.save(fromDesk);
        deskRepository.save(toDesk);
        requestRepository.save(request);
    }

    @Override
    public void rejectDeskChangeRequest(Long requestId){
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request not found with ID: " + requestId));

        if (!"In progress".equals(request.getStatus())) {
            throw new RuntimeException("Request has already been processed.");
        }
        request.setStatus("Rejected");
        requestRepository.save(request);
    }
}
