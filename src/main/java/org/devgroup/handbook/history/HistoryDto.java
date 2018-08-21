package org.devgroup.handbook.history;

import org.devgroup.handbook.employee.view.EmployeeDto;

import java.util.Date;

public class HistoryDto {
    private String event ;
    private Date startDate;
    private Date endDate;
    private EmployeeDto employeeDto;

    public HistoryDto(String event, Date startDate, Date endDate, EmployeeDto employeeDto) {
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeDto = employeeDto;
    }

    public String getEvent() {
        return event;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }
}
