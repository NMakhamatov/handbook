package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.springframework.http.ResponseEntity;


public interface EmployeeEntityController {

    ResponseEntity findById(Long id);

    ResponseEntity createEmployee(CreateEmployee createEmployeeRequest);

    ResponseEntity transferEmployee(TransferEmployee transferEmployeeRequest);

    ResponseEntity changeEmployee(ChangeEmployee changeEmployeeRequest);

    ResponseEntity removeEmployee(Long id);

}
