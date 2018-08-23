package ru.tsc.practice.department.service;

import ru.tsc.practice.department.model.DepartmentEntity;
import ru.tsc.practice.department.view.CreateView;
import ru.tsc.practice.department.view.DepartmentEntityDto;
import ru.tsc.practice.department.view.Reassignment;
import ru.tsc.practice.department.view.ResponseDepById;
import ru.tsc.practice.employee.model.EmployeeEntity;
import ru.tsc.practice.exception.exceptions.DepartmentException;
import ru.tsc.practice.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentEntityServiceImpl implements DepartmentEntityService {
    private EntityDao<EmployeeEntity,Long> employeeDao;
    private EntityDao<DepartmentEntity,Long> departmentDao;
    private final EntityManager entityManager;

    @Autowired
    public DepartmentEntityServiceImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }


    @Autowired
    public void setEmployeeDao(EntityDao<EmployeeEntity, Long> employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Autowired
    public void setDepartmentDao(EntityDao<DepartmentEntity, Long> departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void closeDepartment(long id) {
        List<DepartmentEntityDto> subdeps = searchListBranches(id);
        if(subdeps.size() != 0)
            throw new DepartmentException("Отдел содержит другие отделы. Удаление невозможно.");
        List<EmployeeEntity> empsOfDep = getListEmployeeOfDepartment(id);
        if(empsOfDep.size() != 0)
        throw  new DepartmentException("В отделе есть сотрудники. Удаление невозможно");
        DepartmentEntity departmentToDelete = departmentDao.getEntityById(id);
        departmentDao.delete(departmentToDelete);
    }

    @Override
    public List<DepartmentEntityDto> searchListBranches(long id) {
        List<DepartmentEntity> listOfDepartment;
//
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaQuery<DepartmentEntity> departmentQuery = criteriaBuilder.createQuery(DepartmentEntity.class);
//            Root<DepartmentEntity> depRoot = departmentQuery.from(DepartmentEntity.class);
//            departmentQuery.where(criteriaBuilder.equal(depRoot.get("parentDepartment"), id));
//            listOfDepartment = entityManager.createQuery(departmentQuery).getResultList();
//
            List<DepartmentEntityDto> result = new ArrayList<>();
//            for(DepartmentEntity d : listOfDepartment)
//            {
//                DepartmentEntityDto departmentEntityDto = new DepartmentEntityDto(d.getName(),d.getHeadEmployee().getName(),d.getParentDepartment().getName());
//                result.add(departmentEntityDto);
//            }
        return result;
    }

    @Override
    public ResponseDepById createDepartment(CreateView createDepartmentRequest) {
        System.out.println("СЕРВИС: СОЗДАНИЕ НОВОГО ОТДЕЛА");
      DepartmentEntity parent = departmentDao.getEntityById(createDepartmentRequest.getParent_department());
//        if(parent==null)
//        {
//            throw new DepartmentException("Не существует такого родительского департамента");
//        }
        EmployeeEntity manager = employeeDao.getEntityById(createDepartmentRequest.getHead());
        if(!manager.getActive())
        {
            throw new DepartmentException("Не существует такого работника.");
        }

        DepartmentEntity departmentEntityToSave = new DepartmentEntity();
        departmentEntityToSave.setHeadEmployee(manager);
        departmentEntityToSave.setParentDepartment(parent);
        departmentEntityToSave.setName(createDepartmentRequest.getName());
        Long id = departmentDao.create(departmentEntityToSave);

        return new ResponseDepById(id);
    }

    @Override
    public void reassignDepartment(Reassignment reassignmentRequest) {

        DepartmentEntity depToReassign = departmentDao.getEntityById(reassignmentRequest.getDep());
        if(depToReassign==null)
        throw new DepartmentException("Не существует департамента от которого надо отделить.");
        DepartmentEntity newParentDep = departmentDao.getEntityById(reassignmentRequest.getNewParId());
        if(newParentDep==null)
            throw new DepartmentException("Не существует департамента которому нужно переподчинить отдел.");
        depToReassign.setParentDepartment(newParentDep);
        departmentDao.update(depToReassign);
    }

    @Override
    public List<EmployeeEntity> getListEmployeeOfDepartment(long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> employeeRoot = criteriaQuery.from(EmployeeEntity.class);
        criteriaQuery.select(employeeRoot);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(employeeRoot.get("department"),id),
                criteriaBuilder.equal(employeeRoot.get("isActive"),true)));
        List<EmployeeEntity> listOfEmployee = employeeDao.getWithCriteria(criteriaQuery).getResultList();
        return listOfEmployee;
    }

    @Override
    public DepartmentEntityDto searchDepartmentById(long id) {
        DepartmentEntity department = departmentDao.getEntityById(id);
        DepartmentEntityDto dto = new DepartmentEntityDto();
            dto.setName(department.getName());
            if (department.getHeadEmployee()!= null) dto.setManagerName(department.getHeadEmployee().getName());
            if (department.getParentDepartment() != null) dto.setParentDepartment(department.getParentDepartment().getName());
        return dto;
    }


}
