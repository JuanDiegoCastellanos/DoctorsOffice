package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity(name="patients")
public class Patient implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;
    
    @Column(name="patient_name")
    private String  patientName;
    
    @Column(name="patient_lastname")
    private String patientLastname;
    
    @Column(name="patient_age")
    private Integer patientAge;
    
    @Column(name="patient_gender")
    private Integer patientGender;
    
    @Column(name="patient_document")
    private String patientDocument;
    
    @Column(name="patient_document_type")
    private String patientDocumentType;
    
    @Column(name="patient_phone_number")
    private String patientPhoneNumber;
    
    @Column(name="patient_eps")
    private String patientEps;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, String patientLastname, Integer patientAge, Integer patientGender, String patientDocument, String patientDocumentType, String patientPhoneNumber, String patientEps) {
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

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Integer getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Integer patientGender) {
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
