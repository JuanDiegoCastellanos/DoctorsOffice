package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.MedicalPrescription;
import java.util.List;

public interface IMedicalPrescriptionService {
    
    public MedicalPrescription save(MedicalPrescription medicalPrescription);
    public void delete(Integer medicalPrescriptionId);
    public MedicalPrescription findById(Integer medicalPrescriptionId);
    public List<MedicalPrescription> findAll();
}
