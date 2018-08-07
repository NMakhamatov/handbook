package org.devgroup.handbook.employee.dao;

import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmployeeEntityDaoImpl implements EntityDao<EmployeeEntity,Long>{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeEntityDaoImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class).getResultList();
    }

    @Override
    public EmployeeEntity getEntityById(Long id) {
        return entityManager.find(EmployeeEntity.class, id);
    }

    @Override
    public void update(EmployeeEntity entity) {
        entityManager.merge(entity);
        entityManager.flush();

    }

    @Override
    public void delete(EmployeeEntity entity) {
        EmployeeEntity employeeEntity = entityManager.getReference(EmployeeEntity.class, entity.getId());
        entityManager.remove(employeeEntity);
        entityManager.flush();

    }

    @Override
    public Long create(EmployeeEntity entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery);
    }
}
