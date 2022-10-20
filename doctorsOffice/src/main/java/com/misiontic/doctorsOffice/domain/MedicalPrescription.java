package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "medicalprescriptions")
public class MedicalPrescription implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicalprescription_id")
    private Integer medicalprescriptionId;
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "amount_medicines")
    private Integer amountMedicines;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public MedicalPrescription() {
    }

    public MedicalPrescription(Integer medicalprescriptionId, String date, Integer amountMedicines, Patient patient, Doctor doctor) {
        this.medicalprescriptionId = medicalprescriptionId;
        this.date = date;
        this.amountMedicines = amountMedicines;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getMedicalprescriptionId() {
        return medicalprescriptionId;
    }

    public void setMedicalprescriptionId(Integer medicalprescriptionId) {
        this.medicalprescriptionId = medicalprescriptionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmountMedicines() {
        return amountMedicines;
    }

    public void setAmountMedicines(Integer amountMedicines) {
        this.amountMedicines = amountMedicines;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    
    
}
