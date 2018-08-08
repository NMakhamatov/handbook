package org.devgroup.handbook.department.service;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.Reassignment;
import org.devgroup.handbook.department.view.ResponseDepById;
import org.devgroup.handbook.employee.model.EmployeeEntity;

import java.util.List;

public interface DepartmentEntityService {

    void closeDepartment(long id);

    List<DepartmentEntity> searchListBranches(long id);

    ResponseDepById createDepartment(CreateView createDepartmentRequest);

    void reassignDepartment(Reassignment reassignmentRequest);

    List<EmployeeEntity> getListEmployeeOfDepartment(long id);

    DepartmentEntity searchDepartmentById(long id);
}
