package org.devgroup.handbook.certificate.model;

import org.devgroup.handbook.employee.model.EmployeeEntity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "certificates")
public class CertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "employee", nullable = false)
    private EmployeeEntity employee;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "scan")
    private Blob scan;

}
