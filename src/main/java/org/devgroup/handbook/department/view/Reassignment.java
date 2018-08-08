package org.devgroup.handbook.department.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reassignment {

    private long idDepToReassign;

    private long idNewParentDep;

    public long getIdDepToReassign() {
        return idDepToReassign;
    }

    public void setIdDepToReassign(long idDepToReassign) {
        this.idDepToReassign = idDepToReassign;
    }

    public long getIdNewParentDep() {
        return idNewParentDep;
    }

    public void setIdNewParentDep(long idNewParentDep) {
        this.idNewParentDep = idNewParentDep;
    }
}
