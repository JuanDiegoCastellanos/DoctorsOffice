
package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCTORS")
public class Doctor implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
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

    public Doctor() {
    }

    public Doctor(Integer doctorId, String doctorName, String doctorLastname, String doctorAge, String doctorGender, String doctorDocument, String doctorDocumentType, String doctorPhoneNumber) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorLastname = doctorLastname;
        this.doctorAge = doctorAge;
        this.doctorGender = doctorGender;
        this.doctorDocument = doctorDocument;
        this.doctorDocumentType = doctorDocumentType;
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorLastname() {
        return doctorLastname;
    }

    public void setDoctorLastname(String doctorLastname) {
        this.doctorLastname = doctorLastname;
    }

    public String getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(String doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorDocument() {
        return doctorDocument;
    }

    public void setDoctorDocument(String doctorDocument) {
        this.doctorDocument = doctorDocument;
    }

    public String getDoctorDocumentType() {
        return doctorDocumentType;
    }

    public void setDoctorDocumentType(String doctorDocumentType) {
        this.doctorDocumentType = doctorDocumentType;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }
    
    
    
}
