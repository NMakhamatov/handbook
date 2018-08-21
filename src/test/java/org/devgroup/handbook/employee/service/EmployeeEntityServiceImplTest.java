package org.devgroup.handbook.employee.service;

import org.devgroup.handbook.department.dao.DepartmentEntityDaoImpl;
import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.employee.dao.EmployeeEntityDaoImpl;
import org.devgroup.handbook.employee.model.EmployeeEntity;
import org.devgroup.handbook.employee.view.CreateEmployee;
import org.devgroup.handbook.employee.view.TransferEmployee;
import org.devgroup.handbook.employee.view.response.CreateResponse;
import org.devgroup.handbook.exception.exceptions.EmployeeException;
import org.devgroup.handbook.position.dao.PositionDaoImpl;
import org.devgroup.handbook.position.model.PositionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeEntityServiceImplTest {
    @Mock
    private PositionDaoImpl positionDao;

    @Mock
    private EmployeeEntityDaoImpl employeeDao;

    @Mock
    private DepartmentEntityDaoImpl departmentDao;

    @InjectMocks
    private EmployeeEntityServiceImpl employeeService;


    @Test
    public void findByIdWhenSuccessfulTest() {
        EmployeeEntity expectedEmployee = new EmployeeEntity();
        when(employeeDao.getEntityById(1L)).thenReturn(expectedEmployee);
        EmployeeEntity returnedEmployee = employeeService.findById(1L);
        assertEquals(expectedEmployee,returnedEmployee);
    }

    @Test(expected = EmployeeException.class)
    public void findByIdWhenFailTest() {
        when(employeeDao.getEntityById(1L)).thenReturn(null);
        employeeService.findById(1L);
    }

    @Test
    public void createEmployeeWhenSuccessfulTest() {
        CreateEmployee expectedEmployee = new CreateEmployee();
            expectedEmployee.setName("testName");
            expectedEmployee.setSurname("testSurName");
            expectedEmployee.setBirthDate(new Date());
            expectedEmployee.setGender(1);
            expectedEmployee.setGrade(5L);
            expectedEmployee.setIdDepartment(1L);
            expectedEmployee.setIdPosition(1L);
            expectedEmployee.setSalary(new BigDecimal("10000"));

        when(positionDao.getEntityById(anyLong())).thenReturn(new PositionEntity());
        when(departmentDao.getEntityById(anyLong())).thenReturn(new DepartmentEntity());

        when(employeeDao.create(any(EmployeeEntity.class))).thenReturn(1L);
        CreateResponse expectedResponse = new CreateResponse(1L);

        CreateResponse returnedResponse = employeeService.createEmployee(expectedEmployee);

        assertEquals(expectedResponse,returnedResponse);
    }
    @Test(expected = RuntimeException.class)
    public void createEmployeeWhenFailTest() {
        CreateEmployee expectedEmployee = new CreateEmployee();
            expectedEmployee.setName("testName");
            expectedEmployee.setSurname("testSurName");
            expectedEmployee.setBirthDate(new Date());
            expectedEmployee.setGender(1);
            expectedEmployee.setGrade(5L);
            expectedEmployee.setIdDepartment(1L);
            expectedEmployee.setIdPosition(1L);
            expectedEmployee.setSalary(new BigDecimal("10000"));

        when(positionDao.getEntityById(anyLong())).thenReturn(null);
        when(departmentDao.getEntityById(anyLong())).thenReturn(null);

        when(employeeDao.create(any(EmployeeEntity.class))).thenReturn(1L);
    }

    @Test
    public void transferEmployeeWhenSuccessfulTest() {
        TransferEmployee transferEmployee = new TransferEmployee();
            transferEmployee.setEmployeeId(1L);
            transferEmployee.setDepIdTo(1L);
        DepartmentEntity newDep = new DepartmentEntity();
            newDep.setId(2L);
        EmployeeEntity employee = new EmployeeEntity();

        when(departmentDao.getEntityById(transferEmployee.getEmployeeId())).thenReturn(newDep);
        when(employeeDao.getEntityById(transferEmployee.getEmployeeId())).thenReturn(employee);

        employeeService.transferEmployee(transferEmployee);
        verify(employeeDao).update(employee);
    }

    @Test
    public void changeEmployee() {
    }

    @Test
    public void removeEmployee() {
    }

}