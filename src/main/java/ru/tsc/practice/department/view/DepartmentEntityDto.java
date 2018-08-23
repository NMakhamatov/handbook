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

    public String getName() {
        return name;
    }


    public String getManagerName() {
        return managerName;
    }


    public String getParentDepartment() {
        return parentDepartment;
    }

}
