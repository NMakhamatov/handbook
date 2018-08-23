package ru.tsc.practice.employee.service;

import ru.tsc.practice.employee.model.EmployeeEntity;
import ru.tsc.practice.employee.view.ChangeEmployee;
import ru.tsc.practice.employee.view.CreateEmployee;
import ru.tsc.practice.employee.view.TransferEmployee;
import ru.tsc.practice.employee.view.response.CreateResponse;

public interface EmployeeEntityService {

    EmployeeEntity findById(Long id);

    CreateResponse createEmployee(CreateEmployee createEmployeeRequest);

    void transferEmployee(TransferEmployee transferEmployeeRequest);

    void changeEmployee(ChangeEmployee changeEmployeeRequest);

    void removeEmployee(long id);
}
