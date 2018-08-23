package ru.tsc.practice.department.view;

public class CreateView {
    private Long parent_department;
    private String name;
    private Long head;

    public Long getParent_department() {
        return parent_department;
    }

    public void setParent_department(Long parent_department) {
        this.parent_department = parent_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHead() {
        return head;
    }

    public void setHead(Long head) {
        this.head = head;
    }
}
