package com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.controller;

import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.entity.EmployeeLeave;
import com.uj.IT28X87.Honours.DO4.EMS.employeeleaveservice.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("v1/employee-leave-api")
public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveService leaveService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeave> getEmployeeLeaveById(@PathVariable("id") Long id){

        return leaveService.getEmployeeLeaveDetailsById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeLeave createEmployeeLeave(@RequestBody EmployeeLeave employeeLeave){

        return leaveService.saveEmployeeLeave(employeeLeave);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeLeave> updateEmployeeLeave(@RequestBody EmployeeLeave employeeLeave, @PathVariable("id")Long id){

        Date date = new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return leaveService.getEmployeeLeaveDetailsById(id)
                .map(savedEmployeeLeave ->{
                    savedEmployeeLeave.setId(id);
                    savedEmployeeLeave.setEmployeeId(employeeLeave.getEmployeeId());
                    savedEmployeeLeave.setLeave_balance(employeeLeave.getLeave_balance());
                    savedEmployeeLeave.setDate_leave_logged(date);
                    savedEmployeeLeave.setFrom_leave_date(employeeLeave.getFrom_leave_date());
                    savedEmployeeLeave.setTo_leave_date(employeeLeave.getTo_leave_date());
                    savedEmployeeLeave.setReason(employeeLeave.getReason());

                    EmployeeLeave updatedEmployeeLeave = leaveService.updateEmployeeLeave(savedEmployeeLeave);

                    return new ResponseEntity<EmployeeLeave>(updatedEmployeeLeave, HttpStatus.OK);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeLeave(@PathVariable("id") long id){

        leaveService.deleteEmployeeLeave(id);

        return  new ResponseEntity<String>("Leave deleted ", HttpStatus.ACCEPTED);
    }

}
