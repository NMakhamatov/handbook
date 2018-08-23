package ru.tsc.practice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Employee {
    private long id;
    private String name;
    private String surname;
    private String patronimyc;
    private String gender;
    private Date birthDate;
    private Department department;
    private Position position;
    private int grade;
    private BigDecimal salary;
    private List<Certificate> certificates;

}
