package org.devgroup.handbook.employee.service;

import org.devgroup.handbook.department.dao.DepartmentEntityDaoImpl;
import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.employee.dao.EmployeeEntityDaoImpl;
import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.employee.view.ChangeEmployee;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;
import org.devgroup.handbook.exception.EmployeeException;
import org.devgroup.handbook.position.dao.PositionDaoImpl;
import org.devgroup.handbook.position.model.PositionEntity;
import org.devgroup.handbook.util.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEntityServiceImpl implements EmployeeEntityService{

    private EntityDao<EmployeeEntity,Long> employeeDao;
    private EntityDao<PositionEntity,Long> positionDao;
    private EntityDao<DepartmentEntity,Long> departmentDao;

    @Autowired
    public EmployeeEntityServiceImpl(EmployeeEntityDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeDao.getEntityById(id);
    }

    @Override
    public CreateResponse createEmployee(CreateEmployee createEmployeeRequest) {
        String exceptionText = "";
        if ((createEmployeeRequest.getName()) == null) exceptionText+="Имя не введено; ";
        if ((createEmployeeRequest.getSurname()) == null) exceptionText+="Фамилия не введена; ";
        if ((createEmployeeRequest.getBirthDate()) == null) exceptionText+="Не указана дата рождения; ";
        if ((createEmployeeRequest.getGender()) == null) exceptionText+="не указан пол; ";
        if ((createEmployeeRequest.getGrade()) == null) exceptionText+="не указан грейд";
        if ((createEmployeeRequest.getIdDepartment()) == null) exceptionText+="не указана департамент";
        if ((createEmployeeRequest.getIdPosition()) == null) exceptionText+="не указана должность";
        if ((createEmployeeRequest.getSalary()) == null) exceptionText+="не указана зарплата";

        if (!((exceptionText).equals(""))) throw new EmployeeException(exceptionText);

        PositionEntity position = positionDao.getEntityById(createEmployeeRequest.getIdPosition());
        DepartmentEntity department = departmentDao.getEntityById(createEmployeeRequest.getIdDepartment());

        if (position == null) throw new RuntimeException("не найдена должность");
        if (department == null) throw new RuntimeException("не найден департамент");

        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(createEmployeeRequest.getName());
        employee.setSurname(createEmployeeRequest.getSurname());
        employee.setBirthDate(createEmployeeRequest.getBirthDate());
        employee.setPatronymic(createEmployeeRequest.getMiddleName());
        employee.setPosition(position);
        employee.setDepartment(department);
        employee.setSalary(createEmployeeRequest.getSalary());
        employee.setGender(createEmployeeRequest.getGender());
        Long id = employeeDao.create(employee);
        CreateResponse createResponse = new CreateResponse(id);
        return createResponse;
    }

    @Override
    public void transferEmployee(TransferEmployee transferEmployeeRequest) {
        DepartmentEntity dep = departmentDao.getEntityById(transferEmployeeRequest.getDepIdFrom());
        EmployeeEntity employee = employeeDao.getEntityById(transferEmployeeRequest.getEmployeeId());
        employee.setDepartment(dep);
        employeeDao.update(employee);
    }

    @Override
    public void changeEmployee(ChangeEmployee changeEmployeeRequest) {
        EmployeeEntity employee = employeeDao.getEntityById(changeEmployeeRequest.getEmployeeId());
        if (changeEmployeeRequest.getGrade() != 0) employee.setGrade(changeEmployeeRequest.getGrade());
        if (changeEmployeeRequest.getPositionId() != 0 ) {
            PositionEntity position = positionDao.getEntityById(changeEmployeeRequest.getPositionId());
            employee.setPosition(position);
        } if (changeEmployeeRequest.getSalary() != null) employee.setSalary(changeEmployeeRequest.getSalary());
        employeeDao.update(employee);
    }

    @Override
    public void removeEmployee(long id) {
        EmployeeEntity entity = employeeDao.getEntityById(id);
        employeeDao.delete(entity);
    }
}
