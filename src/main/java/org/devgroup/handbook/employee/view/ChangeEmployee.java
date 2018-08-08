package org.devgroup.handbook.employee.view;

//import lombok.*;

import java.math.BigDecimal;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class ChangeEmployee {
//    @NonNull
    private long employeeId;
    private long positionId;
    private long grade;
    private BigDecimal salary;

    public boolean isCorrect() {
        if (positionId != 0 || grade != 0 || salary != null)
            return true;
        else
            return false;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
