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

@Entity
@Table(name="MEDICINESPRESCRIPTIONS")
public class MedicinePrescription implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "medicineprescription_id")
    private Integer medicinePrecriptionId;
    
    @ManyToOne
    @JoinColumn(name = "medicalprescription_id")
    private MedicalPrescription medicalPrescription;
    
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public MedicinePrescription() {
    }

    public MedicinePrescription(Integer medicinePrecriptionId, MedicalPrescription medicalPrescription, Medicine medicine) {
        this.medicinePrecriptionId = medicinePrecriptionId;
        this.medicalPrescription = medicalPrescription;
        this.medicine = medicine;
    }

    public Integer getMedicinePrecriptionId() {
        return medicinePrecriptionId;
    }

    public void setMedicinePrecriptionId(Integer medicinePrecriptionId) {
        this.medicinePrecriptionId = medicinePrecriptionId;
    }

    public MedicalPrescription getMedicalPrescription() {
        return medicalPrescription;
    }

    public void setMedicalPrescription(MedicalPrescription medicalPrescription) {
        this.medicalPrescription = medicalPrescription;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    
    
}
