package org.devgroup.handbook.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class HistoryService {
    private HistoryDao historyDao;
    private EntityManager entityManager;

    @Autowired
    public void setHistoryDao(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<HistoryDto> empHistory(long id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HistoryEntity> criteriaQuery = criteriaBuilder.createQuery(HistoryEntity.class);
        Root<HistoryEntity> root = criteriaQuery.from(HistoryEntity.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("employee"), id));
        List<HistoryEntity> historyEntities = historyDao.getWithCriteria(criteriaQuery).getResultList();
        return null;
        //todo : entities to dto and check does this work properly
    }
}
