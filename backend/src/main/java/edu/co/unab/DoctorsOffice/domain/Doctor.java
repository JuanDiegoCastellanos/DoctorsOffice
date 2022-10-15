package edu.co.unab.DoctorsOffice.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="DOCTORS")
public class Doctor  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;

    @Column(name="doctor_name", nullable = false)
    private String doctorName;

    @Column(name="doctor_lastname", nullable = false)
    private String doctorLastname;

    @Column(name="doctor_age", nullable = false)
    private String doctorAge;

    @Column(name="doctor_gender", nullable = false)
    private String doctorGender;

    @Column(name="doctor_document", nullable = false)
    private String doctorDocument;

    @Column(name="doctor_documentType", nullable = false)
    private String doctorDocumentType;

    @Column(name="doctor_phoneNumber", nullable = false)
    private String doctorPhoneNumber;

    //@OneToMany(mappedBy = "doctor")
    //List<Schedule> scheduleList;


}
