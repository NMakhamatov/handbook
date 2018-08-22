package ru.tsc.practice.history;

import ru.tsc.practice.employee.view.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HistoryService {
    private HistoryDao historyDao;
    private EntityManager entityManager;

    public static Date endDate;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            endDate = simpleDateFormat.parse("06.06.6666");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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
        List<HistoryDto> result = new ArrayList<>();
        for(HistoryEntity h:historyEntities)
        {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(h.getEmployee().getId());
            dto.setName(h.getEmployee().getName());
            dto.setSurName(h.getEmployee().getSurname());
            if (h.getEmployee().getPatronymic() != null) dto.setMiddleName(h.getEmployee().getPatronymic());
            dto.setBirthDate(h.getEmployee().getBirthDate().toString());
            dto.setDepartmentName(h.getEmployee().getDepartment().getName());
            dto.setPositionName(h.getEmployee().getPosition().getName());
            dto.setGender(Integer.toString(h.getEmployee().getGender()));
            HistoryDto historyDto = new HistoryDto(h.getEvent(),h.getDateStart(),h.getDateEnd(),dto);
            result.add(historyDto);
        }
        return result;
    }
    public HistoryEntity historyEntityPrev(Long empId,Date date)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HistoryEntity> criteriaQuery = criteriaBuilder.createQuery(HistoryEntity.class);
        Root<HistoryEntity> root = criteriaQuery.from(HistoryEntity.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("employee"),empId),
                criteriaBuilder.equal(root.get("dateEnd"),date)

        ));
        return historyDao.getWithCriteria(criteriaQuery).getSingleResult();
    }
}
