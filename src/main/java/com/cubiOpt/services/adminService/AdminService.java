package com.cubiOpt.services.adminService;

import com.cubiOpt.entities.Desk;
import com.cubiOpt.entities.Employee;
import com.cubiOpt.entities.Request;

import java.util.List;

public interface AdminService {
    List<Request> getAllRequests();

    void addDesk(Desk desk);

    void addEmployee(Employee employee);

    void approveDeskChangeRequest(Long requestId);

    void rejectDeskChangeRequest(Long requestId);
}
