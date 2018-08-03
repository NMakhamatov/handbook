package org.devgroup.handbook.department.service;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.UpdateView;

import java.util.List;

public interface DepartmentEntityService {
    DepartmentEntity searchDepartmentById(Long id);
    void createDepartment(CreateView createView);
    void reassignDepartment(UpdateView updateView);
    void closeDepartment(Long id);
    List<DepartmentEntity> getSubDepartments(Long parentId);
}
