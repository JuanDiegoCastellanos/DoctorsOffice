package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="medicines")
public class Medicine implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="medicine_id")
    private Integer medicineId;
    
    @Column(name= "medicine_name")
    private String medicineName;
    
    @Column(name = "laboratory")
    private String laboratory;

    public Medicine() {
    }

    public Medicine(Integer medicineId, String medicineName, String laboratory) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.laboratory = laboratory;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }
    
    
    
}
