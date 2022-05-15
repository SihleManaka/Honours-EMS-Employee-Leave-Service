package com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.repository;

import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeLeaveRepository extends JpaRepository<EmployeeLeave,Long> {
}
