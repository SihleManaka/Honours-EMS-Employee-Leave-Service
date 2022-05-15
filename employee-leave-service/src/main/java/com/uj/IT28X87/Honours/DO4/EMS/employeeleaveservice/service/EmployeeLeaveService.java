package com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.service;

import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.entity.EmployeeLeave;
import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.repository.IEmployeeLeaveRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeLeaveService implements IEmployeeLeaveService{

    IEmployeeLeaveRepository leaveRepository;

    @Override
    public EmployeeLeave saveEmployeeLeave(EmployeeLeave employeeLeave) {

        return leaveRepository.save(employeeLeave);
    }

    @Override
    public EmployeeLeave updateEmployeeLeave(EmployeeLeave employeeLeave) {
        return leaveRepository.save(employeeLeave);
    }

    @Override
    public void deleteEmployeeLeave(Long id) {

        leaveRepository.deleteById(id);
    }

    @Override
    public Optional<EmployeeLeave> getEmployeeLeaveDetailsById(Long id) {
        return leaveRepository.findById(id);
    }
}
