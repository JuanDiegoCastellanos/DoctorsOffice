package edu.co.unab.DoctorsOffice.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "PATIENTS")
public class Patient implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;
    
    @Column(name="patient_name",nullable = false)
    private String  patientName;
    
    @Column(name="patient_lastname", nullable = false)
    private String patientLastname;
    
    @Column(name="patient_age", nullable = false)
    private String patientAge;
    
    @Column(name="patient_gender", nullable = false)
    private String patientGender;
    
    @Column(name="patient_document", nullable = false)
    private String patientDocument;
    
    @Column(name="patient_documentType", nullable = false)
    private String patientDocumentType;
    
    @Column(name="patient_phoneNumber", nullable = false)
    private String patientPhoneNumber;
    
    @Column(name="patient_eps", nullable = false)
    private String patientEps;

}
