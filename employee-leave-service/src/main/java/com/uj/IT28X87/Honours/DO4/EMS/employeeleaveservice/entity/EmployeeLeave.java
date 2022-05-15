package com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ems_employee_leave")
public class EmployeeLeave {

    @Id
    @Column(name = "ems_employee_leaveID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    //TODO normalize to date entity
    @Column(name = "date_leave_logged")
    private Date date_leave_logged;
    @Column(name = "from_leave_date")
    private Date from_leave_date;
    @Column(name = "to_leave_date")
    private Date to_leave_date;

    //TODO normalize to leaveType
    @Column(name = "reason")
    private String reason;
    @Column(name = "leave_balance")
    private double leave_balance;

    @Column(name = "leave_status")
    private String leave_status;
}
