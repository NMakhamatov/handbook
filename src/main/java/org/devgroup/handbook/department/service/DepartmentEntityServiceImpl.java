package org.devgroup.handbook.department.service;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.Reassignment;
import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.util.EntityDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentEntityServiceImpl implements DepartmentEntityService {
    private EntityDao<DepartmentEntity,Long> depdao;

    @Override
    public void closeDepartment(long id) {

    }

    @Override
    public List<DepartmentEntity> searchListBranches(long id) {
        return null;
    }

    @Override
    public Long createDepartment(CreateView createDepartmentRequest) {
        return null;
    }

    @Override
    public void reassignDepartment(Reassignment reassignmentRequest) {

    }

    @Override
    public List<EmployeeEntity> getListEmployeeOfDepartment(long id) {
        return null;
    }

    @Override
    public DepartmentEntity searchDepartmentById(long id) {
        return null;
    }
}
