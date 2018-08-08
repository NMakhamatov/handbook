package org.devgroup.handbook.employee.service;

import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEntityServiceImpl implements EmployeeEntityService{
    @Override
    public CreateResponse createEmployee(CreateEmployee createEmployeeRequest) {
        return null;
    }

    @Override
    public void transferEmployee(TransferEmployee transferEmployeeRequest) {
    }

    @Override
    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        return null;
    }

    @Override
    public void removeEmployee(long id) {

    }
}
