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
        System.out.println("ДАО: ПОЛУЧЕНИЕ ОТДЕЛА ПО ID" + " id = " + id);
        DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, id);
//        if (departmentEntity == null) throw new RuntimeException("DAO: NULL!");
        return departmentEntity;
    }

    @Override
    @Transactional
    public void update(DepartmentEntity entity) {
        System.out.println("ДАО: ОБНОВЛЕНИЕ ОТДЕЛА ПО СУЩНОСТИ");
        entityManager.merge(entity);
        entityManager.flush();

    }

    @Override
    @Transactional
    public void delete(DepartmentEntity entity) {
        System.out.println("ДАО: УДАЛЕНИЕ ОТДЕЛА ПО СУЩНОСТИ");
        DepartmentEntity departmentEntity = entityManager.getReference(DepartmentEntity.class, entity.getId());
        entityManager.remove(departmentEntity);
        entityManager.flush();

    }

    @Override
    @Transactional
    public Long create(DepartmentEntity entity) {
        System.out.println("ДАО: СОЗДАНИЕ НОВОГО ОТДЕЛА");
        entityManager.persist(entity);
         return  entity.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        System.out.println("ДАО: ПОЛУЧЕНИЕ ОТДЕЛА ПО КРИТЕРИЯМ");
        return entityManager.createQuery(criteriaQuery);
    }
}
