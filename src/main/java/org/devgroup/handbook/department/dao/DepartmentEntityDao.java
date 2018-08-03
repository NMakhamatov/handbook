package org.devgroup.handbook.department.dao;



import org.devgroup.handbook.department.model.DepartmentEntity;
import org.hibernate.Session;

import java.util.List;

public interface DepartmentEntityDao {
    DepartmentEntity getDepartmentById(Long id);
    void update(DepartmentEntity department);
    void save(DepartmentEntity department);
    void delete(Long id);
    List<DepartmentEntity> getSubDepartment(Long id);
    void openSession();
    Session getCurrentSession();
    void closeSession();
}
