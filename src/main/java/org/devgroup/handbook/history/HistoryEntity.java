package org.devgroup.handbook.history;


import org.devgroup.handbook.employee.model.EmployeeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

//import javax.persistence.*;
@Entity
@Table(name = "history")
 public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "event")
    private String event;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @NotNull
    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @NotNull
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;
}
