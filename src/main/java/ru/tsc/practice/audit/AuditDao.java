package ru.tsc.practice.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tsc.practice.util.EntityDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class AuditDao implements EntityDao<AuditEntity,Long>{

    private final EntityManager entityManager ;

    @Autowired
    public AuditDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Long create(AuditEntity entity) {
        try {
            System.out.println("Creating AuditEntity...");
            entityManager.persist(entity);
            System.out.println("End of creating");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity.getId();
    }

    @Override
    public List<AuditEntity> getAll() {
        return null;
    }

    @Override
    public AuditEntity getEntityById(Long id) {
        return null;
    }

    @Override
    public void update(AuditEntity entity) {

    }

    @Override
    public void delete(AuditEntity entity) {

    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return null;
    }
}
