package org.devgroup.handbook.department.service;

import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.Reassignment;
import org.devgroup.handbook.department.view.ResponseDepById;
import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.exception.exceptions.DepartmentException;
import org.devgroup.handbook.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    }

    @Override
    public List<DepartmentEntity> searchListBranches(long id) {
        List<DepartmentEntity> listOfDepartment;

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<DepartmentEntity> departmentQuery = criteriaBuilder.createQuery(DepartmentEntity.class);
            Root<DepartmentEntity> depRoot = departmentQuery.from(DepartmentEntity.class);
            departmentQuery.where(criteriaBuilder.equal(depRoot.get("parentDepartment"), id));
            listOfDepartment = entityManager.createQuery(departmentQuery).getResultList();

        return listOfDepartment;
    }

    @Override
    public ResponseDepById createDepartment(CreateView createDepartmentRequest) {
        DepartmentEntity parent = departmentDao.getEntityById(createDepartmentRequest.getParentId());
        if(parent==null)
        {
            throw new DepartmentException("Не существует такого родительского департамента");
        }
        EmployeeEntity manager = employeeDao.getEntityById(createDepartmentRequest.getManagerId());
        if(manager==null)
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

        DepartmentEntity depToReassign = departmentDao.getEntityById(reassignmentRequest.getIdDepToReassign());
        if(depToReassign==null)
        throw new DepartmentException("Не существует департамента от которого надо отделить.");
        DepartmentEntity newParentDep = departmentDao.getEntityById(reassignmentRequest.getIdNewParentDep());
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
        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("department"), id));
        List<EmployeeEntity> listOfEmployee = employeeDao.getWithCriteria(criteriaQuery).getResultList();
        return listOfEmployee;
    }

    @Override
    public DepartmentEntity searchDepartmentById(long id) {
        return departmentDao.getEntityById(id);
    }
}
