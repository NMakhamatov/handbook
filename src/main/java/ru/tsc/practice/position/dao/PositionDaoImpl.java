package ru.tsc.practice.position.dao;

import ru.tsc.practice.position.model.PositionEntity;
import ru.tsc.practice.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PositionDaoImpl implements EntityDao<PositionEntity,Long>{
    private final EntityManager entityManager;

    @Autowired
    public PositionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PositionEntity> getAll() {
        return null;
    }

    @Override
    public PositionEntity getEntityById(Long id) {
        PositionEntity positionEntity = entityManager.find(PositionEntity.class,id);
        return positionEntity;
    }

    @Override
    public void update(PositionEntity entity) {

    }

    @Override
    public void delete(PositionEntity entity) {

    }

    @Override
    public Long create(PositionEntity entity) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return null;
    }
}
