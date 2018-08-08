package org.devgroup.handbook.department.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devgroup.handbook.employee.model.EmployeeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
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
