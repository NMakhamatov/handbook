package ru.tsc.practice.department.service;

import ru.tsc.practice.department.view.CreateView;
import ru.tsc.practice.department.view.DepartmentEntityDto;
import ru.tsc.practice.department.view.Reassignment;
import ru.tsc.practice.department.view.ResponseDepById;
import ru.tsc.practice.employee.model.EmployeeEntity;

import java.util.List;

public interface DepartmentEntityService {

    void closeDepartment(long id);

    List<DepartmentEntityDto> searchListBranches(long id);

    ResponseDepById createDepartment(CreateView createDepartmentRequest);

    void reassignDepartment(Reassignment reassignmentRequest);

    List<EmployeeEntity> getListEmployeeOfDepartment(long id);

    DepartmentEntityDto searchDepartmentById(long id);
}
