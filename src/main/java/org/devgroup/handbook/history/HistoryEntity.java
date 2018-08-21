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

   public Long getId() {
      return id;
   }


   public String getEvent() {
      return event;
   }

   public void setEvent(String event) {
      this.event = event;
   }

   public EmployeeEntity getEmployee() {
      return employee;
   }

   public void setEmployee(EmployeeEntity employee) {
      this.employee = employee;
   }

   public Date getDateStart() {
      return dateStart;
   }

   public void setDateStart(Date dateStart) {
      this.dateStart = dateStart;
   }

   public Date getDateEnd() {
      return dateEnd;
   }

   public void setDateEnd(Date dateEnd) {
      this.dateEnd = dateEnd;
   }
}
