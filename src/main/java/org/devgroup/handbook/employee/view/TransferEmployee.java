package org.devgroup.handbook.employee.view;

//import lombok.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class TransferEmployee {
//    @NonNull
    private long employeeId;
//    @NonNull
    private long depIdFrom; //todo: is redundant?
//    @NonNull
    private long depIdTo;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getDepIdFrom() {
        return depIdFrom;
    }

    public void setDepIdFrom(long depIdFrom) {
        this.depIdFrom = depIdFrom;
    }

    public long getDepIdTo() {
        return depIdTo;
    }

    public void setDepIdTo(long depIdTo) {
        this.depIdTo = depIdTo;
    }
}
