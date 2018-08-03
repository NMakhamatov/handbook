package org.devgroup.handbook.department.dao;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class DepartmentEntityDaoImpl  implements DepartmentEntityDao {




    @Override
    public DepartmentEntity getDepartmentById(Long id) {
        return null;
    }

    @Override
    public void update(DepartmentEntity department) {

    }

    @Override
    public void save(DepartmentEntity department) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<DepartmentEntity> getSubDepartment(Long id) {
        return null;
    }

    @Override
    public void openSession() {

    }

    @Override
    public void closeSession() {

    }

    @Override
    public Session getCurrentSession() {
        return null;
    }
}
