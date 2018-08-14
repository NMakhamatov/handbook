package org.devgroup.handbook.department.controller;

import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.Reassignment;
import org.devgroup.handbook.department.view.UpdateView;
import org.springframework.http.ResponseEntity;

public interface DepartmentEntityController {
    ResponseEntity createDepartment(CreateView createView);
    ResponseEntity searchDepartmentById(Long id);
    ResponseEntity closeDepartment(Long id);
    ResponseEntity getSubDepartments(Long parentId);
    ResponseEntity reassignDepartment(Reassignment reassignment);
}
