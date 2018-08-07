package org.devgroup.handbook.employee.service;

import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;

public interface EmployeeEntityService {
    String createEmployee(CreateEmployee createEmployeeRequest);

    String transferEmployee(TransferEmployee transferEmployeeRequest);

    String changeEmployee(ChangeEmployee changeEmployeeRequest);

    void removeEmployee(long id);
}
