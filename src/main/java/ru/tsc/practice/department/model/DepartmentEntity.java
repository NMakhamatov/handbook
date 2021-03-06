package ru.tsc.practice.department.model;


import ru.tsc.practice.employee.model.EmployeeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "head", referencedColumnName = "id")
    private EmployeeEntity headEmployee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_department")
    private DepartmentEntity parentDepartment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getHeadEmployee() {
        return headEmployee;
    }

    public void setHeadEmployee(EmployeeEntity headEmployee) {
        this.headEmployee = headEmployee;
    }

    public DepartmentEntity getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(DepartmentEntity parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
}
