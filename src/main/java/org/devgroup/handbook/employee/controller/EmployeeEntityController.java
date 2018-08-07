package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;

import javax.xml.ws.Response;

public interface EmployeeEntityController {
    Response createEmployee(CreateEmployee createEmployeeRequest);

    Response transferEmployee(TransferEmployee transferEmployeeRequest);

    Response changeEmployee(ChangeEmployee changeEmployeeRequest);

    Response removeEmployee(Long id);

}
