package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.employee.service.EmployeeEntityService;
import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;
import org.devgroup.handbook.util.CustomDataOut;
import org.devgroup.handbook.util.CustomSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/employee/")
public class EmployeeEntityControllerImpl implements EmployeeEntityController {
    private EmployeeEntityService employeeService;

    @Autowired
    public EmployeeEntityControllerImpl(EmployeeEntityService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<CustomDataOut> createEmployee(@RequestBody CreateEmployee createEmployeeRequest) {
       CreateResponse createResponse = employeeService.createEmployee(createEmployeeRequest);
        CustomDataOut<CreateResponse> dataOut = new CustomDataOut<>(createResponse);
        return  new ResponseEntity<CustomDataOut>(dataOut, HttpStatus.OK);

    }

    @Override
    @PutMapping(value = "/transferEmployee")
    public ResponseEntity transferEmployee(@RequestBody TransferEmployee transferEmployeeRequest) {
        employeeService.transferEmployee(transferEmployeeRequest);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/changeEmployee")
    public ResponseEntity changeEmployee(@RequestBody ChangeEmployee changeEmployeeRequest) {
        employeeService.changeEmployee(changeEmployeeRequest);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }
}
