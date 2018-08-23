package ru.tsc.practice.department.view;

public class DepartmentEntityDto {
    private String name;
    private String managerName;
    private String parentDepartment;

    public DepartmentEntityDto(String name, String managerName, String parentDepartment) {
        this.name = name;
        this.managerName = managerName;
        this.parentDepartment = parentDepartment;
    }

    public DepartmentEntityDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(String parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
}
