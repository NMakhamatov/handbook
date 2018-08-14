package org.devgroup.handbook.employee.view;

//import lombok.*;
import org.devgroup.handbook.dto.Certificate;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class CreateEmployee {
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

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
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

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @NotNull
    private String name;
//    @NonNull
    @NotNull
    private String surname;
    private String patronymic;
//    @NonNull
    @NotNull
    private int gender;
//    @NonNull
    @NotNull
    private Date birthDate;
//    @NonNull
    @NotNull
    private Long idDepartment;
//    @NonNull
    @NotNull
    private Long idPosition;
    @NotNull
    private Long grade;
//    @NonNull
    @NotNull
    private BigDecimal salary;
    private List<Certificate> certificates;

}
