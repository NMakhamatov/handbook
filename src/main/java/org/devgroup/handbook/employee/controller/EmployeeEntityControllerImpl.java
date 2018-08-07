package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.employee.controller.EmployeeEntityController;
import org.devgroup.handbook.employee.service.EmployeeEntityService;
import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "api/employee/")
public class EmployeeEntityControllerImpl implements EmployeeEntityController {
    private EmployeeEntityService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeEntityService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Response createEmployee(CreateEmployee createEmployeeRequest) {
        return null;
    }

    @Override
    public Response transferEmployee(TransferEmployee transferEmployeeRequest) {
        return null;
    }

    @Override
    public Response changeEmployee(ChangeEmployee changeEmployeeRequest) {
        return null;
    }

    @Override
    public Response removeEmployee(Long id) {
        return null;
    }
}
