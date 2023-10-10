package com.cubiOpt.repositories;

import com.cubiOpt.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findRequestsByEmployeeEmpId(Integer empId);
}
