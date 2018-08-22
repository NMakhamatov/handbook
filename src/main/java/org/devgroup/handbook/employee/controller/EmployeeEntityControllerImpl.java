package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.employee.service.EmployeeEntityService;
import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.EmployeeDto;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;
import org.devgroup.handbook.history.HistoryDto;
import org.devgroup.handbook.history.HistoryService;
import org.devgroup.handbook.util.CustomDataOut;
import org.devgroup.handbook.util.CustomSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/employee/")
public class EmployeeEntityControllerImpl implements EmployeeEntityController {
    private EmployeeEntityService employeeService;
    private HistoryService historyService;

    @Autowired
    public EmployeeEntityControllerImpl(EmployeeEntityService employeeService,HistoryService historyService) {
        this.employeeService = employeeService;
        this.historyService = historyService;
    }

    //good
    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomDataOut> findById(@PathVariable Long id) {
        EmployeeEntity employee = employeeService.findById(id);

        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setSurName(employee.getSurname());
        if (employee.getPatronymic() != null) dto.setMiddleName(employee.getPatronymic());
        dto.setBirthDate(employee.getBirthDate().toString());
        dto.setDepartmentName(employee.getDepartment().getName());
        dto.setPositionName(employee.getPosition().getName());
        dto.setGender(Integer.toString(employee.getGender()));

        CustomDataOut<EmployeeDto> dataOut = new CustomDataOut<>(dto);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
    }

    //works not perfectly
    //todo:salary not correct
    @Override
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<CustomDataOut> createEmployee(@RequestBody CreateEmployee createEmployeeRequest) {
       CreateResponse createResponse = employeeService.createEmployee(createEmployeeRequest);
        CustomDataOut<CreateResponse> dataOut = new CustomDataOut<>(createResponse);
        return  new ResponseEntity<CustomDataOut>(dataOut, HttpStatus.OK);
    }

    //good
    @Override
    @PutMapping(value = "/transferEmployee")
    public ResponseEntity transferEmployee(@RequestBody TransferEmployee transferEmployeeRequest) {
        employeeService.transferEmployee(transferEmployeeRequest);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    //good
    @Override
    @PutMapping(value = "/changeEmployee")
    public ResponseEntity changeEmployee(@RequestBody ChangeEmployee changeEmployeeRequest) {
        employeeService.changeEmployee(changeEmployeeRequest);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    //good
    @Override
    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/history")
    public ResponseEntity history(@PathVariable Long id) {
        List<HistoryDto> dto = historyService.empHistory(id);
        CustomDataOut<List<HistoryDto>> dataOut = new CustomDataOut<>(dto);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
    }
}
