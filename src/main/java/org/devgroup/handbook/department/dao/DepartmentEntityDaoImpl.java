package org.devgroup.handbook.department.dao;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.util.EntityDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DepartmentEntityDaoImpl  implements EntityDao<DepartmentEntity,Long> {
    private final EntityManager entityManager ;

    @Autowired
    public DepartmentEntityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DepartmentEntity> getAll() {
       return entityManager.createQuery("from DepartmentEntity", DepartmentEntity.class).getResultList();
    }

    @Override
    public DepartmentEntity getEntityById(Long id) {
        DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, id);
        if (departmentEntity == null) throw new RuntimeException("DAO: NULL!");
        return departmentEntity;
    }

    @Override
    @Transactional
    public void update(DepartmentEntity entity) {
        entityManager.merge(entity);
        entityManager.flush();

    }

    @Override
    @Transactional
    public void delete(DepartmentEntity entity) {
        DepartmentEntity departmentEntity = entityManager.getReference(DepartmentEntity.class, entity.getId());
        entityManager.remove(departmentEntity);
        entityManager.flush();

    }

    @Override
    @Transactional
    public Long create(DepartmentEntity entity) {
        entityManager.persist(entity);
         return  entity.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery);
    }
}
