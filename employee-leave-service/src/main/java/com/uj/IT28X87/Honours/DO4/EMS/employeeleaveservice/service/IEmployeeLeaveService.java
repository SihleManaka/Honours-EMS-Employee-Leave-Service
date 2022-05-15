package com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.service;

import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.entity.EmployeeLeave;

import java.util.Optional;

public interface IEmployeeLeaveService {

    EmployeeLeave saveEmployeeLeave(EmployeeLeave employeeLeave);

    EmployeeLeave updateEmployeeLeave(EmployeeLeave employeeLeave);

    void deleteEmployeeLeave(Long id);

    Optional<EmployeeLeave> getEmployeeLeaveDetailsById(Long id);


}
