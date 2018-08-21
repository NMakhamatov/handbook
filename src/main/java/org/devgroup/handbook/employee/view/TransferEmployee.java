package org.devgroup.handbook.employee.view;

public class TransferEmployee {
    private long employeeId;
//    private long depIdFrom; //todo: is redundant?
    private long depIdTo;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

//    public long getDepIdFrom() {
//        return depIdFrom;
//    }
//
//    public void setDepIdFrom(long depIdFrom) {
//        this.depIdFrom = depIdFrom;
//    }

    public long getDepIdTo() {
        return depIdTo;
    }

    public void setDepIdTo(long depIdTo) {
        this.depIdTo = depIdTo;
    }
}
