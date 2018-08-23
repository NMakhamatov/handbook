package ru.tsc.practice.department.controller;

import ru.tsc.practice.department.view.CreateView;
import ru.tsc.practice.department.view.Reassignment;
import org.springframework.http.ResponseEntity;

public interface DepartmentEntityController {
    ResponseEntity createDepartment(CreateView createView);
    ResponseEntity searchDepartmentById(Long id);
    ResponseEntity closeDepartment(Long id);
    ResponseEntity getSubDepartments(Long parentId);
    ResponseEntity reassignDepartment(Reassignment reassignment);
}
