package ru.tsc.practice.employee.controller;

import ru.tsc.practice.employee.view.ChangeEmployee;
import ru.tsc.practice.employee.view.CreateEmployee;
import ru.tsc.practice.employee.view.TransferEmployee;
import org.springframework.http.ResponseEntity;


public interface EmployeeEntityController {

    ResponseEntity findById(Long id);

    ResponseEntity createEmployee(CreateEmployee createEmployeeRequest);

    ResponseEntity transferEmployee(TransferEmployee transferEmployeeRequest);

    ResponseEntity changeEmployee(ChangeEmployee changeEmployeeRequest);

    ResponseEntity removeEmployee(Long id);

}
