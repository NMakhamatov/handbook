package ru.tsc.practice.history;

import ru.tsc.practice.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class HistoryDao implements EntityDao<HistoryEntity,Long> {
    private final EntityManager entityManager ;

    @Autowired
    public HistoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<HistoryEntity> getAll() {
        return null;
    }

    @Override
    public HistoryEntity getEntityById(Long id) {
        return entityManager.find(HistoryEntity.class,id);
    }

    @Override
    public void update(HistoryEntity entity) {

    }

    @Override
    public void delete(HistoryEntity entity) {

    }

    @Override
    public Long create(HistoryEntity entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery);
    }
}
