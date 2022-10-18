package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, String patientLastname, String patientAge, String patientGender, String patientDocument, String patientDocumentType, String patientPhoneNumber, String patientEps) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientLastname = patientLastname;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientDocument = patientDocument;
        this.patientDocumentType = patientDocumentType;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientEps = patientEps;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getPatientDocumentType() {
        return patientDocumentType;
    }

    public void setPatientDocumentType(String patientDocumentType) {
        this.patientDocumentType = patientDocumentType;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientEps() {
        return patientEps;
    }

    public void setPatientEps(String patientEps) {
        this.patientEps = patientEps;
    }
    
    
    

}
