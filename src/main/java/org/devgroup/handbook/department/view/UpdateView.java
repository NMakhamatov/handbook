package org.devgroup.handbook.department.view;

public class UpdateView {
    private Long id;
    private Long parentId;
    private String name;
    private Long managerId;

    public Long getId() {
        return id;
    }



    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
