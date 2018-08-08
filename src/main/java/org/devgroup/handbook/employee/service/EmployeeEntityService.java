package org.devgroup.handbook.employee.service;

import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;

public interface EmployeeEntityService {
    CreateResponse createEmployee(CreateEmployee createEmployeeRequest);

    void transferEmployee(TransferEmployee transferEmployeeRequest);

    String changeEmployee(ChangeEmployee changeEmployeeRequest);

    void removeEmployee(long id);
}
