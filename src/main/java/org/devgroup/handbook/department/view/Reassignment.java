package org.devgroup.handbook.department.view;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Reassignment {

    private long dep;

    private long newParId;

    public long getDep() {
        return dep;
    }

    public void setDep(long dep) {
        this.dep = dep;
    }

    public long getNewParId() {
        return newParId;
    }

    public void setNewParId(long newParId) {
        this.newParId = newParId;
    }
}
