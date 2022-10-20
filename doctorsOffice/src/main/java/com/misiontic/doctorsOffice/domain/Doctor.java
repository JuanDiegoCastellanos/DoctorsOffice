
package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="doctors")
public class Doctor implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private Integer doctorId;
    
    @Column(name="doctor_name")
    private String doctorName;

    @Column(name="doctor_lastname")
    private String doctorLastname;

    @Column(name="doctor_age")
    private Integer doctorAge;

    @Column(name="doctor_gender")
    private Integer doctorGender;

    @Column(name="doctor_document")
    private String doctorDocument;

    @Column(name="doctor_documentType")
    private String doctorDocumentType;

    @Column(name="doctor_phoneNumber")
    private String doctorPhoneNumber;

    public Doctor() {
    }

    public Doctor(Integer doctorId, String doctorName, String doctorLastname, Integer doctorAge, Integer doctorGender, String doctorDocument, String doctorDocumentType, String doctorPhoneNumber) {
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

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public Integer getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(Integer doctorGender) {
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
