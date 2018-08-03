package org.devgroup.handbook.department.service;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.UpdateView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentEntityServiceImpl implements DepartmentEntityService {
    @Override
    public DepartmentEntity searchDepartmentById(Long id) {
        return null;
    }

    @Override
    public void createDepartment(CreateView createView) {

    }

    @Override
    public void reassignDepartment(UpdateView updateView) {

    }

    @Override
    public void closeDepartment(Long id) {

    }

    @Override
    public List<DepartmentEntity> getSubDepartments(Long parentId) {
        return null;
    }
}
