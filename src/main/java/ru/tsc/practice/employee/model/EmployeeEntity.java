package ru.tsc.practice.employee.model;

import ru.tsc.practice.department.model.DepartmentEntity;
import ru.tsc.practice.position.model.PositionEntity;
import ru.tsc.practice.util.BigDecimalConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @NotNull
    @Column(name = "gender", nullable = false)
    private int gender;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "department", nullable = false)
    private DepartmentEntity department;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    @NotNull
    @Column(name = "grade", nullable = false)
    private Long grade;

    @NotNull
    @Convert(converter = BigDecimalConverter.class) //convert BigDecimal to Long(123.75 <-->  12375(100))
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @NotNull
    @Column(nullable = false)
    private Boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }
}